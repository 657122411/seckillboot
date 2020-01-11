package com.tjh.seckill.redis;

/**
 * 分模块控制key保证不冲突，同时控制过期时间
 */
public interface KeyPrefix {

    //有效期
    public int expireSeconds();

    public String getPrefix();
}
