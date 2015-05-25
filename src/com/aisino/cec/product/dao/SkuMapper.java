package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.Sku;

public interface SkuMapper {
    int insert(Sku record);

    int insertSelective(Sku record);
}