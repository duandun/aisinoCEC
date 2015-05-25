package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.CommonSeries;

public interface CommonSeriesMapper {
    int deleteByPrimaryKey(String commonSeriesId);

    int insert(CommonSeries record);

    int insertSelective(CommonSeries record);

    CommonSeries selectByPrimaryKey(String commonSeriesId);

    int updateByPrimaryKeySelective(CommonSeries record);

    int updateByPrimaryKey(CommonSeries record);
}