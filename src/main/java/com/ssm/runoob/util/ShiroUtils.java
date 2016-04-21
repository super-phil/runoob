package com.ssm.runoob.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Phil on 2016/4/21.
 */
public class ShiroUtils {
    private static final Logger logger = Logger.getLogger(ShiroUtils.class);
    private static Map<String, String> defaultFilterChainDefinitionMap = new LinkedHashMap<>();
    private static Properties prop = null;

    private ShiroUtils() {
    }

    static {
        try {
            InputStream is = ConfigUtils.class.getClassLoader().getResourceAsStream("shiro.ini");
            prop = new Properties();
            prop.load(is);
            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                defaultFilterChainDefinitionMap.put(entry.getKey().toString().trim(), entry.getValue().toString().trim());
            }
            is.close();
        } catch (IOException e) {
            logger.error("load shiro.ini error", e);
            e.printStackTrace();
        }
    }

    public static Map<String, String> getDefaultFilterChainDefinitionMap() {
        return defaultFilterChainDefinitionMap;
    }

    public static void main(String[] args) {
        ShiroUtils.getDefaultFilterChainDefinitionMap();
    }
}
