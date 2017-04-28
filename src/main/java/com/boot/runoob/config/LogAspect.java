//package com.boot.runoob.config;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @author 赵秀非 E-mail:zhaoxiufei@gmail.com
// * @version 创建时间：2017/3/23 15:20
// *          日志
// *          Before：前置通知，在方法执行之前执行
// *          After：后置通知，在方法执行之后执行
// *          AfterRunning：返回通知，在方法返回结果之后执行
// *          AfterThrowing：异常通知，在方法抛出异常之后
// *          Around：环绕通知，围绕着方法执行
// */
//@Aspect
//@Component
//public class LogAspect {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    private ThreadLocal<Long> startTime = new ThreadLocal<>();
//
//    // 控制层调用切入点
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public void controllerPointcut() {
//    }
////    //service
////    @Pointcut("execution(* com.xyauto.service..*.*(..))")
////    public void servicePointcut() {
////    }
//
//    //database
//    @Pointcut("execution(* com.xyauto.mapper..*.*(..))")
//    public void databasePointcut() {
//    }
//
//    @Around("databasePointcut()")
//    public Object doDatabasePointcutAround(ProceedingJoinPoint pjp) throws Throwable {
//        return writeLog("database", pjp);
//    }
////    @Around("servicePointcut()")
////    public Object doServicePointcutAround(ProceedingJoinPoint pjp) throws Throwable {
////        return writeLog("service", pjp);
////    }
//
//    @Around("controllerPointcut()")
//    public Object doControllerPointcutAround(ProceedingJoinPoint pjp) throws Throwable {
//        return writeLog("controller", pjp);
//    }
//
//    private Object writeLog(String level, ProceedingJoinPoint pjp) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object result = pjp.proceed();
//        logger.info(">>> {level:{} method:{} speed:{}} <<<", level, pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName(), (System.currentTimeMillis() - startTime));
//        return result;
//    }
//
//}
