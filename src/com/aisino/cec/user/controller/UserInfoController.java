package com.aisino.cec.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.aisino.cec.enterprise.model.EnterpriseInfo;
import com.aisino.cec.enterprise.service.IEnterpriseInfoService;
import com.aisino.cec.user.model.User;
import com.aisino.cec.user.model.UserInfo;
import com.aisino.cec.user.service.IUserInfoService;
import com.aisino.cec.user.service.IUserService;
import com.aisino.cec.user.vo.UserInfoVo;

/**
 * 完善用户企业信息controller
 * 
 * @author leo
 */
@Controller
@RequestMapping(value = "user")
public class UserInfoController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IEnterpriseInfoService enterpriseInfoService;

    /**
     * 查询用户企业信息
     * 
     * @param userName
     * @param response
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/findUserInfoVo")
    @ResponseBody
    public void findUserInfoVo(String userName, HttpServletResponse response) throws JsonGenerationException,
            JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        UserInfoVo userInfoVo = new UserInfoVo();
        List<User> userList = userService.getByUserName(userName);
        if (null != userList && !userList.isEmpty()) {
            User user = userList.get(0);
            // 用户id
            userInfoVo.setUserId(user.getUserId());
            // 用户手机
            userInfoVo.setUserPhone(user.getUserPhone());
            // 企业名称
            userInfoVo.setEnterpriseName(user.getEnterpriseName());
            UserInfo userInfo = userInfoService.findUserInfoByUserId(user.getUserId());
            if (null != userInfo) {
                // 用户姓名
                userInfoVo.setUserRealName(userInfo.getUserRealName());
                // 用户性别
                userInfoVo.setUserGender(userInfo.getUserGender());
                // 用户职位
                userInfoVo.setUserPosition(userInfo.getUserPosition());
            }
            EnterpriseInfo enterpriseInfo = enterpriseInfoService.findEnterpriseInfoByEtpId(user.getEnterpriseId());
            if (null != enterpriseInfo) {
                userInfoVo.setMainIndustry(enterpriseInfo.getMainIndustry());
                userInfoVo.setMainProduct(enterpriseInfo.getMainProduct());
                userInfoVo.setProvince(enterpriseInfo.getProvince());
                userInfoVo.setCity(enterpriseInfo.getCity());
                userInfoVo.setDistrict(enterpriseInfo.getDistrict());
                userInfoVo.setStreet(enterpriseInfo.getStreet());
            }
        }
        map.put("userInfoVo", userInfoVo);
        mapper.writeValue(response.getWriter(), map);
    }

    /**
     * 保存用户企业信息
     * 
     * @param response
     * @param userInfoVo
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("/saveUserInfo")
    @ResponseBody
    public void saveUserInfo(HttpServletResponse response, UserInfoVo userInfoVo) throws JsonGenerationException,
            JsonMappingException, IOException {
        Set<ConstraintViolation<UserInfoVo>> failures = validator.validate(userInfoVo);
        if (failures.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<String, Object>();
            boolean result = userInfoService.saveUserInfo(userInfoVo);
            map.put("result", result);
            mapper.writeValue(response.getWriter(), map);
        }
    }

}
