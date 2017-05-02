package com.boot.runoob.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵秀非 E-mail:zhaoxiufei@gmail.com
 * @version 创建时间：2017/4/28 16:42
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("index")
    public String index() {
        return "success";
    }

    @GetMapping("list")
    public Object list(@RequestParam("draw") int draw) {
        JSONObject data = new JSONObject();
        data.put("code", 0);
        data.put("code", 0);
        data.put("draw", draw);
        data.put("recordsTotal", 50);
        data.put("recordsFiltered", 50);
        JSONArray obs = new JSONArray();
        data.put("data", obs);
        for (int i = 0; i < 10; i++) {
            JSONObject jo = new JSONObject();
            jo.put("id", i);
            jo.put("name", "name_" + i);
            jo.put("address", "address_" + i);
            obs.add(jo);
        }
        return data;
    }

}
