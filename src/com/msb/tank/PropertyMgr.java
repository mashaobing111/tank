package com.msb.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: msb
 * @date: 2022/10/29 - 10 - 29 - 14:46
 * @description: com.msb.tank
 * @version: 1.0
 */
public class PropertyMgr {
    static Properties props = new Properties();
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if (props == null ) return null;
        return props.get(key);
    }
}

