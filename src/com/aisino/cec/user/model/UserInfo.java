package com.aisino.cec.user.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户信息model
 * 
 * @author leo
 */
public class UserInfo {

    /** 用户信息id */
    private String userInfoId;

    /** 用户id */
    private String userId;

    /** 用户姓名 */
    @NotEmpty
    @Size(min = 2, max = 4)
    private String userRealName;

    /** 用户性别 */
    private String userGender;

    /** 用户职位 */
    private String userPosition;

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

}
