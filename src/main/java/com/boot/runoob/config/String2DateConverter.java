//package com.boot.runoob.config;
//
//import com.xyauto.util.DateUtils;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.util.Date;
//
///**
// * 全局日期转换器
// *
// * @author 赵秀非 E-mail:zhaoxiufei@gmail.com
// * @version 创建时间：2017/3/23 11:54
// */
//@Component
//public class String2DateConverter implements Converter<String, Date> {
//    @Override
//    public Date convert(String s) {
//        if (StringUtils.hasText(s)) {
//            if(s.matches("\\d{4}-\\d{1,2}-\\d{1,2}")){
//                return DateUtils.str2Date(s,"yyyy-MM-dd");
//            }
//            return DateUtils.str2Date(s);
//        }
//        return null;
//    }
//}
