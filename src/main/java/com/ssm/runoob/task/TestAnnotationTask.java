package com.ssm.runoob.task;

import com.ssm.runoob.service.UserService;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Phil on 2016/3/2.
 */
@Component
@Lazy(value = false)
@EnableScheduling
public class TestAnnotationTask {
    private static final Logger logger = Logger.getLogger(TestAnnotationTask.class);

    private static Random random = new Random();
    @Autowired
    private UserService userService;
        @Scheduled(cron = "15 * * * * ?")
//    @Scheduled(cron = "0 5 11 * * ?") //
    public void reportCurrentTime() {
//            for (int i = 0; i <random.nextInt(20) ; i++) {
//                User user = new User();
//                user.setMobile("1368754875"+i);
//                user.setEmail("71"+i+"@163.com");
//                user.setName("Nk_"+i);
//                user.setPwd("xxxxxx"+i);
//                userService.insert(user);
//            }
        logger.debug(String.format(" 定时任务：The timec is now %s ", new DateTime().toString("a hh:mm:ss")));
    }

}
