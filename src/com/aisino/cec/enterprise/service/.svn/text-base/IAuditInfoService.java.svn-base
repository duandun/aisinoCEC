package com.aisino.cec.enterprise.service;

import java.util.List;

import com.aisino.cec.enterprise.model.authentication.AuditInfo;

/**
 * 审核企业认证信息接口
 * 
 * @author leo
 */
public interface IAuditInfoService {

    /**
     * 保存审核信息
     * 
     * @param auditInfo
     * @return
     */
    boolean saveAuditInfo(AuditInfo auditInfo);

    /**
     * 根据认证请求ID查询历史审核记录
     * 
     * @param authenticationId
     * @return
     */
    List<AuditInfo> findAuditInfo(String authenticationId);
}
