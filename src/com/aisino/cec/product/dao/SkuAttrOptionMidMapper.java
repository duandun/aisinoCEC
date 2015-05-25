package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.SkuAttrOptionMid;

public interface SkuAttrOptionMidMapper {
    int deleteByPrimaryKey(String skuAttrOptionMidId);

    int insert(SkuAttrOptionMid record);

    int insertSelective(SkuAttrOptionMid record);

    SkuAttrOptionMid selectByPrimaryKey(String skuAttrOptionMidId);

    int updateByPrimaryKeySelective(SkuAttrOptionMid record);

    int updateByPrimaryKey(SkuAttrOptionMid record);
}