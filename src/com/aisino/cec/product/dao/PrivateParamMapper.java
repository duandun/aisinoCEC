package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.PrivateParam;

public interface PrivateParamMapper {
    int insert(PrivateParam record);

    int insertSelective(PrivateParam record);
}