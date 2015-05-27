package com.aisino.cec.product.service;

import java.util.List;

import com.aisino.cec.product.conditionbean.SkuAttrCondition;
import com.aisino.cec.product.model.SkuAttr;

/**
 * sku属性接口
 * 
 * @author leo
 */
public interface ISkuAttrService {

    /**
     * 插入sku属性
     * 
     * @param skuAttr
     * @return
     */
    boolean insertSkuAttr(SkuAttr skuAttr);

    /**
     * 更新sku属性
     * 
     * @param skuAttr
     * @return
     */
    boolean updateSkuAttr(SkuAttr skuAttr);

    /**
     * 删除sku属性（置状态为“删除”，假删）
     * 
     * @param skuAttr
     * @return
     */
    boolean deleteSkuAttr(SkuAttr skuAttr);

    /**
     * 根据条件查询sku属性列表
     * 
     * @param condition
     * @return
     */
    List<SkuAttr> selectByCondition(SkuAttrCondition condition);

    /**
     * 根据sku属性id查询sku对象
     * 
     * @param skuAttrId
     * @return
     */
    SkuAttr findSkuAttrById(String skuAttrId);

    /**
     * 查询某分类下的sku属性前端显示名称是否重复
     * 
     * @param frontName
     * @param categoryId
     * @return
     */
    String checkFrontName(String frontName, String categoryId);

    /**
     * 查询某分类下的sku属性维护名称是否重复
     * 
     * @param storeName
     * @param categoryId
     * @return
     */
    String checkStoreName(String storeName, String categoryId);
}
