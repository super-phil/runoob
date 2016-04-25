package com.ssm.runoob.shiro;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Phil on 2016/4/25.
 */
public class RedisSessionDao extends CachingSessionDAO {
    private static final String REDIS_SHIRO_SESSION = "shiro-session:";
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, Session> redisTemplate;
    private int defaultExpireTime = 3600;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        redisTemplate.opsForValue().set(REDIS_SHIRO_SESSION + sessionId, session);
        redisTemplate.expire(REDIS_SHIRO_SESSION + sessionId, this.defaultExpireTime, TimeUnit.SECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = redisTemplate.opsForValue().get(REDIS_SHIRO_SESSION + sessionId);
        logger.info("#############" + JSON.toJSONString(session) + "###########");
        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        redisTemplate.boundValueOps(REDIS_SHIRO_SESSION + session.getId()).set(session, this.defaultExpireTime, TimeUnit.SECONDS);
    }


    @Override
    protected void doDelete(Session session) {
        redisTemplate.boundValueOps(REDIS_SHIRO_SESSION + session.getId()).set(session, this.defaultExpireTime, TimeUnit.SECONDS);
    }

}
