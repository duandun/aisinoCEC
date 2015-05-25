package com.aisino.cec.common.enumpackage.sendEmail;

public enum SendMailEnum {
    /** 发送协议端口 */
    SENDER_MAIL_PROTOCOL_PORT("25"),
    /** 发送协议 */
    SENDER_MAIL_PROTOCOL("smtp"),
    /** SMTP邮件服务器地址 */
    SENDER_MAIL_SERVICE_ADDRESS("smtp.tom.com"),
    /** text/plain是以纯文本格式发送 */
    SENDER_MIMETYPE_PLAIN("text/plain"),
    /** text/html是指以HTML网页形式发送 */
    SENDER_MIMETYPE_HTML("text/html"),
    /** 编码格式UTF-8 */
    SENDER_CHARSET_UTF8("UTF-8"),
    /** 编码格式GBK */
    SENDER_CHARSET_GBK("GBK"),
    /** 编码格式GB2312 */
    SENDER_CHARSET_GB2312("GB2312"),
    /** 发送邮件时进行授权校验 */
    SENDER_AUTH_TRUE("TRUE"),
    /** 发送邮件时不进行授权校验 */
    SENDER_AUTH_FALSE("FALSE"),
    /** 系统外网地址 */
    SENDER_OUTSIDE_WEB_ADDRESS("http://192.168.3.125:8080/aisinoCEC"),
    /** 系统内网地址 */
    SENDER_INSIDE_WEB_ADDRESS("http://192.168.3.125:8080/aisinoCEC"),
    /** 发送者邮箱 */
    SENDER_MAIL_ADDRESS("aisinocec@tom.com"),
    /** 发送者邮箱密码 */
    SENDER_MAIL_PASSWORD("aisino"),
    /** 邮件主题 */
    SENDER_MAIL_SUBJECT("激活账户"),
    /** 唯一认证码 */
    SENDER_MAIL_HLINK_PINCODE("pinCode"),
    /** 激活码 */
    SENDER_MAIL_HLINK_CDKEY("verifyCode"),
    /** 激验证不正确！ */
    MAIL_VERIFYCODE_WRONG("邮件验证码不正确！"),
    /** 邮件验证码过期！ */
    MAIL_VERIFYCODE_EXPIRE("邮件验证码过期！"),
    /** 重置密码链接已过期 */
    MAIL_LINK_EXPIRE("重置密码链接已过期！"),
    /** 激活码已失效！ */
    VERIFYCODE_INVALID("激活码已失效！"),
    /** 邮箱已激活，请登录！ */
    MAIL_ACTIVATED("邮箱已激活，请登录！"),
    /** 该邮箱未注册（邮箱地址不存在）！ */
    MAIL_NOT_EXIST("该邮箱未注册（邮箱地址不存在）！"),
    /** 注册邮件 */
    MAIL_TYPE_REGISTER("registerMail"),
    /** 找回密码邮件 */
    MAIL_TYPE_FINDPWD("findpwdMail"),
    /** 找回密码邮件主题 */
    FINDPWD_MAIL_SUBJECT("找回密码"),
    /** 密码重置成功 */
    RESET_PWD_SUCCESS("密码重置成功！"),
    /** 密码重置成功 */
    RESET_PWD_FAILURE("密码重置失败！");

    private final String value;

    SendMailEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
