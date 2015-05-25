package com.aisino.cec.enterprise.service;

import java.util.List;

import com.aisino.cec.enterprise.conditionbean.AuthenticationInfoCondition;
import com.aisino.cec.enterprise.model.authentication.AuthenticationInfo;
import com.aisino.cec.enterprise.vo.authentication.AuthenticationBean;

/**
 * 认证成为卖家的service
 * 
 * @author lxy
 */
public interface IAuthenticationService {

    /**
     * 提交认证申请，并返回认证申请的ID
     * 
     * @param authenticationBean
     * @return
     */
    String saveAuthenticationApply(AuthenticationBean authenticationBean);

    /**
     * 更新认证申请信息
     * 
     * @param authenticationBean
     * @return
     */
    boolean updateAuthenticationApply(AuthenticationBean authenticationBean);

    /**
     * 根据企业ID查询认证企业认证映射对象
     * 
     * @param enterpriseId
     *            企业ID
     * @return
     */
    AuthenticationInfo findByEnterpriseId(String enterpriseId);

    /**
     * 根据条件查询企业申请认证的信息列表
     * 
     * @param condition
     * @return
     */
    List<AuthenticationInfo> selectByCondition(AuthenticationInfoCondition condition);

    /**
     * 根据认证映射对象查询认证相关信息
     * 
     * @param authenticationId
     * @return
     */
    AuthenticationBean findByAuthenticationId(String authenticationId);
}
