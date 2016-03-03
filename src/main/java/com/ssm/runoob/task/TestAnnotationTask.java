package com.ssm.runoob.task;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Phil on 2016/3/2.
 */
@Component
@Lazy(value = false)
@EnableScheduling
public class TestAnnotationTask {
    private static final Logger logger = Logger.getLogger(TestAnnotationTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        @Scheduled(cron = "*/30 * * * * ?")
//    @Scheduled(cron = "0 5 11 * * ?") //
    public void reportCurrentTime() {

        logger.debug(String.format(" 定时任务：The time is now %s ", dateFormat.format(new Date())));
    }

}
