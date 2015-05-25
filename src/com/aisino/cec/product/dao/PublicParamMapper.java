package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.PublicParam;

public interface PublicParamMapper {
    int insert(PublicParam record);

    int insertSelective(PublicParam record);
}