package com.aisino.cec.enterprise.dao.authentication;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aisino.cec.enterprise.model.authentication.AuditInfo;

/**
 * 平台审核企业认证信息mapper
 * 
 * @author leo
 */
@Repository("auditInfoMapper")
public interface AuditInfoMapper {

    /**
     * 保存审核信息
     * 
     * @param auditInfo
     * @return
     */
    int saveAuditInfo(AuditInfo auditInfo);

    /**
     * 根据认证请求ID查询历史审核记录
     * 
     * @param authenticationId
     * @return
     */
    List<AuditInfo> findAuditInfo(String authenticationId);
}
