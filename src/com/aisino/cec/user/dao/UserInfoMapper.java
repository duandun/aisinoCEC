package com.aisino.cec.user.dao;

import org.springframework.stereotype.Repository;

import com.aisino.cec.user.model.UserInfo;

/**
 * 用户信息mapper
 * 
 * @author leo
 */
@Repository(value = "userInfoMapper")
public interface UserInfoMapper {

    /**
     * 插入用户信息
     * 
     * @param userInfo
     */
    void saveUserInfo(UserInfo userInfo);

    /**
     * 更新用户信息
     * 
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 根据userd查询用户信息
     * 
     * @param userInfoId
     * @return
     */
    UserInfo findUserInfoByUserId(String userId);
}
