package com.aisino.cec.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户账户相关的model
 * @author lxy
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User implements Serializable{
    
    
    /** 主键 */
    private String userId;
    
    /** 登录账号 */
    @NotNull
    @Size(min=6, max=25)
    private String userName;
    
    /** 登录密码 */
    @NotNull
    @Size(min=6, max=32)
    private String userPasswd;
    
    /** 电子邮箱地址 */
    private String userEmail;
    
    /** 手机号码*/
    private String userPhone;
    
    /** 注册来源：邮箱注册或者手机注册标志物*/
    private String registerSourceFlag;
    
    /** 企业名称*/
    @NotNull
    @Size(max=64)
    private String enterpriseName;
    
    /** 激活码 */
    private String verifyCode;
    
    /** 激活码有效时间*/
    private Date verifyCodeValidTime;  
    
    /** 注册时间*/
    private Date registerDate;
    
    /** 账号状态（未激活、正常、锁定（两个小时内，连续五次登录信息（用户名/密码）错误）、禁用（平台管理员禁用的用户）、注销*/
    private String userStatus;
    
    /** 企业用户或者个人用户标志位*/
    private String userFlag;
    
    /** 是否冻结状态（暂时没有用，后面如果涉及到用户支付账户的时候，应该会用到。）*/
    private String freezeFlag;
    
    /** 企业ID */
    private String enterpriseId;
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserPasswd() {
        return userPasswd;
    }
    
    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    public String getUserPhone() {
        return userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    public String getRegisterSourceFlag() {
        return registerSourceFlag;
    }
    
    public void setRegisterSourceFlag(String registerSourceFlag) {
        this.registerSourceFlag = registerSourceFlag;
    }
    
    public String getEnterpriseName() {
        return enterpriseName;
    }
    
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
    public String getVerifyCode() {
        return verifyCode;
    }
    
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    
    public Date getVerifyCodeValidTime() {
        return verifyCodeValidTime;
    }
    
    public void setVerifyCodeValidTime(Date verifyCodeValidTime) {
        this.verifyCodeValidTime = verifyCodeValidTime;
    }
    
    public Date getRegisterDate() {
        return registerDate;
    }
    
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    
    public String getUserStatus() {
        return userStatus;
    }
    
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    
    public String getUserFlag() {
        return userFlag;
    }
    
    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }
    
    public String getFreezeFlag() {
        return freezeFlag;
    }
    
    public void setFreezeFlag(String freezeFlag) {
        this.freezeFlag = freezeFlag;
    }
    
    public String getEnterpriseId() {
        return enterpriseId;
    }
    
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
    
    
}
