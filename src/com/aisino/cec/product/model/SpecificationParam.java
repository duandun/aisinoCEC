package com.aisino.cec.product.model;

import java.util.Date;

public class SpecificationParam {
    private String specificationParamId;

    private String categoryId;

    private String specificationCategoryId;

    private String name;

    private String descInfo;

    private String state;

    private String serialNum;

    private String ifQuery;

    private String ifRequired;

    private String typeInfo;

    private Date createTime;

    private String createUserId;

    private Date modifyTime;

    private String modifyUserId;

    private String modifyInfo;

    private String value;

    public String getSpecificationParamId() {
        return specificationParamId;
    }

    public void setSpecificationParamId(String specificationParamId) {
        this.specificationParamId = specificationParamId == null ? null : specificationParamId.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getSpecificationCategoryId() {
        return specificationCategoryId;
    }

    public void setSpecificationCategoryId(String specificationCategoryId) {
        this.specificationCategoryId = specificationCategoryId == null ? null : specificationCategoryId.trim();
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

    public String getIfQuery() {
        return ifQuery;
    }

    public void setIfQuery(String ifQuery) {
        this.ifQuery = ifQuery == null ? null : ifQuery.trim();
    }

    public String getIfRequired() {
        return ifRequired;
    }

    public void setIfRequired(String ifRequired) {
        this.ifRequired = ifRequired == null ? null : ifRequired.trim();
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo == null ? null : typeInfo.trim();
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}