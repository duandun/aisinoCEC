package com.aisino.cec.enterprise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aisino.cec.common.util.calendar.CalendarUtil;
import com.aisino.cec.common.util.web.BaseController;
import com.aisino.cec.enterprise.conditionbean.AuthenticationInfoCondition;
import com.aisino.cec.enterprise.enumpackage.authentication.AuditStatusEnum;
import com.aisino.cec.enterprise.model.authentication.AuditInfo;
import com.aisino.cec.enterprise.model.authentication.AuthenticationInfo;
import com.aisino.cec.enterprise.service.IAuditInfoService;
import com.aisino.cec.enterprise.service.IAuthenticationService;
import com.aisino.cec.enterprise.service.IEnterpriseService;
import com.aisino.cec.enterprise.vo.authentication.AuthenticationBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 企业认证的controller
 * 
 * @author lxy
 */
@Controller
@RequestMapping(value = "/authentication")
public class AuthenticationController extends BaseController {

    /**
     * 企业认证的service
     */
    @Autowired
    private IAuthenticationService authenticationService;

    /**
     * 获取企业信息的service
     */
    @Autowired
    private IEnterpriseService enterpriseService;

    @Autowired
    private IAuditInfoService auditInfoService;

    /**
     * 发起认证申请的响应方法
     * 
     * @param authenticationBean
     *            认证申请bean
     * @param bindingResult
     *            jsr303后台校验结果
     * @return
     */
    @RequestMapping("/applying")
    public ModelAndView applying(@Valid @ModelAttribute("authenticationBean") AuthenticationBean authenticationBean,
            BindingResult bindingResult) {
        // 如果jsr303验证出现错误，直接跳转到错误页面
        if (bindingResult.hasErrors()) {
            ModelAndView errorModelAndView = new ModelAndView("../../error");
            errorModelAndView.addObject("errorMsg", "参数错误");
            return errorModelAndView;
        }

        String authenticationId = null;
        boolean result = false;
        String resultMsg = "";
        // 如果认证ID为空，说明是一个插入操作
        if (authenticationBean.getAuthenticationId() == null) {
            // 保存认证申请，并得到返回值认证申请ID
            authenticationId = authenticationService.saveAuthenticationApply(authenticationBean);
            if (authenticationId != null) {
                result = true;
            }
            else {
                // 如果认证申请ID为空，说明保存失败，发生了异常
                resultMsg = "保存失败";
            }
        }
        else {
            // 如果认证ID不为空，说明是一个更新操作，并接受更新的结果
            result = authenticationService.updateAuthenticationApply(authenticationBean);
            authenticationId = authenticationBean.getAuthenticationId();
            // 如果结果是false，那么说明更新失败
            if (!result) {
                resultMsg = "更新失败";
            }
        }

        // 如果插入或者更新失败的话，跳转到错误页面
        if (!result) {
            ModelAndView errorModelAndView = new ModelAndView("../../error");
            errorModelAndView.addObject("errorMsg", resultMsg);
            return errorModelAndView;
        }

        // 若果没有任何错误发生的话，跳转到认证状态页面
        ModelAndView resultModelAndView = new ModelAndView("authentication/etrAuthenticationStatus");
        resultModelAndView.addObject("authenticationId", authenticationId);
        resultModelAndView.addObject("enterpriseId", authenticationBean.getEnterpriseId());
        resultModelAndView.addObject("enterpriseName", authenticationBean.getEnterpriseName());
        resultModelAndView.addObject("status", AuditStatusEnum.WAITPASS.getKey());
        resultModelAndView.addObject("waitPass", AuditStatusEnum.WAITPASS.getKey());
        return resultModelAndView;
    }

    /**
     * 跳转到企业认证申请状态页面的响应方法
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/toEtrAuthenticationStatusPage")
    public ModelAndView toEtrAuthenticationStatusPage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView etrAuthenticationStatusView = new ModelAndView();

        etrAuthenticationStatusView.addObject("waitPass", AuditStatusEnum.WAITPASS.getKey());
        etrAuthenticationStatusView.addObject("notPass", AuditStatusEnum.NOTPASS.getKey());
        etrAuthenticationStatusView.addObject("passed", AuditStatusEnum.PASSED.getKey());

        // 从请求中获取企业ID，后面这里可能需要更改
        String enterpriseId = request.getParameter("enterpriseId");
        // 查询企业ID对应的企业名称
        String enterpriseName = enterpriseService.findEnterpriseNameById(enterpriseId);
        if (enterpriseName == null) {
            // 如果企业名称为空，说明没有找到企业ID对应的企业，那么跳转到错误页面
            ModelAndView errorModelAndView = new ModelAndView("../../error");
            errorModelAndView.addObject("errorMsg", "没有找到相应的企业");
            return errorModelAndView;
        }
        // enterpriseId = "906E4229D3204D1CB39EAAA98F68206A";
        // enterpriseName = "中国人民银行";
        // 根据企业ID，查询企业认证信息
        AuthenticationInfo authenticationInfo = authenticationService.findByEnterpriseId(enterpriseId);
        // 如果认证信息为空，说明之前就没有发起过认证申请
        if (authenticationInfo == null) {
            etrAuthenticationStatusView.addObject("status", null);
        }
        else {
            etrAuthenticationStatusView.addObject("status", authenticationInfo.getStatus());
            etrAuthenticationStatusView.addObject("authenticationId", authenticationInfo.getAuthenticationId());
        }

        etrAuthenticationStatusView.addObject("enterpriseName", enterpriseName);
        etrAuthenticationStatusView.addObject("enterpriseId", enterpriseId);
        etrAuthenticationStatusView.setViewName("authentication/etrAuthenticationStatus");

        return etrAuthenticationStatusView;
    }

    /**
     * 跳转到填写企业认证信息的页面
     * 
     * @param request
     * @param response
     * @param enterpriseId
     *            企业ID
     * @param enterpriseName
     *            企业名称
     * @param authenticationId
     *            企业认证ID
     * @return
     */
    @RequestMapping("/toEtrAuthenticationPage")
    public ModelAndView toEtrAuthenticationPage(HttpServletRequest request, HttpServletResponse response,
            String enterpriseId, String enterpriseName, String authenticationId) {
        ModelAndView etrAuthenticationView = new ModelAndView();
        AuthenticationBean authenticationBean = null;
        // 如果企业认证ID不为空，说明之前发起国认证申请， 需要先查询之前填写的认证信息
        if (authenticationId != null) {
            authenticationBean = authenticationService.findByAuthenticationId(authenticationId);
            etrAuthenticationView.addObject("status", authenticationBean.getStatus());
        }
        else {
            authenticationBean = new AuthenticationBean();
            authenticationBean.setEnterpriseId(enterpriseId);
            authenticationBean.setEnterpriseName(enterpriseName);
        }

        etrAuthenticationView.addObject("authenticationBean", authenticationBean);
        etrAuthenticationView.addObject("passed", AuditStatusEnum.PASSED.getKey());
        etrAuthenticationView.setViewName("authentication/etrAuthentication");
        return etrAuthenticationView;
    }

    /**
     * 根据条件查询企业申请认证的信息列表
     * 
     * @param condition
     *            平台审核企业申请认证信息查询bean
     * @return ModelAndView
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/findAuthenticationInfoList")
    public ModelAndView findAuthenticationInfoList(AuthenticationInfoCondition condition) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        Set<ConstraintViolation<AuthenticationInfoCondition>> failures = validator.validate(condition);
        if (failures.isEmpty()) {
            // 设置分页
            PageHelper.startPage(condition.getPageNum(), condition.getPageSize(), true);
            // 查询时截止日期加1天
            if (condition.getEndApplyTime() != null) {
                condition.setEndApplyTime(CalendarUtil.dateAdd(condition.getEndApplyTime(), 1));
            }
            List<AuthenticationInfo> list = authenticationService.selectByCondition(condition);
            dataMap.put("pageNum", condition.getPageNum());
            dataMap.put("totalPages", ((Page) list).getPages());
            dataMap.put("list", list);
            // 回显截止日期减1天到实际日期
            if (condition.getEndApplyTime() != null) {
                condition.setEndApplyTime(CalendarUtil.dateAdd(condition.getEndApplyTime(), -1));
            }
            dataMap.put("condition", condition);
        }
        return new ModelAndView("auditInfo/auditList", dataMap);
    }

    /**
     * 根据认证信息id查询企业认证信息详情
     * 
     * @param authenticationId
     *            认证请求ID
     * @return ModelAndView
     */
    @RequestMapping("/show/{authenticationId}")
    public ModelAndView showAuthenticationInfo(@PathVariable String authenticationId) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        // 查询认证相关信息
        AuthenticationBean authenticationBean = authenticationService.findByAuthenticationId(authenticationId);
        dataMap.put("authenticationBean", authenticationBean);
        // 查询该企业的历史审核记录
        List<AuditInfo> auditInfoList = auditInfoService.findAuditInfo(authenticationId);
        dataMap.put("auditInfoList", auditInfoList);
        //待审核
        dataMap.put("watiPass", AuditStatusEnum.WAITPASS.getKey());
        return new ModelAndView("auditInfo/auditDetail", dataMap);
    }
}
