/**
 * @Title: SkuController.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @Copyright (c) 2015, Aisino All Rights Reserved.
 */
/**    
 * @Title: SkuController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @Copyright (c) 2015, Aisino All Rights Reserved.
 */
package com.aisino.cec.product.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aisino.cec.common.util.random.IMajorKey;
import com.aisino.cec.common.util.web.BaseController;
import com.aisino.cec.enterprise.model.authentication.AuditInfo;
import com.aisino.cec.product.conditionbean.SkuAttrCondition;
import com.aisino.cec.product.enumpackage.SkuAttrEnum;
import com.aisino.cec.product.model.SkuAttr;
import com.aisino.cec.product.model.SkuOption;
import com.aisino.cec.product.service.ISkuAttrService;
import com.aisino.cec.product.service.ISkuOptionService;
import com.aisino.cec.user.model.User;
import com.aisino.cec.user.service.IUserService;

/**
 * @ClassName: SkuController
 * @Description: TODO(用一句话描述这个类的作用)
 * @author cr
 * @version V1.0
 */

/**  
 * @Package com.aisino.cec.product.controller  
 * @ClassName: SkuController  
 * @Description: TODO(用一句话描述这个类的作用)  
 * @author cr  
 * @date 2015-5-25 上午11:15:25  
 * @version V1.0    
 */

@Controller
@RequestMapping(value="/skuManage")
public class SkuController extends BaseController{
    
    @Resource(name="skuAttrService")
    private ISkuAttrService skuAttrService;
    
    @Resource(name="skuOptionService")
    private ISkuOptionService skuOptionService;
    
    @Resource(name="userService")
    private IUserService userService;
    
    
    /**
     * 插入一条sku属性记录
     * @param skuAttr
     */
    @RequestMapping("/insertSkuAttr/{categoryId}")
    @ResponseBody
    public void insertSkuAttr(SkuAttr skuAttr, @PathVariable String categoryId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
       
        boolean resultCheck = false;
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        String userName = request.getRemoteUser();
        List<User> userList = userService.getByUserName(userName);
        if(!userList.isEmpty()) {
            skuAttr.setCreateUserId(userList.get(0).getUserId());
        }
       
        try {
            skuAttr.setCategoryId(categoryId);
            resultCheck = skuAttrService.insertSkuAttr(skuAttr);
            if(resultCheck) {
                result.put("result", "true");
                result.put("skuAttrId", skuAttr.getSkuAttrId());
         
            } else {
                result.put("result", "false");
            }
        }catch(Exception e) {
            result.put("result", "false");
            e.printStackTrace();
            
        }
        
        resultMapper.writeValue(response.getWriter(), result);
    }
    
    @RequestMapping("/skuAttr/{skuAttrId}")
    @ResponseBody
    public void getSkuAttrById(@PathVariable String skuAttrId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
        
        SkuAttr skuAttr = skuAttrService.findSkuAttrById(skuAttrId);
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        
        resultMapper.writeValue(response.getWriter(), skuAttr);
    }
    
    /**
     * 根据分类id显示sku属性
     * @param classifyId
     * @param request
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/category/{categoryId}")
    @ResponseBody
    public void getSkuAttrByClassify(@PathVariable String categoryId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
        
        SkuAttrCondition condition = new SkuAttrCondition();
        condition.setCategoryId(categoryId);
        List<SkuAttr> skuAttrList = skuAttrService.selectByCondition(condition);
        ObjectMapper resultMapper = new ObjectMapper();
        
        resultMapper.writeValue(response.getWriter(), skuAttrList);
    }
    
    /**
     * 维护名称重复校验
     * @param storeName
     * @return
     */
    @RequestMapping("/storeNameCheck")
    @ResponseBody
    public String storeNameCheck(String storeName, String categoryId) {
        
        String result = "false";      
        boolean resultCheck = skuAttrService.checkStoreName(storeName,categoryId);
        if(resultCheck) {
            result = "true";
        }
        else {
            result = "false";
        }
        return result;
    }
    
    /**
     * 前端名称重复校验
     * @param frontName
     * @return
     */
    @RequestMapping("/frontNameCheck")
    @ResponseBody
    public String frontNameCheck(String frontName, String categoryId) {
        
        String result = "false";       
        boolean resultCheck = skuAttrService.checkFrontName(frontName, categoryId);
        if(resultCheck) {
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }
    
    /**
     * 更新一条sku属性记录
     * @param skuAttr
     */
    @RequestMapping("/updateSkuAttr")
    @ResponseBody
    public void updateSkuAttr(SkuAttr skuAttr, HttpServletRequest request, HttpServletResponse response)
    throws JsonGenerationException, JsonMappingException, IOException  {
        boolean resultCheck = false;
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        String userName = request.getRemoteUser();
        List<User> userList = userService.getByUserName(userName);
        if(!userList.isEmpty()) {
            skuAttr.setModifyUserId(userList.get(0).getUserId());
        }
       
        try {
            resultCheck = skuAttrService.updateSkuAttr(skuAttr);
            if(resultCheck) {
                result.put("result", "true");
                result.put("skuAttrId", skuAttr.getSkuAttrId());
         
            } else {
                result.put("result", "false");
            }
        }catch(Exception e) {
            result.put("result", "false");
            e.printStackTrace();
            
        }
        
        resultMapper.writeValue(response.getWriter(), result);
    }
    
    /**
     * 根据条件筛选查找sku属性
     * @param skuAttrCondition
     * @return
     */
    @RequestMapping("/selectByCondition")
    public List<SkuAttr> selectByCondition(SkuAttrCondition skuAttrCondition) {
        
        return null;
    }
    
    @RequestMapping("/skuOption/{skuAttrId}")
    @ResponseBody
    public void selectSkuOptionBySkuAttrId(@PathVariable String skuAttrId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
       
        List<SkuOption> skuOptionList = skuOptionService.findSkuOptionBySkuAttrId(skuAttrId);
        ObjectMapper resultMapper = new ObjectMapper();
        resultMapper.writeValue(response.getWriter(), skuOptionList);

    }
    
    @RequestMapping("/insertSkuOption/{skuAttrId}")
    @ResponseBody
    public void insertSkuOption(SkuOption skuOption, @PathVariable String skuAttrId, HttpServletRequest request, HttpServletResponse response)
        throws JsonGenerationException, JsonMappingException, IOException {
        
        boolean resultCheck = false;
        ObjectMapper resultMapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        String userName = request.getRemoteUser();
        List<User> userList = userService.getByUserName(userName);
        if(!userList.isEmpty()) {
            skuOption.setCreateUserId(userList.get(0).getUserId());
        }
       
        try {
            skuOption.setSkuAttrId(skuAttrId);
            resultCheck = skuOptionService.insertSkuOption(skuOption);
            if(resultCheck) {
                result.put("result", "true");
                result.put("skuOptionId", skuOption.getSkuOptionId());
         
            } else {
                result.put("result", "false");
            }
        }catch(Exception e) {
            result.put("result", "false");
            e.printStackTrace();
            
        }
        
        resultMapper.writeValue(response.getWriter(), result);
    }
    
    /**
     * 校验sku属性值是否重复
     * @param value
     * @return
     */
    @RequestMapping("/valueCheck")
    @ResponseBody
    public String skuOptionValueCheck(String value, String skuAttrId) {
        String result = "false";
        boolean resultCheck = skuOptionService.checkValue(value, skuAttrId);
        if(resultCheck) {
            result = "true";
        } else {
            result = "false";
        }
        return result;
    }
}
