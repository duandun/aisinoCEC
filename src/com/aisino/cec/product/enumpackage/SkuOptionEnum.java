package com.aisino.cec.product.enumpackage;

/**
 * sku属性值状态枚举
 * 
 * @author leo
 */
public enum SkuOptionEnum {

    // sku属性值启用状态
    SKU_OPTION_ENABLE("sku_option_enable", "启用"),
    // sku属性值禁用状态
    SKU_OPTION_DISABLE("sku_option_disable", "禁用"),
    // sku属性值删除状态
    SKU_OPTION_DELETED("sku_option_deleted", "删除");

    // 成员变量
    private final String key;

    private final String value;

    SkuOptionEnum(String key, String value) {
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
