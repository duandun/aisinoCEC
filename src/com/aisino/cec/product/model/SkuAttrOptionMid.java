package com.aisino.cec.product.model;

public class SkuAttrOptionMid {
    private String skuAttrOptionMidId;

    private String queryValueId;

    private String skuAttrId;

    public String getSkuAttrOptionMidId() {
        return skuAttrOptionMidId;
    }

    public void setSkuAttrOptionMidId(String skuAttrOptionMidId) {
        this.skuAttrOptionMidId = skuAttrOptionMidId == null ? null : skuAttrOptionMidId.trim();
    }

    public String getQueryValueId() {
        return queryValueId;
    }

    public void setQueryValueId(String queryValueId) {
        this.queryValueId = queryValueId == null ? null : queryValueId.trim();
    }

    public String getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(String skuAttrId) {
        this.skuAttrId = skuAttrId == null ? null : skuAttrId.trim();
    }
}