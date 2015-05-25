package com.aisino.cec.enterprise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.cec.enterprise.dao.EnterpriseMapper;
import com.aisino.cec.enterprise.model.Enterprise;
import com.aisino.cec.enterprise.service.IEnterpriseService;

@Service(value = "enterpriseService")
public class EnterpriseService implements IEnterpriseService {
   
    @Autowired
    private EnterpriseMapper enterpriseMapper;
    
    @Override
    public String findEnterpriseNameById(String enterpriseId) {
        // TODO Auto-generated method stub
        Enterprise enterprise = enterpriseMapper.findEnterpriseById(enterpriseId);
        if(enterprise != null) {
            return enterprise.getEnterpriseName();
        }
        return null;
    }

}
