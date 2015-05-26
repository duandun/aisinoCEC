package com.aisino.cec.test.service.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aisino.cec.test.conditionbean.DataModelCondition;
import com.aisino.cec.test.dao.DataModelMapper;
import com.aisino.cec.test.model.DataModel;
import com.aisino.cec.test.service.IDataModelService;

@Service("dataModelService")
public class DataModelService implements IDataModelService{	
	@Resource(name="dataModelMapper")
	private DataModelMapper dataModelMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(DataModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(DataModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataModel selectByPrimaryKey(Integer id) {
		return dataModelMapper.selectByPrimaryKey(id);		
	}

	@Override
	public int updateByPrimaryKey(DataModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(DataModel record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<DataModel> selectByConditions(Map<String,?> conditionMap) {
		   
		return dataModelMapper.selectByConditions(conditionMap);
	}

	@Override
	public Collection<DataModel> selectByConditions(DataModelCondition condition) {
		return dataModelMapper.selectByConditions2(condition);
	}
	
	
	
}
