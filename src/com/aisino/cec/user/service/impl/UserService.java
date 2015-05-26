package com.aisino.cec.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.common.enumpackage.sendEmail.SendMailEnum;
import com.aisino.cec.common.util.calendar.CalendarUtil;
import com.aisino.cec.common.util.random.IMajorKey;
import com.aisino.cec.common.util.random.RandomUtil;
import com.aisino.cec.common.util.security.Security;
import com.aisino.cec.common.util.sendEmail.EmailSettings;
import com.aisino.cec.common.util.sendEmail.SendEmail;
import com.aisino.cec.enterprise.dao.EnterpriseMapper;
import com.aisino.cec.enterprise.model.Enterprise;
import com.aisino.cec.user.dao.UserMapper;
import com.aisino.cec.user.enumpackage.UserEnum;
import com.aisino.cec.user.model.User;
import com.aisino.cec.user.service.IUserService;

@Service(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private EnterpriseMapper enterpriseMapper;
    
    @Autowired
    private IMajorKey majorKey;

    @Override
    public void insert(User user) {
               user.setUserId(majorKey.getMajorKey());
               user.setVerifyCode(RandomUtil.getRandom16String());
               Date nowDate = new Date();
               user.setVerifyCodeValidTime(CalendarUtil.dateAdd(nowDate, 2));
               user.setUserFlag("用户");
               String pwd = Security.MD5Encode(Security.SHAEncode(user.getUserPasswd()));
               user.setUserPasswd(pwd);
               user.setUserStatus(UserEnum.USER_STATUS_NONACTIVATED.getValue());
               user.setFreezeFlag(UserEnum.BANK_STATUS_NORMAL.getValue());
               user.setRegisterDate(new Date());
               user.setRegisterSourceFlag("邮箱注册");               
               user.setEnterpriseId(majorKey.getMajorKey());
               
               //更新enterprise表
               Enterprise enterprise = new Enterprise();
               enterprise.setEnterpriseId(user.getEnterpriseId());
               enterprise.setEnterpriseName(user.getEnterpriseName());
               enterpriseMapper.saveEnterprise(enterprise);
               
               userMapper.insert(user);
               
               try{
                   //发送激活邮件
                   EmailSettings emailSettings = new EmailSettings();
                   emailSettings.setMailSubject("激活用户邮箱");
                   emailSettings.setMailContent(SendEmail.createEmailContent(SendMailEnum.MAIL_TYPE_REGISTER.getValue(), user.getUserId(), user.getVerifyCode()));
                   List<String> addrList = new ArrayList<String>();
                   addrList.add(user.getUserEmail());
                   emailSettings.setAddressList(addrList);
                   
                   SendEmail.sendEmail(emailSettings);
               }catch(Exception e) {
                   e.printStackTrace();
               }
           }

           @Override
           public User getByUserId(String id) {
               return userMapper.selectByPrimaryKey(id);
           }

           @Override
           public List<User> getAll() {
               return userMapper.getAll();
           }


           @Override
           public List<User> getByUserName(String userName) {
              return userMapper.selectByUserName(userName);
           }

           @Override
           public List<User> getByUserEmail(String userEmail) {
               return userMapper.selectByUserEmail(userEmail);
           }
           
           @Override
           public List<User> getByUserPhone(String userPhone) {
               return userMapper.selectByUserPhone(userPhone);
           }
           
           @Override
           public boolean userNameCheck(String userName) {
               boolean checkResult = true;
               List<User> user = userMapper.selectByUserName(userName);
               if(!user.isEmpty()) {
                   checkResult = false;
               }
              
               return checkResult;
           }
           
           @Override
           public boolean userEmailCheck(String userEmail) {
               boolean checkResult = true;
               List<User> user = userMapper.selectByUserEmail(userEmail);
               if(!user.isEmpty()) {
                   checkResult = false;
               }
              
               return checkResult;
           }
           
           @Override
           public boolean userPhoneCheck(String userPhone) {
               boolean checkResult = true;
               List<User> user = userMapper.selectByUserPhone(userPhone);
               if(!user.isEmpty()) {
                   checkResult = false;
               }      
               return checkResult;
           }
           

           @Override
           public boolean enterpriseNameCheck(String enterpriseName) {
               boolean checkResult = true;
               List<User> user = userMapper.selectByEnterpriseName(enterpriseName);
               if(!user.isEmpty()) {
                   checkResult = false;
               }      
               return checkResult;
           }   

           @Override
           public String activateUser(String userId, String verifyCode) {
               SendMailEnum sendMailEnum = null;
               User user = userMapper.selectByPrimaryKey(userId);
               // 验证用户是否存在
               if(user!=null) {
                   if(UserEnum.USER_STATUS_NONACTIVATED.getValue().equals(user.getUserStatus())) {
                       Date currentTime = new Date();
                       
                       if(currentTime.before(user.getVerifyCodeValidTime())) {
                           if(verifyCode.equals(user.getVerifyCode())) {
                               user.setUserStatus(UserEnum.USER_STATUS_NORMAL.getValue());
                               userMapper.updateUserStatus(user);
                               sendMailEnum = SendMailEnum.MAIL_ACTIVATED;
                           } else {
                               sendMailEnum = SendMailEnum.MAIL_VERIFYCODE_WRONG;
                           }
                       }else {
                           sendMailEnum = SendMailEnum.MAIL_VERIFYCODE_EXPIRE;
                       }
                   } else {
                       sendMailEnum = SendMailEnum.VERIFYCODE_INVALID;
                   }
               }else {
                   sendMailEnum = SendMailEnum.MAIL_NOT_EXIST;
               }
               return sendMailEnum.getValue();
           }
           

           @Override
           public void updateVerifyCodeValidTime(User user) {
               userMapper.updateVerifyCodeValidTime(user);
           }
    
    // ==========================================

    @Override
    public boolean userEmailIsExist(String userEmail) {
        // TODO Auto-generated method stub
        List<User> user = userMapper.selectByUserEmail(userEmail);
        if (!user.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean userNameIsExist(String userName) {
        // TODO Auto-generated method stub
        List<User> userList = userMapper.selectByUserName(userName);
        
        if(!userList.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String findPassword(String emailOrUserName) {
        // TODO Auto-generated method stub
        // 查询账户信息
        User user = null;

        // 说明是根据邮箱找回密码的
        if (emailOrUserName.contains("@")) {
           List<User> userList = userMapper.selectByUserEmail(emailOrUserName);
           if(!userList.isEmpty()) {
               user = userList.get(0);
           }
        }
        else {
            // 说明是根据用户名找回密码的，根据用户名查找其对应的邮箱
            List<User> userList = userMapper.selectByUserName(emailOrUserName);
            if(!userList.isEmpty()) {
                user = userList.get(0);
            }
        }

        // 这个需要后面使用其他工具替换掉，更新数据库中的验证码和有效时间
        String verifyCode = RandomUtil.getRandom16String();
        Date nowDate = new Date();
        user.setVerifyCode(verifyCode);
        user.setVerifyCodeValidTime(CalendarUtil.dateAdd(nowDate, 2));
        userMapper.updateVarifyCode(user);

        // 发送密码找回邮件
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.getAddressList().add(user.getUserEmail());
        emailSettings.setMailSubject("航信电商平台找回密码");
        emailSettings.setMailContent(SendEmail.createEmailContent(SendMailEnum.MAIL_TYPE_FINDPWD.getValue(), user
                .getUserId(), verifyCode));
        SendEmail.sendEmail(emailSettings);

        return user.getUserEmail();
    }

    @Override
    public boolean linkIsTimeOut(String userId, String varifyCode) {
        // TODO Auto-generated method stub
        boolean result = false;
        User user = userMapper.selectByUserId(userId);
        // 获取当前时间
        Date currentTime = new Date();
        // 验证码有效期
        if (user.getVerifyCodeValidTime() != null
                && currentTime.before(user.getVerifyCodeValidTime())) {
            // 验证码是否正确
            if (varifyCode.equals(user.getVerifyCode())) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void resetPassword(String userId, String password) {
        // TODO Auto-generated method stub
        // 加密后的密码
        String cryptographPwd = Security.MD5Encode(Security.SHAEncode(password));
        User user = new User();
        user.setUserId(userId);
        user.setUserPasswd(cryptographPwd);

        user.setVerifyCode(null);
        user.setVerifyCodeValidTime(null);
        userMapper.updatePassword(user);
    }

}
