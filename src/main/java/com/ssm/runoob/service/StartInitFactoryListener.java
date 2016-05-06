package com.ssm.runoob.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by Phil on 2016/4/21.
 */
@Service
public class StartInitFactoryListener implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            logger.info("#############容器初始化以后执行###########");
            logger.info("#############onApplicationEvent###########");
            logger.info("#############容器初始化以后执行###########");
            logger.info("#############onApplicationEvent###########");
            logger.info("#############容器初始化以后执行###########");
        }

    }
}
