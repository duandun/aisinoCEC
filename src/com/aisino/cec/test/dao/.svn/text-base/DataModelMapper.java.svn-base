package com.aisino.cec.test.dao;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aisino.cec.test.conditionbean.DataModelCondition;
import com.aisino.cec.test.model.DataModel;

@Component("dataModelMapper")
public interface DataModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataModel record);

    int insertSelective(DataModel record);

    DataModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataModel record);

    int updateByPrimaryKey(DataModel record);
    
    Collection<DataModel> selectByConditions(Map<String,?> conditionMap);
    
    Collection<DataModel> selectByConditions2(DataModelCondition condition);
}