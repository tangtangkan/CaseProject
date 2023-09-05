package com.ttk.examplecase.customuniqueid;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 唯一ID生成工具类
 * 固定字符+日期+三位递增数字
 */
@Component
public class UniqueIDRedisUtil {

    @Resource
    private RedisTemplate redisTemplate;

    // 前缀
    private static final String PREFIX = "GG";
    // 年月日
    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    // 序号位数
    private static final int PADDING_LENGTH = 3;
    // rediskey过期时间
    private static final Long EXPIRATION_TIME = 86400l;
    // 每日新建公告数量上限
    private static final int MOST = 999;

    public String generateID() {

        StringBuilder builderkey = new StringBuilder();
        builderkey.append(PREFIX);
        builderkey.append(dateFormat.format(new Date()));

        // 序号key值
        Long value = redisTemplate.opsForValue().increment(builderkey.toString());

        if (value > MOST) {
            redisTemplate.opsForValue().decrement(builderkey.toString());
            throw new RuntimeException("每天新建公告数量最多999条, 今日已达上限");
        }

        // 设置过期时间24小时
        redisTemplate.expire(builderkey.toString(), EXPIRATION_TIME, TimeUnit.SECONDS);

        return builderkey.append(String.format("%0" + PADDING_LENGTH + "d", value)).toString();
    }

}
