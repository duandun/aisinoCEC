package com.aisino.cec.enterprise.vo.authentication;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * 企业认证数据传输对象
 * 
 * @author zhaoTh
 */
public class AuthenticationBean {

    /** 联系人姓名：15个汉字或者30个英文字母 */
    @NotNull
    @Size(max = 30)
    private String contactName;

    /** 联系人电话：手机 */
    @NotNull
    @Size(max = 11)
    private String contactPhone;

    /** 联系人邮箱 ：50位 */
    @NotNull
    @Email
    @Size(max = 50)
    private String contactEmail;

    /** 公司名称 ：120位 */
    @NotNull
    @Size(max = 120)
    private String enterpriseName;

    /** 法定代表人姓名 ：15个汉字或者30个英文字母 */
    @NotNull
    @Size(max = 30)
    private String legalPersonName;

    /** 法定代表人身份证号码:15或者18 */
    @NotNull
    @Size(min = 15, max = 18)
    private String legalPersonIdNum;

    /** 法定代表人身份证附件地址 */
    private String legalPersonIdCard;

    /** 工商注册号 ：13位或者15位 */
    @NotNull
    @Size(min = 13, max = 15)
    private String registeredNum;

    /** 营业执照附件地址 */
    private String registeredCard;

    /** 组织机构代码 ：10位 */
    @NotNull
    @Size(max = 10)
    private String organizationCode;

    /** 组织机构代码证附件地址 */
    private String organizationCard;

    /** 纳税登记证号 ：15位或者18位 */
    @NotNull
    @Size(min = 15, max = 18)
    private String taxRegNum;

    /** 纳税人识别号 ：15、17、18或者20位 */
    @NotNull
    @Size(min = 15, max = 20)
    private String taxpayerIdNum;

    /** 纳税登记证附件地址 */
    private String taxRegCard;

    /** 企业ID */
    private String enterpriseId;

    /** 认证申请ID */
    private String authenticationId;

    /** 认证状态 */
    private String status;

    /** 认证状态说明 */
    private String statusDesc;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getLegalPersonIdNum() {
        return legalPersonIdNum;
    }

    public void setLegalPersonIdNum(String legalPersonIdNum) {
        this.legalPersonIdNum = legalPersonIdNum;
    }

    public String getLegalPersonIdCard() {
        return legalPersonIdCard;
    }

    public void setLegalPersonIdCard(String legalPersonIdCard) {
        this.legalPersonIdCard = legalPersonIdCard;
    }

    public String getRegisteredNum() {
        return registeredNum;
    }

    public void setRegisteredNum(String registeredNum) {
        this.registeredNum = registeredNum;
    }

    public String getRegisteredCard() {
        return registeredCard;
    }

    public void setRegisteredCard(String registeredCard) {
        this.registeredCard = registeredCard;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationCard() {
        return organizationCard;
    }

    public void setOrganizationCard(String organizationCard) {
        this.organizationCard = organizationCard;
    }

    public String getTaxRegNum() {
        return taxRegNum;
    }

    public void setTaxRegNum(String taxRegNum) {
        this.taxRegNum = taxRegNum;
    }

    public String getTaxpayerIdNum() {
        return taxpayerIdNum;
    }

    public void setTaxpayerIdNum(String taxpayerIdNum) {
        this.taxpayerIdNum = taxpayerIdNum;
    }

    public String getTaxRegCard() {
        return taxRegCard;
    }

    public void setTaxRegCard(String taxRegCard) {
        this.taxRegCard = taxRegCard;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
