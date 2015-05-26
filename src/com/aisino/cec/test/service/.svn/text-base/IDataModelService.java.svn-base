package com.aisino.cec.test.service;

import java.util.Collection;
import java.util.Map;

import com.aisino.cec.test.conditionbean.DataModelCondition;
import com.aisino.cec.test.model.DataModel;

public interface IDataModelService {
	int deleteByPrimaryKey(Integer id);

	int insert(DataModel record);

	int insertSelective(DataModel record);

	DataModel selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(DataModel record);

	int updateByPrimaryKey(DataModel record);
	
	Collection<DataModel> selectByConditions(Map<String,?> conditionMap);
	
	Collection<DataModel> selectByConditions(DataModelCondition condition);
}
