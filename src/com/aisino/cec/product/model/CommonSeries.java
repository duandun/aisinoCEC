package com.aisino.cec.product.model;

import java.math.BigDecimal;
import java.util.Date;

public class CommonSeries {
    private String commonSeriesId;

    private String categoryId;

    private String name;

    private String descInfo;

    private String disclaimer;

    private String ad;

    private String state;

    private String sellerId;

    private Date createTime;

    private String createUserId;

    private Date modifyTime;

    private String modifyUserId;

    private String modifyInfo;

    private String priceParamId;

    private BigDecimal marketPrice;

    private BigDecimal platformPrice;

    private String imageGroupStr;

    private String unitId;

    private String stateValue;

    public String getCommonSeriesId() {
        return commonSeriesId;
    }

    public void setCommonSeriesId(String commonSeriesId) {
        this.commonSeriesId = commonSeriesId == null ? null : commonSeriesId.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo == null ? null : descInfo.trim();
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer == null ? null : disclaimer.trim();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad == null ? null : ad.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

    public String getModifyInfo() {
        return modifyInfo;
    }

    public void setModifyInfo(String modifyInfo) {
        this.modifyInfo = modifyInfo == null ? null : modifyInfo.trim();
    }

    public String getPriceParamId() {
        return priceParamId;
    }

    public void setPriceParamId(String priceParamId) {
        this.priceParamId = priceParamId == null ? null : priceParamId.trim();
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getPlatformPrice() {
        return platformPrice;
    }

    public void setPlatformPrice(BigDecimal platformPrice) {
        this.platformPrice = platformPrice;
    }

    public String getImageGroupStr() {
        return imageGroupStr;
    }

    public void setImageGroupStr(String imageGroupStr) {
        this.imageGroupStr = imageGroupStr == null ? null : imageGroupStr.trim();
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    public String getStateValue() {
        return stateValue;
    }

    public void setStateValue(String stateValue) {
        this.stateValue = stateValue == null ? null : stateValue.trim();
    }
}