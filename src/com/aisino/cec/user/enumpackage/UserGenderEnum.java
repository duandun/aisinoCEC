package com.aisino.cec.user.enumpackage;

/**
 * 用户性别枚举
 * 
 * @author leo
 */
public enum UserGenderEnum {

    MALE("男", "male"),

    FEMALE("女", "female");

    // 成员变量
    private final String key;

    private final String value;

    UserGenderEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
