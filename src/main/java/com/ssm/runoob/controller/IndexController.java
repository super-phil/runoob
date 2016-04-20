package com.ssm.runoob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Phil on 2016/4/20.
 */
@Controller
@RequestMapping("index")
public class IndexController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
