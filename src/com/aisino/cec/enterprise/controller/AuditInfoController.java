package com.aisino.cec.enterprise.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aisino.cec.common.util.web.BaseController;
import com.aisino.cec.enterprise.model.authentication.AuditInfo;
import com.aisino.cec.enterprise.service.IAuditInfoService;

/**
 * 平台审核企业认证controller
 * 
 * @author leo
 */
@Controller
@RequestMapping(value = "/auditInfo")
public class AuditInfoController extends BaseController {

    @Autowired
    private IAuditInfoService auditInfoService;

    /**
     * 保存审核信息
     * 
     * @param request
     * @param response
     * @param auditInfo
     *            认证审核信息映射对象
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/saveAuditInfo")
    @ResponseBody
    public void saveAuditInfo(HttpServletRequest request, HttpServletResponse response, AuditInfo auditInfo)
            throws JsonGenerationException, JsonMappingException, IOException {
        Set<ConstraintViolation<AuditInfo>> failures = validator.validate(auditInfo);
        if (failures.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<String, Object>();
            auditInfo.setAuditorName(request.getRemoteUser());
            boolean result = auditInfoService.saveAuditInfo(auditInfo);
            map.put("result", result);
            mapper.writeValue(response.getWriter(), map);
        }
    }
}
