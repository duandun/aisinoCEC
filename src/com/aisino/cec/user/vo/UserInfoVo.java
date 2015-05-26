package com.aisino.cec.user.vo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInfoVo {

    /** 用户id */
    private String userId;

    /** 用户姓名 */
    @NotEmpty
    @Size(min = 2, max = 10)
    private String userRealName;

    /** 用户性别 */
    private String userGender;

    /** 手机号码 */
    @Pattern(regexp = "^(1[3|4|5|8])[\\d]{9}$")
    private String userPhone;

    /** 企业名称 */
    @NotEmpty
    @Size(max = 64)
    private String enterpriseName;

    /** 用户职位 */
    @Size(max = 32)
    private String userPosition;

    /** 主营行业 */
    private String mainIndustry;

    /** 主营产品 */
    @Size(max = 256)
    private String mainProduct;

    /** 所在省 */
    private String province;

    /** 所在市 */
    private String city;

    /** 所在区 */
    private String district;

    /** 所在街道 */
    @Size(max = 128)
    private String street;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMainIndustry() {
        return mainIndustry;
    }

    public void setMainIndustry(String mainIndustry) {
        this.mainIndustry = mainIndustry;
    }

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
