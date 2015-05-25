package com.aisino.cec.enterprise.dao.authentication;

import org.springframework.stereotype.Repository;

import com.aisino.cec.enterprise.model.authentication.ContactInfo;

/**
 * 申请成为卖家的认证相关信息：认证信息中的认证联系人相关信息
 * 
 * @author lxy
 */
@Repository("contactInfoMapper")
public interface ContactInfoMapper {

    /**
     * 插入认证联系人信息
     * 
     * @param contactInfo
     *            认证联系人对象
     * @return 插入数据的条数
     */
    int insertContactInfo(ContactInfo contactInfo);

    /**
     * 更新认证联系人信息
     * 
     * @param contactInfo
     *            认证联系人对象
     * @return 更新数据的条数
     */
    int updateContactInfo(ContactInfo contactInfo);
    
    /**
     * 根据企业认证映射对象ID，查询认证联系人信息
     * @param authenticationId 企业认证映射对象ID
     * @return 认证联系人信息
     */
    ContactInfo selectByAuthenticationId(String authenticationId);
    
    /**
     * 根据认证联系人主键，查询认证联系人信息
     * @param contactId 认证联系人ID
     * @return 认证联系人信息
     */
    ContactInfo selectByPrimaryId(String contactId);
}
