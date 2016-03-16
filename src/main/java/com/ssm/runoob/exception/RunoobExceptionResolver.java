package com.ssm.runoob.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
public class RunoobExceptionResolver implements HandlerExceptionResolver {
    private final Logger logger = Logger.getLogger(this.getClass());
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        logger.debug("RunoobExceptionResolver");
        e.printStackTrace();

        if (e instanceof NullPointerException){
            logger.error("NullPointerException",e);
            return new ModelAndView("404");
        }
        return new ModelAndView("505");
    }
}
