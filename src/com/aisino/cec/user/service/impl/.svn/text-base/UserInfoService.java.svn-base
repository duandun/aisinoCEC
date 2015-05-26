package com.aisino.cec.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.common.util.random.IMajorKey;
import com.aisino.cec.enterprise.dao.EnterpriseInfoMapper;
import com.aisino.cec.enterprise.dao.EnterpriseMapper;
import com.aisino.cec.enterprise.model.Enterprise;
import com.aisino.cec.enterprise.model.EnterpriseInfo;
import com.aisino.cec.user.dao.UserInfoMapper;
import com.aisino.cec.user.dao.UserMapper;
import com.aisino.cec.user.model.User;
import com.aisino.cec.user.model.UserInfo;
import com.aisino.cec.user.service.IUserInfoService;
import com.aisino.cec.user.vo.UserInfoVo;

@Service(value = "userInfoService")
public class UserInfoService implements IUserInfoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;

    @Autowired
    private IMajorKey majorKey;

    @Override
    public UserInfo findUserInfoByUserId(String userId) {
        UserInfo userInfo = userInfoMapper.findUserInfoByUserId(userId);
        return userInfo;
    }

    @Override
    public boolean saveUserInfo(UserInfoVo userInfoVo) {
        boolean result = false;
        try {
            User user = userMapper.selectByPrimaryKey(userInfoVo.getUserId());
            if (null != user) {
                // 更新用户
                user.setEnterpriseName(userInfoVo.getEnterpriseName());
                user.setUserPhone(userInfoVo.getUserPhone());
                userMapper.updateUser(user);
                Enterprise enterprise = enterpriseMapper.findEnterpriseById(user.getEnterpriseId());
                if (null != enterprise) {
                    // 更新企业
                    enterprise.setEnterpriseName(userInfoVo.getEnterpriseName());
                    enterpriseMapper.updateEnterprise(enterprise);
                    EnterpriseInfo enterpriseInfo =
                            enterpriseInfoMapper.findEnterpriseInfoByEtpId(enterprise.getEnterpriseId());
                    if (null == enterpriseInfo) {
                        // 插入企业信息
                        EnterpriseInfo ei = new EnterpriseInfo();
                        ei.setEnterpriseInfoId(majorKey.getMajorKey());
                        ei.setEnterpriseId(enterprise.getEnterpriseId());
                        ei.setMainIndustry(userInfoVo.getMainIndustry());
                        ei.setMainProduct(userInfoVo.getMainProduct());
                        ei.setProvince(userInfoVo.getProvince());
                        ei.setCity(userInfoVo.getCity());
                        ei.setDistrict(userInfoVo.getDistrict());
                        ei.setStreet(userInfoVo.getStreet());
                        enterpriseInfoMapper.saveEnterpriseInfo(ei);
                    }
                    else {
                        // 更新企业信息
                        enterpriseInfo.setMainIndustry(userInfoVo.getMainIndustry());
                        enterpriseInfo.setMainProduct(userInfoVo.getMainProduct());
                        enterpriseInfo.setProvince(userInfoVo.getProvince());
                        enterpriseInfo.setCity(userInfoVo.getCity());
                        enterpriseInfo.setDistrict(userInfoVo.getDistrict());
                        enterpriseInfo.setStreet(userInfoVo.getStreet());
                        enterpriseInfoMapper.updateEnterpriseInfo(enterpriseInfo);
                    }
                }
                UserInfo userInfo = userInfoMapper.findUserInfoByUserId(user.getUserId());
                if (null == userInfo) {
                    // 插入用户信息
                    UserInfo ui = new UserInfo();
                    ui.setUserInfoId(majorKey.getMajorKey());
                    ui.setUserId(user.getUserId());
                    ui.setUserGender(userInfoVo.getUserGender());
                    ui.setUserRealName(userInfoVo.getUserRealName());
                    ui.setUserPosition(userInfoVo.getUserPosition());
                    userInfoMapper.saveUserInfo(ui);
                }
                else {
                    // 更新用户信息
                    userInfo.setUserGender(userInfoVo.getUserGender());
                    userInfo.setUserRealName(userInfoVo.getUserRealName());
                    userInfo.setUserPosition(userInfoVo.getUserPosition());
                    userInfoMapper.updateUserInfo(userInfo);
                }
                result = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
