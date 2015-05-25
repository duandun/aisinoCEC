package com.aisino.cec.enterprise.service;

import com.aisino.cec.enterprise.model.EnterpriseInfo;

public interface IEnterpriseInfoService {

    /**
     * 根据enterpriseId查询企业信息
     * 
     * @param enterpriseId
     * @return
     */
    EnterpriseInfo findEnterpriseInfoByEtpId(String enterpriseId);
}
