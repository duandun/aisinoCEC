package com.aisino.cec.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aisino.cec.product.model.SkuOption;

public interface SkuOptionMapper {

    int deleteByPrimaryKey(String skuOptionId);

    int insert(SkuOption record);

    int insertSelective(SkuOption record);

    SkuOption selectByPrimaryKey(String skuOptionId);

    int updateByPrimaryKeySelective(SkuOption record);

    int updateByPrimaryKey(SkuOption record);

    /**
     * 删除sku属性值（置状态为“删除”，假删）
     * 
     * @param skuOption
     * @return
     */
    int deleteSkuOption(SkuOption skuOption);

    /**
     * 根据sku属性id查询对应的sku属性值对象列表
     * 
     * @param skuAttrId
     * @return
     */
    List<SkuOption> findSkuOptionBySkuAttrId(String skuAttrId);

    /**
     * 查询某个sku属性对应的sku属性值是否有重复
     * 
     * @param value
     * @param skuAttrId
     * @return
     */
    List<SkuOption> checkValue(@Param("value") String value, @Param("skuAttrId") String skuAttrId);
}