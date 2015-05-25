package com.aisino.cec.enterprise.dao;

import org.springframework.stereotype.Repository;

import com.aisino.cec.enterprise.model.EnterpriseInfo;

@Repository("enterpriseInfoMapper")
public interface EnterpriseInfoMapper {

    /**
     * 插入企业信息对象
     * 
     * @param enterpriseInfo
     */
    public void saveEnterpriseInfo(EnterpriseInfo enterpriseInfo);

    /**
     * 更新企业信息对象
     * 
     * @param enterpriseInfo
     */
    public void updateEnterpriseInfo(EnterpriseInfo enterpriseInfo);

    /**
     * 根据id查询企业信息对象
     * 
     * @param enterpriseId
     * @return
     */
    public EnterpriseInfo findEnterpriseInfoByEtpId(String enterpriseId);
}
