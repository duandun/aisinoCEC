package com.aisino.cec.enterprise.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.common.util.random.IMajorKey;
import com.aisino.cec.common.util.sendEmail.EmailSettings;
import com.aisino.cec.common.util.sendEmail.SendEmail;
import com.aisino.cec.enterprise.dao.authentication.AuditInfoMapper;
import com.aisino.cec.enterprise.dao.authentication.AuthenticationInfoMapper;
import com.aisino.cec.enterprise.dao.authentication.ContactInfoMapper;
import com.aisino.cec.enterprise.enumpackage.authentication.AuditStatusEnum;
import com.aisino.cec.enterprise.model.authentication.AuditInfo;
import com.aisino.cec.enterprise.model.authentication.AuthenticationInfo;
import com.aisino.cec.enterprise.model.authentication.ContactInfo;
import com.aisino.cec.enterprise.service.IAuditInfoService;
import com.aisino.cec.user.dao.UserMapper;
import com.aisino.cec.user.model.User;

/**
 * 审核企业认证service
 * 
 * @author leo
 */
@Service("auditInfoService")
public class AuditInfoService implements IAuditInfoService {

    @Autowired
    private IMajorKey majorKey;

    @Autowired
    private AuditInfoMapper auditInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ContactInfoMapper contactInfoMapper;

    @Autowired
    private AuthenticationInfoMapper authenticationInfoMapper;

    @Override
    public List<AuditInfo> findAuditInfo(String authenticationId) {
        return auditInfoMapper.findAuditInfo(authenticationId);
    }

    @Override
    public boolean saveAuditInfo(AuditInfo auditInfo) {
        boolean result = false;
        try {
            auditInfo.setAuditId(majorKey.getMajorKey());
            auditInfo.setAuditTime(new Date());
            List<User> userList = userMapper.selectByUserName(auditInfo.getAuditorName());
            if (!userList.isEmpty()) {
                auditInfo.setAuditorId(userList.get(0).getUserId());
            }
            if (auditInfo.getAuditStatus().equals(AuditStatusEnum.PASSED.getKey())) {
                auditInfo.setAuditStatusDesc(AuditStatusEnum.PASSED.getValue());
            }
            if (auditInfo.getAuditStatus().equals(AuditStatusEnum.NOTPASS.getKey())) {
                auditInfo.setAuditStatusDesc(AuditStatusEnum.NOTPASS.getValue());
            }
            auditInfoMapper.saveAuditInfo(auditInfo);
            // 更新企业认证表
            AuthenticationInfo authenticationInfo =
                    authenticationInfoMapper.selectByPrimaryId(auditInfo.getAuthenticationId());
            if (null != authenticationInfo) {
                authenticationInfo.setStatus(auditInfo.getAuditStatus());
                authenticationInfo.setStatusDesc(auditInfo.getAuditStatusDesc());
                authenticationInfoMapper.updateAuthenticationInfo(authenticationInfo);
            }
            result = true;
            // 发送通知邮件
            EmailSettings emailSettings = new EmailSettings();
            emailSettings.setMailSubject("企业认证审核通知");
            emailSettings.setMailContent(auditInfo.getAuditStatusDesc() + ":" + auditInfo.getAuditOpinion());
            // 设置收件人地址
            List<String> addrList = new ArrayList<String>();
            // 认证联系人映射对象
            ContactInfo contactInfo = contactInfoMapper.selectByAuthenticationId(auditInfo.getAuthenticationId());
            if (null != contactInfo) {
                addrList.add(contactInfo.getContactEmail());
            }
            emailSettings.setAddressList(addrList);
            SendEmail.sendEmail(emailSettings);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
