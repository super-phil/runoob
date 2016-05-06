package com.ssm.runoob.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
@Component
@Aspect
public class TestAop {
    private static final Logger logger = Logger.getLogger(TestAop.class);

    /**
     * My around advice object.
     *
     * @param jionpoint the jionpoint
     * @return the object
     * @throws Throwable the throwable
     */
    @Around(value = "execution(* com.ssm.runoob.service.*.*(..))")
    public Object myAroundAdvice(ProceedingJoinPoint jionpoint) throws Throwable {
        // 获取被调用的方法名
        String targetMethodName = jionpoint.getSignature().getName();
        String logInfoText = "这是环绕通知 执行方法前面：" + targetMethodName;
        logger.info(logInfoText);
        Object o = jionpoint.proceed();
        logInfoText = "这是环绕通知 执行方法后面：" + targetMethodName;
        logger.info(logInfoText);
        //Object o = jionpoint.proceed();//注意写到这儿的话，环绕通知和其它通知的顺序
        return o;
    }
}
