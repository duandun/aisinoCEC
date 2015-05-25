package com.aisino.cec.enterprise.dao.authentication;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aisino.cec.enterprise.conditionbean.AuthenticationInfoCondition;
import com.aisino.cec.enterprise.model.authentication.AuthenticationInfo;

/**
 * 申请成为卖家的认证相关信息：企业认证映射对象
 * 
 * @author lxy
 */
@Repository("authenticationInfoMapper")
public interface AuthenticationInfoMapper {

    /**
     * 插入一条新的认证申请
     * 
     * @param authenticationInfo
     *            企业认证映射对象
     * @return 插入数据的条数
     */
    int insertAuthenticationInfo(AuthenticationInfo authenticationInfo);

    /**
     * 更新认证申请信息
     * 
     * @param authenticationInfo
     *            企业认证映射对象
     * @return 更新数据的条数
     */
    int updateAuthenticationInfo(AuthenticationInfo authenticationInfo);

    /**
     * 根据企业ID，查询企业认证映射对象
     * 
     * @param enterpriseId
     *            企业ID
     * @return 企业认证映射对象
     */
    AuthenticationInfo selectByEnterpriseId(String enterpriseId);

    /**
     * 根据主键，查询企业认证映射对象
     * 
     * @param authenticationId
     *            企业认证映射对象主键
     * @return 企业认证映射对象
     */
    AuthenticationInfo selectByPrimaryId(String authenticationId);

    /**
     * 根据条件查询企业申请认证的信息列表
     * 
     * @param condition
     * @return
     */
    List<AuthenticationInfo> selectByCondition(AuthenticationInfoCondition condition);
}
