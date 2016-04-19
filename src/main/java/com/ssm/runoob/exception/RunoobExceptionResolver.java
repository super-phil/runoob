package com.ssm.runoob.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.ssm.runoob.util.ResultUtils;
import com.ssm.runoob.util.WebUtils;
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
        logger.debug("RunoobExceptionResolver" + e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        boolean ajax = WebUtils.isAjax(httpServletRequest);
        if (ajax) {
            FastJsonJsonView view = new FastJsonJsonView();
            view.setAttributesMap(ResultUtils.error());
            modelAndView.setView(view);
            return modelAndView;
        } else {
            modelAndView.setViewName("404");
            return modelAndView;
        }
//        if (e instanceof NullPointerException){
//            logger.error("NullPointerException",e);
//
//        }
    }
}
