package com.aisino.cec.enterprise.dao.authentication;

import org.springframework.stereotype.Repository;

import com.aisino.cec.enterprise.model.authentication.TaxInfo;

/**
 * 申请成为卖家的认证相关信息：纳税信息映射对象
 * @author lxy
 *
 */
@Repository("taxInfoMapper")
public interface TaxInfoMapper {
    /**
     * 插入一条纳税信息映射对象
     * @param taxInfo 纳税信息映射对象
     * @return 插入数据的条数
     */
    int insertTaxInfo(TaxInfo taxInfo);
    
    /**
     * 更新一条纳税信息映射对象
     * @param taxInfo 纳税信息映射对象
     * @return 更新数据的条数
     */
    int updateTaxInfo(TaxInfo taxInfo);
    
    /**
     * 根据企业认证映射对象ID，查询认证企业纳税信息
     * @param authenticationId 企业认证映射对象ID
     * @return 纳税信息映射对象
     */
    TaxInfo selectByAuthenticationId(String authenticationId);
    
    /**
     * 根据纳税信息对象id，查询认证企业纳税信息
     * @param taxInfoId 纳税信息对象id
     * @return
     */
    TaxInfo selectByPrimaryId(String taxInfoId);
}
