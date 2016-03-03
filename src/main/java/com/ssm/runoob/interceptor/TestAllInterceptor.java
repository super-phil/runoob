package com.ssm.runoob.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
public class TestAllInterceptor implements HandlerInterceptor {
    private final Logger logger = Logger.getLogger(this.getClass());
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.debug("TestAllInterceptor test preHandle! URL:-->"+httpServletRequest.getRequestURI());
//        logger.debug();
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.debug("TestAllInterceptor test postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.debug("TestAllInterceptor test afterCompletion");
    }
}
