package com.aisino.cec.enterprise.dao;

import org.springframework.stereotype.Repository;

import com.aisino.cec.enterprise.model.Enterprise;

@Repository(value = "enterpriseMapper")
public interface EnterpriseMapper {

    /**
     * 插入企业对象
     * 
     * @param enterprise
     */
    void saveEnterprise(Enterprise enterprise);

    /**
     * 更新企业对象
     * 
     * @param enterprise
     */
    void updateEnterprise(Enterprise enterprise);

    /**
     * 根据id查询企业对象
     * 
     * @param enterpriseId
     * @return
     */
    Enterprise findEnterpriseById(String enterpriseId);
}
