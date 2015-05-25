package com.aisino.cec.common.util.check;

import java.util.LinkedHashMap;
import java.util.Map;

public final class CheckUtils {
	private CheckUtils(){
		
	}
	
	public static Map<String,?> checkNullValue(Map<String,?> conditionMap){
		
		boolean b=false;
		for (Map.Entry<String, ?> entry : conditionMap.entrySet()) {
			if(isNull(entry.getValue())){
				b=true;
				break;
			}
			   
		}
		
		if(b){
			Map<String,Object> resultMap=new LinkedHashMap<String,Object>();
			for (Map.Entry<String, ?> entry : conditionMap.entrySet()) {
				if(!isNull(entry.getValue())){
					resultMap.put(entry.getKey(), entry.getValue());
				}
				   
			}
			return resultMap;
		}
		
		return conditionMap;
		
	}
	
	private static boolean isNull(Object obj){
		if(obj==null||"".equals(obj.toString().trim())){
			return true;
		}
		return false;
	}
}
