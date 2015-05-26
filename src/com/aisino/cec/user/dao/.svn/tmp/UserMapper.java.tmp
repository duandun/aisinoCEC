package com.aisino.cec.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aisino.cec.user.model.User;

@Repository(value = "userMapper")
public interface UserMapper {

    List<User> getAll();

    /**
     * 保存用户信息
     * 
     * @param user
     */
    void insert(User user);

    /**
     * 根据用户Id查找用户信息
     * 
     * @param userId
     * @return
     */
    User selectByPrimaryKey(String userId);

    // int deleteByPrimaryKey(String userId);

    /**
     * 更新用户状态（例如，激活，注销等）
     * 
     * @param user
     * @return
     */
    int updateUserStatus(User user);

    /**
     * 更新账户状态
     * 
     * @param user
     * @return
     */
    int updateBankStatus(User user);

    /**
     * 更新用户激活失效时间
     * @param user
     * @return
     */
    int updateVerifyCodeValidTime(User user); 
    
    /**
     * 根据用户名查找信息
     * 
     * @param userName
     * @return
     */
    List<User> selectByUserName(String userName);

    /**
     * 根据注册邮箱查找用户信息
     * 
     * @param userEmail
     * @return
     */
    List<User> selectByUserEmail(String userEmail);

    /**
     * 根据手机号码查找用户信息
     * 
     * @param userPhone
     * @return
     */
    List<User> selectByUserPhone(String userPhone);

    /**
     * 根据企业名称查找信息
     * 
     * @param enterpriseName
     * @return
     */
    List<User> selectByEnterpriseName(String enterpriseName);

    // ==========================================
    /**
     * 根据登录账号查询账户信息
     * 
     * @param accountName
     *            登录账号
     */
    // User selectByAccountName(String accountName);

    /**
     * 根据邮箱查询账户信息
     * 
     * @param accountName
     *            登录账号
     */
    // User selectByEmailAddr(String emailAddr);

    /**
     * 发送邮件时，要更新验证码以及验证码的有效时间
     * 
     * @param User
     */
    int updateVarifyCode(User user);

    /**
     * 根据accountId查询账户信息
     * 
     * @param accountId
     *            用户唯一标识
     */
    User selectByUserId(String userId);

    /**
     * 重置密码，并清空激活码及激活码有效时间
     * 
     * @param User
     *            用户账户
     */
    int updatePassword(User user);

    /**
     * 更新用户对象手机号和企业名称
     * 
     * @param user
     * @return
     */
    int updateUser(User user);

}
