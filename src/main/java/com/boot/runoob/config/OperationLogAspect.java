//package com.boot.runoob.config;
//
//import com.xyauto.controller.dto.ProjectPlanDTO;
//import com.xyauto.domain.PPLog;
//import com.xyauto.domain.UserInfo;
//import com.xyauto.enums.ConstantsEnum;
//import com.xyauto.service.PPLogService;
//import com.xyauto.util.UserUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * @author 赵秀非 E-mail:zhaoxiufei@gmail.com
// * @version 创建时间：2017/3/23 16:42
// */
//@Slf4j
//@Aspect
//@Component
//public class OperationLogAspect {
//
//    @Resource
//    private PPLogService ppLogService;
//
//    /**
//     * 发起项目
//     */
//    @Pointcut("execution(* com.xyauto.controller.ProjectPlanController.add(..))")
//    private void add() {
//    }
//
//    /**
//     * 分配项目
//     */
//    @Pointcut("execution(* com.xyauto.controller.ProjectPlanController.assign(..))")
//    private void assign() {
//    }
//
//    /**
//     * 转让
//     */
//    @Pointcut("execution(* com.xyauto.controller.ProjectPlanController.transfer(..))")
//    private void transfer() {
//    }
//
//    /**
//     * 编辑
//     */
//    @Pointcut("execution(* com.xyauto.controller.ProjectPlanController.update(..))")
//    private void update() {
//    }
//
//    /**
//     * 关闭
//     */
//    @Pointcut("execution(* com.xyauto.controller.ProjectPlanController.close(..))")
//    private void close() {
//    }
//
//    /**
//     * 完成
//     */
//    @Pointcut("execution(* com.xyauto.controller.ProjectPlanController.complete(..))")
//    private void complete() {
//    }
//
//    @SuppressWarnings("all")
//    @Around(value = "add()||transfer()||assign()||update()||close()||complete()", argNames = "pjp")
//    public Object doAction(ProceedingJoinPoint pjp) throws Throwable {
//        Object o = pjp.proceed();
//        Object[] args = pjp.getArgs();
//        if (null != args && args.length > 0) {
//            for (Object oo : args) {
//                if (oo instanceof ProjectPlanDTO) {
//                    ppLogService.add(getPpLog(pjp, (ProjectPlanDTO) oo));
//                }
//                if (oo instanceof List) {
//                    for (Object ooo : ((List) oo)) {
//                        if (ooo instanceof ProjectPlanDTO) {
//                            ppLogService.add(getPpLog(pjp, (ProjectPlanDTO) ooo));
//                        }
//                    }
//                }
//            }
//        }
//        return o;
//    }
//
//    private PPLog getPpLog(ProceedingJoinPoint pjp, ProjectPlanDTO oo) throws Exception {
//        PPLog log = new PPLog();
//        log.setPpId(oo.getPpId());
//        log.setActionName(ConstantsEnum.ActionType.getTextByValue(pjp.getSignature().getName()));
//        UserInfo userInfo = UserUtil.getCurrentUser();
//        log.setExecutorName(userInfo.getRealName());
//        log.setExecDeptName(userInfo.getDepartmentName());
//        log.setRemark(oo.getPpDesc());
//        if (ConstantsEnum.ActionType.ASSIGN.getValue().equals(pjp.getSignature().getName())) {
//            //分配需要主项目也插入一条记录
//            PPLog clone = log.clone();
//            clone.setPpId(oo.getParentId());
//            ppLogService.add(clone);
//        }
//        return log;
//    }
//
//    @Pointcut("execution(* com.xyauto.controller..*.*(javax.servlet.http.HttpServletRequest,..)) && args(request,..)")
//    private void testAop(HttpServletRequest request) {
//    }
//
//    @Around(value = "testAop(request)", argNames = "pjp,request")
//    public Object doTestAop(ProceedingJoinPoint pjp, HttpServletRequest request) throws Throwable {
//        Object o = pjp.proceed();
//        log.info("method ={}", request.getMethod());
//        return o;
//    }
//}
