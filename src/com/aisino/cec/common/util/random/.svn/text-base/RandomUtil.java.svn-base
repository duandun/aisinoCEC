package com.aisino.cec.common.util.random;

import java.util.UUID;

import com.aisino.cec.common.util.security.Security;

/**
 * 随机字符串产生工具
 * 
 * @author zhaoTh
 */
public final class RandomUtil {

    /**
     * 取UUID字符串
     * 
     * @return UUID字符串
     */
    public static String getUUIDString() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid;
    }

    /**
     * 随机产生16位字符串
     * 
     * @return 16位字符串
     */
    public static String getRandom16String() {
        String md5Value = Security.MD5Encode(getUUIDString());
        String shortMD5Value = md5Value.substring(8, 24).toUpperCase();
        return shortMD5Value;
    }
}
