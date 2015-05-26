/**
 * @Title: ClassifyTree.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright (c) 2015, Aisino All Rights Reserved.
 */
/**    
 * @Title: ClassifyTree.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @Copyright (c) 2015, Aisino All Rights Reserved.
 */
package com.aisino.cec.classify.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ClassifyTree
 * @Description: TODO(用一句话描述这个类的作用)
 * @author cr
 * @version V1.0
 */

/**  
 * @Package com.aisino.cec.classify.controller  
 * @ClassName: ClassifyTree  
 * @Description: TODO(用一句话描述这个类的作用)  
 * @author cr  
 * @date 2015-5-19 上午09:55:53  
 * @version V1.0    
 */

@Controller
@RequestMapping(value = "classify")
public class ClassifyTree {
    
    @RequestMapping("/treeData")
    @ResponseBody
    public void treeData(HttpServletResponse response) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        for(int i = 1; i<5;i++) {
            data.put("id", i);
            data.put("pId", 1);
            data.put("name", "haha"+i);
            dataList.add(data);
        }
        
        mapper.writeValue(response.getWriter(), dataList);
    }
    
    @RequestMapping("/getChildNodes")
    @ResponseBody
    public void getChildNodes(HttpServletRequest request,HttpServletResponse response) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<String, Object>();
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        String parentId = request.getParameter("id");
        for(int i = 0;i<10;i++) {
            data.put("id", i);
            data.put("pId", parentId);
            data.put("name", "子节点--"+parentId+"--" +i);
            data.put("categoryId", i+10);
            dataList.add(data);
        }
        mapper.writeValue(response.getWriter(), dataList);
    }
    
    @RequestMapping("/publicParam")
    public String publicParam() {
        return "classify/publicParam";
    }
    
    @RequestMapping("/skuParam")
    public String skuParam() {
        return "classify/skuParam";
    }
}
