//package com.boot.runoob.config;
//
//import com.xyauto.domain.UserInfo;
//import com.xyauto.util.Constants;
//import com.xyauto.util.UserUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Created by zhangmg on 2017/3/27.
// */
//@Slf4j
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String uri = request.getRequestURI();
//        if (uri.startsWith("/oa/employeeByDept/")
//                ||uri.startsWith("/plan/getLoginIcon")) {
//            return true;//优化性能
//        }
//        long preTime = System.currentTimeMillis();
//        Boolean back = true;
//        UserInfo userInfo = UserUtil.checkLoginUser();
//        HttpSession session = request.getSession();
//        if (null == userInfo) {
//            session.invalidate();
//            response.sendRedirect(Constants.LOGIN_URL);
//            back = false;
//        } else {
//            back = true;
//            session.setAttribute(Constants.SESSION_USER, userInfo);
//            log.debug("LoginUser: " + userInfo.toString());
//        }
//        long postTime = System.currentTimeMillis();
//        log.debug("Interceptor time:" + (postTime - preTime) + "ms");
//        return back;
//    }
//}
