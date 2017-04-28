//package com.boot.runoob.config;
//
//import com.xyauto.util.ResultUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.dao.DataAccessException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 全局异常lan拦截器
// * BindException  400 (Bad Request)
// * <p>
// * ConversionNotSupportedException 500 (Internal Server Error)
// * <p>
// * HttpMediaTypeNotAcceptableException 406 (Not Acceptable)
// * <p>
// * HttpMediaTypeNotSupportedException 415 (Unsupported Media Type)
// * <p>
// * HttpMessageNotReadableException 400 (Bad Request)
// * <p>
// * HttpMessageNotWritableException 500 (Internal Server Error)
// * <p>
// * HttpRequestMethodNotSupportedException 05 (Method Not Allowed)
// * <p>
// * MethodArgumentNotValidException 400 (Bad Request)
// * <p>
// * MissingPathVariableException 500 (Internal Server Error)
// * <p>
// * MissingServletRequestParameterException 400 (Bad Request)
// * <p>
// * MissingServletRequestPartException 400 (Bad Request)
// * <p>
// * NoHandlerFoundException 404 (Not Found)
// * <p>
// * NoSuchRequestHandlingMethodException 404 (Not Found)
// * <p>
// * TypeMismatchException 400 (Bad Request)
// * Created by zhaoxf on 2017/3/6.
// */
//@Slf4j
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity jsonErrorHandler(HttpServletRequest req, Exception e) {
//        //打印异常信息：
//        e.printStackTrace();
//        String message = e.getMessage();
//        log.error(">>> GlobalExceptionHandler msg={}<<<", message);
//        if (e instanceof DataAccessException) {
//            message = "数据库异常";
//        }
//        return ResponseEntity.badRequest().body(ResultUtils.error(message));
//
//
//    }
//}
