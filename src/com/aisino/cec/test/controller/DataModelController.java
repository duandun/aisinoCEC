package com.aisino.cec.test.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aisino.cec.common.util.check.CheckUtils;
import com.aisino.cec.common.util.web.BaseController;
import com.aisino.cec.test.conditionbean.DataModelCondition;
import com.aisino.cec.test.model.DataModel;
import com.aisino.cec.test.service.IDataModelService;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping(value="/dataModel")
public class DataModelController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(DataModelController.class);
	
	@Resource(name="dataModelService")
	private IDataModelService dataModelService;
	
	
	@RequestMapping("/selectKey")
	public String selectKey(int id,Model model){
		DataModel dataModel = dataModelService.selectByPrimaryKey(id);
		model.addAttribute("dataModel", dataModel);
		return "dataModel/selectKey";
	}
	
	@RequestMapping("/selectByCondition")
	public String selectByCondition(DataModelCondition condition,String pageNum,String pageSize,Model model){
		
		//IMemcachedCache memClient = MemUtil.getMemClient();
		//memClient.add("test", "2015-04-30");
			
		
		Set<ConstraintViolation<DataModelCondition>> failures = validator.validate(condition);
		if(!failures.isEmpty()){
			Iterator<ConstraintViolation<DataModelCondition>> iterator = failures.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next()+"\n");
			}
			logger.debug("_______________________________________________________");
			return "redirect:/test.jsp";
		}
		
		PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize), true);
		Collection<DataModel> dataModels = dataModelService.selectByConditions(condition);
		model.addAttribute("dataModels",dataModels);
		logger.debug("___________________________success____________________________");
		return "dataModel/selectKey";
	}
	
	@RequestMapping("/selectByCondition2")
	public String selectByCondition(@RequestParam Map<String,?> conditionMap,Model model){
		conditionMap = CheckUtils.checkNullValue(conditionMap);
		
		String pageNum=(String)conditionMap.get("pageNum");
		String pageSize=(String)conditionMap.get("pageSize");
		PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(pageSize), true);
		Collection<DataModel> dataModels = dataModelService.selectByConditions(conditionMap);
		model.addAttribute(dataModels);
		
		return "dataModel/selectKey";
	}
}
