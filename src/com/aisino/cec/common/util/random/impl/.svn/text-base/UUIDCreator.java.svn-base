package com.aisino.cec.common.util.random.impl;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.aisino.cec.common.util.random.IMajorKey;

/**
 * 生成UUID型主键
 * 
 * @author zhaoTh
 */
@Component(value = "primaryKey")
public class UUIDCreator implements IMajorKey {
	
    @Override
    public String getMajorKey() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid;
    }
}
