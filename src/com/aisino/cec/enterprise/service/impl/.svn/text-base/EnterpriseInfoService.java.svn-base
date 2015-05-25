package com.aisino.cec.enterprise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.enterprise.dao.EnterpriseInfoMapper;
import com.aisino.cec.enterprise.model.EnterpriseInfo;
import com.aisino.cec.enterprise.service.IEnterpriseInfoService;

@Service(value = "enterpriseInfoService")
public class EnterpriseInfoService implements IEnterpriseInfoService {

    @Autowired
    private EnterpriseInfoMapper enterpriseInfoMapper;

    @Override
    public EnterpriseInfo findEnterpriseInfoByEtpId(String enterpriseId) {
        EnterpriseInfo enterpriseInfo = enterpriseInfoMapper.findEnterpriseInfoByEtpId(enterpriseId);
        return enterpriseInfo;
    }

}
