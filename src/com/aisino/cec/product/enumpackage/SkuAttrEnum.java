package com.aisino.cec.product.enumpackage;

/**
 * sku属性状态枚举
 * 
 * @author leo
 */
public enum SkuAttrEnum {

    // sku属性启用状态
    SKU_ATTR_ENABLE("sku_attr_enable", "启用"),
    // sku属性禁用状态
    SKU_ATTR_DISABLE("sku_attr_disable", "禁用"),
    // sku属性删除状态
    SKU_ATTR_DELETED("sku_attr_deleted", "删除"),
    // sku判断条件是（是否为查询属性，是否为组合属性，是否为生成必选项）
    SKU_TRUE("sku_true", "是"),
    // sku判断条件否（是否为查询属性，是否为组合属性，是否为生成必选项）
    SKU_FALSE("sku_false", "否");

    // 成员变量
    private final String key;

    private final String value;

    SkuAttrEnum(String key, String value) {
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
