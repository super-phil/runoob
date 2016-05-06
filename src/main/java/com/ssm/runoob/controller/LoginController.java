package com.ssm.runoob.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Phil on 2016/4/14.
 */
@Controller
public class LoginController {

    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String index() {
        return "login";
    }


    /**
     * Login object.
     *
     * @param mobile   the mobile
     * @param password the password
     * @param request  the request
     * @return the object
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object login(
            @RequestParam(value = "mobile") String mobile,
            @RequestParam(value = "password") String password,
            HttpServletRequest request) {

//        创建令牌
        AuthenticationToken authenticationToken = new UsernamePasswordToken(mobile, password);
//      得到subject(主体对象，对当前用户的一个封装，提供一些列的方法，供程序调用)
        Subject subject = SecurityUtils.getSubject();
//      执行认证(判断用户名是否正确)

        try {
            subject.login(authenticationToken);
            request.getSession().setAttribute("user", subject.getPrincipal());//登陆成功存session
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);//如果是未登录 点链接进来的 (也就是上次访问的地址)
            if (null != savedRequest) {
                String requestURI = savedRequest.getRequestURI();
                return "redirect:" + requestURI;//重定向上次访问的页面
            } else {
                return "redirect:/index";
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("mobile", mobile);
            modelAndView.addObject("msg", "用户名或密码不正确");
            return modelAndView;
        }
    }

    /**
     * Logout string.
     *
     * @return the string
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {

        SecurityUtils.getSubject().logout();
        return "redirect:/index";
    }
}
