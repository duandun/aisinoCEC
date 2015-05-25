package com.aisino.cec.enterprise.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.common.util.random.IMajorKey;
import com.aisino.cec.enterprise.conditionbean.AuthenticationInfoCondition;
import com.aisino.cec.enterprise.dao.authentication.AuthenticationInfoMapper;
import com.aisino.cec.enterprise.dao.authentication.ContactInfoMapper;
import com.aisino.cec.enterprise.dao.authentication.EnterpriseBaseInfoMapper;
import com.aisino.cec.enterprise.dao.authentication.TaxInfoMapper;
import com.aisino.cec.enterprise.enumpackage.authentication.AuditStatusEnum;
import com.aisino.cec.enterprise.model.authentication.AuthenticationInfo;
import com.aisino.cec.enterprise.model.authentication.ContactInfo;
import com.aisino.cec.enterprise.model.authentication.EnterpriseBaseInfo;
import com.aisino.cec.enterprise.model.authentication.TaxInfo;
import com.aisino.cec.enterprise.service.IAuthenticationService;
import com.aisino.cec.enterprise.vo.authentication.AuthenticationBean;

@Service("authenticationService")
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private IMajorKey majorKey;

    @Autowired
    private AuthenticationInfoMapper authenticationInfoMapper;

    @Autowired
    private ContactInfoMapper contactInfoMapper;

    @Autowired
    private EnterpriseBaseInfoMapper enterpriseBaseInfoMapper;

    @Autowired
    private TaxInfoMapper taxInfoMapper;

    @Override
    public String saveAuthenticationApply(AuthenticationBean authenticationBean) {
        try {
            // 认证ID
            String authenticationId = majorKey.getMajorKey();

            // 企业认证映射对象
            AuthenticationInfo authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setAuthenticationId(authenticationId);
            authenticationInfo.setEnterpriseId(authenticationBean.getEnterpriseId());
            authenticationInfo.setEnterpriseName(authenticationBean.getEnterpriseName());
            authenticationInfo.setStatus(AuditStatusEnum.WAITPASS.getKey());
            authenticationInfo.setStatusDesc(AuditStatusEnum.WAITPASS.getValue());
            authenticationInfo.setApplyTime(new Date());

            // 认证联系人映射对象
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setContactId(majorKey.getMajorKey());
            contactInfo.setContactName(authenticationBean.getContactName());
            contactInfo.setContactPhone(authenticationBean.getContactPhone());
            contactInfo.setContactEmail(authenticationBean.getContactEmail());
            contactInfo.setAuthenticationId(authenticationId);

            // 企业基本信息映射对象
            EnterpriseBaseInfo enterpriseBaseInfo = new EnterpriseBaseInfo();
            enterpriseBaseInfo.setEnterpriseBaseInfoId(majorKey.getMajorKey());
            enterpriseBaseInfo.setEnterpriseName(authenticationBean.getEnterpriseName());
            enterpriseBaseInfo.setLegalPersonName(authenticationBean.getLegalPersonName());
            enterpriseBaseInfo.setLegalPersonIdNum(authenticationBean.getLegalPersonIdNum());
            // 这个暂时不上传
            enterpriseBaseInfo.setLegalPersonIdCard(authenticationBean.getLegalPersonIdCard());
            enterpriseBaseInfo.setRegisteredNum(authenticationBean.getRegisteredNum());
            // 这个暂时不上传
            enterpriseBaseInfo.setRegisteredCard(authenticationBean.getRegisteredCard());
            enterpriseBaseInfo.setOrganizationCode(authenticationBean.getOrganizationCode());
            // 这个暂时不上传
            enterpriseBaseInfo.setOrganizationCard(authenticationBean.getOrganizationCard());
            enterpriseBaseInfo.setAuthenticationId(authenticationId);

            // 纳税信息映射对象
            TaxInfo taxInfo = new TaxInfo();
            taxInfo.setTaxId(majorKey.getMajorKey());
            taxInfo.setTaxRegNum(authenticationBean.getTaxRegNum());
            taxInfo.setTaxpayerIdNum(authenticationBean.getTaxpayerIdNum());
            // 这个暂时不上传
            taxInfo.setTaxRegCard(authenticationBean.getTaxRegCard());
            taxInfo.setAuthenticationId(authenticationId);

            // 插入到数据库中
            authenticationInfoMapper.insertAuthenticationInfo(authenticationInfo);
            contactInfoMapper.insertContactInfo(contactInfo);
            enterpriseBaseInfoMapper.insertEnterpriseBaseInfo(enterpriseBaseInfo);
            taxInfoMapper.insertTaxInfo(taxInfo);
            return authenticationId;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateAuthenticationApply(AuthenticationBean authenticationBean) {
        try {
            String authenticationId = authenticationBean.getAuthenticationId();

            // 重新发起申请的话，申请时间要更新，申请状态要更新
            AuthenticationInfo authenticationInfo = new AuthenticationInfo();
            authenticationInfo.setAuthenticationId(authenticationId);
            authenticationInfo.setStatus(AuditStatusEnum.WAITPASS.getKey());
            authenticationInfo.setStatusDesc(AuditStatusEnum.WAITPASS.getValue());
            authenticationInfo.setApplyTime(new Date());

            // 认证联系人映射对象
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setContactName(authenticationBean.getContactName());
            contactInfo.setContactPhone(authenticationBean.getContactPhone());
            contactInfo.setContactEmail(authenticationBean.getContactEmail());
            contactInfo.setAuthenticationId(authenticationId);

            // 企业基本信息映射对象
            EnterpriseBaseInfo enterpriseBaseInfo = new EnterpriseBaseInfo();
            enterpriseBaseInfo.setLegalPersonName(authenticationBean.getLegalPersonName());
            enterpriseBaseInfo.setLegalPersonIdNum(authenticationBean.getLegalPersonIdNum());
            // 这个暂时不上传
            enterpriseBaseInfo.setLegalPersonIdCard(authenticationBean.getLegalPersonIdCard());
            enterpriseBaseInfo.setRegisteredNum(authenticationBean.getRegisteredNum());
            // 这个暂时不上传
            enterpriseBaseInfo.setRegisteredCard(authenticationBean.getRegisteredCard());
            enterpriseBaseInfo.setOrganizationCode(authenticationBean.getOrganizationCode());
            // 这个暂时不上传
            enterpriseBaseInfo.setOrganizationCard(authenticationBean.getOrganizationCard());
            enterpriseBaseInfo.setAuthenticationId(authenticationId);

            // 纳税信息映射对象
            TaxInfo taxInfo = new TaxInfo();
            taxInfo.setTaxRegNum(authenticationBean.getTaxRegNum());
            taxInfo.setTaxpayerIdNum(authenticationBean.getTaxpayerIdNum());
            // 这个暂时不上传
            taxInfo.setTaxRegCard(authenticationBean.getTaxRegCard());
            taxInfo.setAuthenticationId(authenticationId);

            // 插入到数据库中
            authenticationInfoMapper.updateAuthenticationInfo(authenticationInfo);
            contactInfoMapper.updateContactInfo(contactInfo);
            enterpriseBaseInfoMapper.updateEnterpriseBaseInfo(enterpriseBaseInfo);
            taxInfoMapper.updateTaxInfo(taxInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public AuthenticationInfo findByEnterpriseId(String enterpriseId) {
        return authenticationInfoMapper.selectByEnterpriseId(enterpriseId);
    }

    @Override
    public AuthenticationBean findByAuthenticationId(String authenticationId) {
        AuthenticationBean result = new AuthenticationBean();

        // 企业认证映射对象
        AuthenticationInfo authenticationInfo = authenticationInfoMapper.selectByPrimaryId(authenticationId);
        result.setAuthenticationId(authenticationInfo.getAuthenticationId());
        result.setEnterpriseId(authenticationInfo.getEnterpriseId());
        result.setEnterpriseName(authenticationInfo.getEnterpriseName());
        result.setStatus(authenticationInfo.getStatus());
        result.setStatusDesc(authenticationInfo.getStatusDesc());

        // 认证联系人映射对象
        ContactInfo contactInfo = contactInfoMapper.selectByAuthenticationId(authenticationId);
        result.setContactName(contactInfo.getContactName());
        result.setContactPhone(contactInfo.getContactPhone());
        result.setContactEmail(contactInfo.getContactEmail());

        // 企业基本信息映射对象
        EnterpriseBaseInfo enterpriseBaseInfo = enterpriseBaseInfoMapper.selectByAuthenticationId(authenticationId);
        result.setLegalPersonName(enterpriseBaseInfo.getLegalPersonName());
        result.setLegalPersonIdNum(enterpriseBaseInfo.getLegalPersonIdNum());
        result.setLegalPersonIdCard(enterpriseBaseInfo.getLegalPersonIdCard());
        result.setRegisteredNum(enterpriseBaseInfo.getRegisteredNum());
        result.setRegisteredCard(enterpriseBaseInfo.getRegisteredCard());
        result.setOrganizationCode(enterpriseBaseInfo.getOrganizationCode());
        result.setOrganizationCard(enterpriseBaseInfo.getOrganizationCard());

        // 纳税信息映射对象
        TaxInfo taxInfo = taxInfoMapper.selectByAuthenticationId(authenticationId);
        result.setTaxRegNum(taxInfo.getTaxRegNum());
        result.setTaxpayerIdNum(taxInfo.getTaxpayerIdNum());
        result.setTaxRegCard(taxInfo.getTaxRegCard());

        return result;
    }

    @Override
    public List<AuthenticationInfo> selectByCondition(AuthenticationInfoCondition condition) {
        return authenticationInfoMapper.selectByCondition(condition);
    }

}
