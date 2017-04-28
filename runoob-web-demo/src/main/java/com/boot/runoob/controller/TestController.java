package com.boot.runoob.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵秀非 E-mail:zhaoxiufei@gmail.com
 * @version 创建时间：2017/4/28 16:42
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("index")
    public String index(){
        return "success";
    }
}
