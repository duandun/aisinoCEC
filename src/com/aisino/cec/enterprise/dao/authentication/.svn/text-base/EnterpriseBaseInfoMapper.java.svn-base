package com.aisino.cec.enterprise.dao.authentication;

import org.springframework.stereotype.Repository;

import com.aisino.cec.enterprise.model.authentication.EnterpriseBaseInfo;

/**
 * 申请成为卖家的认证相关信息:企业基本信息映射对象
 * @author lxy
 *
 */
@Repository("enterpriseBaseInfoMapper")
public interface EnterpriseBaseInfoMapper {
    /**
     * 插入认证申请中的企业基本信息
     * @param enterpriseBaseInfo 企业基本信息映射对象
     * @return 插入数据的条数
     */
    int insertEnterpriseBaseInfo(EnterpriseBaseInfo enterpriseBaseInfo);
    
    /**
     * 插入认证申请中的企业基本信息
     * @param enterpriseBaseInfo 企业基本信息映射对象
     * @return 更新数据的条数
     */
    int updateEnterpriseBaseInfo(EnterpriseBaseInfo enterpriseBaseInfo);
    
    /**
     * 根企业认证映射对象ID，查询认证企业基本信息
     * @param authenticationId 企业认证映射对象ID
     * @return 企业基本信息映射对象
     */
    EnterpriseBaseInfo selectByAuthenticationId(String authenticationId);
    
    /**
     * 根据企业认证映射对象ID，查询认证企业基本信息
     * @param enterpriseBaseInfoId 企业认证映射对象ID
     * @return
     */
    EnterpriseBaseInfo selectByPrimaryId(String enterpriseBaseInfoId);
}
