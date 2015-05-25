package com.aisino.cec.enterprise.model.authentication;

import java.util.Date;

/**
 * 申请成为卖家的认证相关信息：企业认证映射对象
 * 
 * @author zhaoTh
 */
public class AuthenticationInfo {

    /** 认证请求ID */
    private String authenticationId;

    /** 认证企业ID，这个关联的是Enterprise中的enterpriseID */
    private String enterpriseId;

    /** 认证企业名称（冗余） */
    private String enterpriseName;

    /** 认证请求状态 */
    private String status;

    /** 认证请求状态说明 */
    private String statusDesc;

    /** 认证请求发起时间 */
    private Date applyTime;

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

}
