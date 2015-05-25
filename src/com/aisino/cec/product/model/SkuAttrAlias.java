package com.aisino.cec.product.model;

import java.util.Date;

public class SkuAttrAlias {
    private String skuAttrAliasId;
    
    private String skuAttrId;

	private String frontName;

    private String storeName;

    private String state;

    private String serialNum;

    private String sellerId;

    private String createUserId;

    private Date createTime;

    private String modifyUserId;

    private Date modifyTime;

    private String modifyInfo;

    public String getSkuAttrAliasId() {
        return skuAttrAliasId;
    }

    public void setSkuAttrAliasId(String skuAttrAliasId) {
        this.skuAttrAliasId = skuAttrAliasId == null ? null : skuAttrAliasId.trim();
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName == null ? null : frontName.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyInfo() {
        return modifyInfo;
    }

    public void setModifyInfo(String modifyInfo) {
        this.modifyInfo = modifyInfo == null ? null : modifyInfo.trim();
    }
    

    public String getSkuAttrId() {
		return skuAttrId;
	}

	public void setSkuAttrId(String skuAttrId) {
		this.skuAttrId = skuAttrId;
	}
}