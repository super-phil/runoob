package com.ssm.runoob.shiro;

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

    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private int defaultExpireTime = 3600;


    @Override
    protected void doUpdate(Session session) {
        //该方法交给父类去执行
    }

    @Override
    protected void doDelete(Session session) {
        Serializable sessionId = session.getId();
//        cm = CacheManager.create();
//        if(cm==null){
//            cm = new CacheManager(getCacheManagerConfigFileInputStream());
//        }
//        Ehcache ehCache = cm.getCache("sessioncache");
        redisTemplate.delete(sessionId.toString());
//        ehCache.remove(sessionId.toString());
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
//        cm = CacheManager.create();
//        if(cm==null){
//            cm = new CacheManager(getCacheManagerConfigFileInputStream());
//        }
//        Ehcache ehCache = cm.getCache("sessioncache");
        assignSessionId(session, sessionId);
        redisTemplate.opsForValue().set(sessionId.toString(), session);
        redisTemplate.expire(sessionId.toString(), this.defaultExpireTime, TimeUnit.SECONDS);
//        ehCache.put(new Element(sessionId.toString(),session));
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        //此方法不会执行，不用管
        return null;
    }
//
//    protected InputStream getCacheManagerConfigFileInputStream() {
//        String configFile = "classpath:ehcache.xml";
//        try {
//            return ResourceUtils.getInputStreamForPath(configFile);
//        } catch (IOException e) {
//            throw new ConfigurationException("Unable to obtain input stream for cacheManagerConfigFile [" +
//                    configFile + "]", e);
//        }
//    }
}
