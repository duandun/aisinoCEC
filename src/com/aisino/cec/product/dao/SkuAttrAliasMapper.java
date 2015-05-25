package com.aisino.cec.product.dao;

import com.aisino.cec.product.model.SkuAttrAlias;

public interface SkuAttrAliasMapper {
    int deleteByPrimaryKey(String skuAttrAliasId);

    int insert(SkuAttrAlias record);

    int insertSelective(SkuAttrAlias record);

    SkuAttrAlias selectByPrimaryKey(String skuAttrAliasId);

    int updateByPrimaryKeySelective(SkuAttrAlias record);

    int updateByPrimaryKey(SkuAttrAlias record);
}