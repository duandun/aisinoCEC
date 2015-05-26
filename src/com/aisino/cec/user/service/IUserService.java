package com.aisino.cec.user.service;

import java.util.List;

import com.aisino.cec.user.enumpackage.UserEnum;
import com.aisino.cec.user.model.User;

/**
 * 用户账户相关的接口定义
 * 
 * @author lxy
 */
public interface IUserService {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    void insert(User user);
    
    /**
     * 根据userId获取用户信息
     * @param id
     * @return
     */
    User getByUserId(String id);
    
    /**
     * 获得所有的用户信息
     * @return
     */
    List<User> getAll();
    
    /**
     * 根据userName获取用户信息
     * @param userName
     * @return
     */
    List<User> getByUserName(String userName);
    
    /**
     * 根据email获取用户信息
     * @param email
     * @return
     */
    List<User> getByUserEmail(String userEmail);
    
    /**
     * 根据userPhone获取用户信息
     * @param userPhone
     * @return
     */
    List<User> getByUserPhone(String userPhone);
    
    /**
     * 验证userName重复
     * 
     * @param userName
     * @return boolean true: 不重复，可以用；false: 重复，不可用
     */
    boolean userNameCheck(String userName);
    
    /**
     * 验证email重复
     * @param userEmail
     * @return boolean true: 不重复，可以用；false：重复，不可用
     */
    boolean userEmailCheck(String userEmail);
    
    /**
     * 验证phoneNum重复
     * @param phoneNum
     * @return boolean true: 不重复，可以用；false: 重复，不可用
     */
    boolean userPhoneCheck(String userPhone);
    
    /**
     * 验证enterpriseName重复
     * @param phoneNum
     * @return boolean true: 不重复，可以用；false: 重复，不可用
     */
    boolean enterpriseNameCheck(String enterpriseName);
    
    /**
     * 邮件激活
     * @param userId
     * @param verifyCode
     * @return
     */
    String activateUser(String userId, String verifyCode);
    
    /**
     * 更新邮箱失效时间
     * @param user
     * @return
     */
    void updateVerifyCodeValidTime(User user);
    
    // ==========================================

    /**
     * 判断邮箱是否存在
     * 
     * @param userEmail
     *            邮箱
     * @return true|false; true:存在；false：不存在
     */
    public boolean userEmailIsExist(String userEmail);

    /**
     * 判断用户名是否存在
     * 
     * @param userName
     *            用户名
     * @return true|false; true:存在；false：不存在
     */
    public boolean userNameIsExist(String userName);

    /**
     * 根据邮箱或者用户名找回密码
     * 
     * @param emailOrUserName
     *            邮箱或者是用户名
     * @return 用户的邮箱
     */
    public String findPassword(String emailOrUserName);

    /**
     * 找回密码的激活链接是否有效
     * 
     * @param userId
     * @param varifyCode
     * @return
     */
    public boolean linkIsTimeOut(String userId, String varifyCode);

    /**
     * 重置密码，并清空验证码和验证码有效时间
     * 
     * @param userId
     * @param password
     */
    public void resetPassword(String userId, String password);
}
