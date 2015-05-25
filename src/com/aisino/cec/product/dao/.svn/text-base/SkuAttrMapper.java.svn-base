package com.aisino.cec.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aisino.cec.product.conditionbean.SkuAttrCondition;
import com.aisino.cec.product.model.SkuAttr;

public interface SkuAttrMapper {

    int deleteByPrimaryKey(String skuAttrId);

    int insert(SkuAttr record);

    int insertSelective(SkuAttr record);

    SkuAttr selectByPrimaryKey(String skuAttrId);

    int updateByPrimaryKeySelective(SkuAttr record);

    int updateByPrimaryKey(SkuAttr record);

    /**
     * 根据条件查询sku属性列表
     * 
     * @param condition
     * @return
     */
    List<SkuAttr> selectByCondition(SkuAttrCondition condition);

    /**
     * 删除sku属性（置状态为“删除”，假删）
     * 
     * @param skuAttr
     * @return
     */
    int deleteSkuAttr(SkuAttr skuAttr);

    /**
     * 查询某分类下的sku属性前端显示名称是否重复
     * 
     * @param frontName
     * @param categoryId
     * @return
     */
    List<SkuAttr> checkFrontName(@Param("frontName") String frontName, @Param("categoryId") String categoryId);

    /**
     * 查询某分类下的sku属性维护名称是否重复
     * 
     * @param storeName
     * @param categoryId
     * @return
     */
    List<SkuAttr> checkStoreName(@Param("storeName") String storeName, @Param("categoryId") String categoryId);
}