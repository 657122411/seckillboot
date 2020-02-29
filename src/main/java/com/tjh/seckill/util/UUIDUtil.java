package com.tjh.seckill.util;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UUIDUtil {

    //去除原生横杠
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
