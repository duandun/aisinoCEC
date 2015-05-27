package com.aisino.cec.product.service;

import java.util.List;

import com.aisino.cec.product.model.SkuOption;

/**
 * sku属性值接口
 * 
 * @author leo
 */
public interface ISkuOptionService {

    /**
     * 插入sku属性值
     * 
     * @param skuOption
     * @return
     */
    boolean insertSkuOption(SkuOption skuOption);

    /**
     * 更新sku属性值
     * 
     * @param skuOption
     * @return
     */
    boolean updateSkuOption(SkuOption skuOption);

    /**
     * 删除sku属性值（置状态为“删除”，假删）
     * 
     * @param skuOption
     * @return
     */
    boolean deleteSkuOption(SkuOption skuOption);

    /**
     * 根据sku属性值id查询sku属性值对象
     * 
     * @param skuOptionId
     * @return
     */
    SkuOption findSkuOptionById(String skuOptionId);

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
    String checkValue(String value, String skuAttrId);
}
