package com.ssm.runoob.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public Object getTest(String value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key_1",value);
        return jsonObject;
    }
}
