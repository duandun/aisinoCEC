package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.SkuInfo;

public interface SkuInfoMapper {
    int insert(SkuInfo record);

    int insertSelective(SkuInfo record);
}