package com.ssm.runoob.service;

import com.alibaba.fastjson.JSON;
import com.ssm.runoob.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;

import java.util.Date;
import java.util.Locale;

/**
 * Created by Phil on 2016/2/25.
 */
public class TestServiceTest extends BaseTest {
    @Autowired
    private TestService testService;
    private static final Logger LOG = Logger.getLogger(TestServiceTest.class);

    @Test
    public void testGetTest() throws Exception {
        LOG.info(JSON.toJSONString(testService.getTest("xxx")));
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ss");
        LOG.info(dateFormatter.print(new Date(), Locale.CHINA));
    }
}