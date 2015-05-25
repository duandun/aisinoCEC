package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.SpecificationParam;

public interface SpecificationParamMapper {
    int insert(SpecificationParam record);

    int insertSelective(SpecificationParam record);
}