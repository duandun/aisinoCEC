package com.aisino.cec.enterprise.conditionbean;

import java.util.Date;

import javax.validation.constraints.Size;

import com.aisino.cec.enterprise.enumpackage.authentication.AuditStatusEnum;

/**
 * 平台审核企业申请认证信息查询bean
 * 
 * @author leo
 */
public class AuthenticationInfoCondition {

    /** 认证企业名称 */
    @Size(max = 64)
    private String enterpriseName;

    /** 认证请求状态 */
    private String status;

    /** 起始认证请求发起时间 */
    private Date startApplyTime;

    /** 终止认证请求发起时间 */
    private Date endApplyTime;

    /** 当前页数 */
    private Integer pageNum = 1;

    /** 每页显示数量 */
    private Integer pageSize = 5;

    /** 待审核 */
    private String waitPass = AuditStatusEnum.WAITPASS.getKey();

    /** 审核通过 */
    private String passed = AuditStatusEnum.PASSED.getKey();

    /** 审核未通过 */
    private String notPass = AuditStatusEnum.NOTPASS.getKey();

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

    public Date getStartApplyTime() {
        return startApplyTime;
    }

    public void setStartApplyTime(Date startApplyTime) {
        this.startApplyTime = startApplyTime;
    }

    public Date getEndApplyTime() {
        return endApplyTime;
    }

    public void setEndApplyTime(Date endApplyTime) {
        this.endApplyTime = endApplyTime;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getWaitPass() {
        return waitPass;
    }

    public void setWaitPass(String waitPass) {
        this.waitPass = waitPass;
    }

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    public String getNotPass() {
        return notPass;
    }

    public void setNotPass(String notPass) {
        this.notPass = notPass;
    }

}
