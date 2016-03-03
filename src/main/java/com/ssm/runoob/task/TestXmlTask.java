package com.ssm.runoob.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Phil on 2016/3/3.
 */
public class TestXmlTask {
    private static final Logger logger = Logger.getLogger(TestXmlTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public void reportCurrentTime() {

        logger.debug(String.format(" 定时任务：The time is now %s ", dateFormat.format(new Date())));
    }
}
