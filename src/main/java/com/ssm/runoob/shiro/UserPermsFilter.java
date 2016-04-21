package com.ssm.runoob.shiro;

import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.model.User;
import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义授权过滤器
 * Created by Phil on 2016/1/3.
 */
public class UserPermsFilter extends AuthorizationFilter {
    private static final Logger logger = Logger.getLogger(UserPermsFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object object) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.info("自定义授权过滤器!" + httpServletRequest.getRequestURI());
        //得到subject
        Subject subject = getSubject(servletRequest, servletResponse);
        //得到xml roles 中的权限
//        User user = (User) subject.getPrincipal();
//        if (user.getMode() == Constants.MODE_USER_ROOT) return true;//如果是超级管理员直接放行
        String[] perms = (String[]) object;
        boolean isPermitted = true;
        if (perms != null && perms.length != 0) {
            for (String perm : perms) {
                boolean permitted = subject.hasRole(perm);
                if (permitted) {
                    logger.info(String.format("有[%s]权限!", perm));
                    isPermitted = true;
                    break;
                } else {
                    logger.error(String.format("没有[%s]权限!", perm));
                    isPermitted = false;
                }
            }
        }
        return isPermitted;
    }

    /**
     * 复写 shiro onAccessDenied 扩展支持异步验证
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            if (isAjax(request)) {
                writeJson(response);
            } else {
                this.saveRequestAndRedirectToLogin(request, response);
            }
        } else {
            if (isAjax(request)) {
                writeJson(response);
            } else {
                String unauthorizedUrl = this.getUnauthorizedUrl();
                if (StringUtils.hasText(unauthorizedUrl)) {
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(response).sendError(401);
                }
            }
        }
        return false;
    }

    private boolean isAjax(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        return "XMLHttpRequest".equalsIgnoreCase(httpRequest.getHeader("X-Requested-With"));
    }

    private void writeJson(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        JSONObject jo = new JSONObject();
        jo.put("code", 1);
        jo.put("msg", "您没有权限操作,请联系管理员!");
        PrintWriter out = null;
        try {
            out = httpResponse.getWriter();
            out.write(jo.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
