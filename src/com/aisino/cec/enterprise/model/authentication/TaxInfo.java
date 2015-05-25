package com.aisino.cec.enterprise.model.authentication;

/**
 * 申请成为卖家的认证相关信息：纳税信息映射对象
 * 
 * @author zhaoTh
 */
public class TaxInfo {

    /** 纳税信息对象id */
    private String taxId;

    /** 纳税登记证号 */
    private String taxRegNum;

    /** 纳税人识别号 */
    private String taxpayerIdNum;

    /** 纳税登记证附件地址 */
    private String taxRegCard;

    /** 认证请求ID */
    private String authenticationId;

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
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

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

}
