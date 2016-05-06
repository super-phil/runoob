package com.ssm.runoob.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssm.runoob.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
@Service
public class TestServiceImpl implements TestService {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Ini.
     */
    @PostConstruct
    public void ini() {
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
        logger.info("#############ini###########");
    }

    @Override
    public Object getTest(String value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key_1", value);
        return jsonObject;
    }
}
