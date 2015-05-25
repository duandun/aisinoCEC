package com.aisino.cec.common.util.sendEmail;

import java.util.ArrayList;
import java.util.List;

import com.aisino.cec.common.enumpackage.sendEmail.SendMailEnum;

/**
 * 邮箱参数设置
 * 
 * @author leo
 */
public class EmailSettings {

    /** 发送协议 */
    private String sendProtocol = SendMailEnum.SENDER_MAIL_PROTOCOL.getValue();

    /** 发送协议端口 */
    private String sendPort = SendMailEnum.SENDER_MAIL_PROTOCOL_PORT.getValue();

    /** 邮件服务器地址 */
    private String sendServiceAddress = SendMailEnum.SENDER_MAIL_SERVICE_ADDRESS.getValue();

    /** 发送邮件时进行授权校验 */
    private String authCheck = SendMailEnum.SENDER_AUTH_TRUE.getValue();

    /** 系统发送邮箱地址 */
    private String senderMailAddress = SendMailEnum.SENDER_MAIL_ADDRESS.getValue();

    /** 系统发送邮箱密码 */
    private String senderMailPassword = SendMailEnum.SENDER_MAIL_PASSWORD.getValue();

    /** 编码格式 */
    private String charset = SendMailEnum.SENDER_CHARSET_UTF8.getValue();

    /** 发送格式 */
    private String mimetype = SendMailEnum.SENDER_MIMETYPE_HTML.getValue();

    /** 收件人邮箱地址集合 */
    private List<String> addressList = new ArrayList<String>();

    /** 邮件主题 */
    private String mailSubject;

    /** 邮件内容 */
    private String mailContent;

    public String getSendProtocol() {
        return sendProtocol;
    }

    public void setSendProtocol(String sendProtocol) {
        this.sendProtocol = sendProtocol;
    }

    public String getSendPort() {
        return sendPort;
    }

    public void setSendPort(String sendPort) {
        this.sendPort = sendPort;
    }

    public String getSendServiceAddress() {
        return sendServiceAddress;
    }

    public void setSendServiceAddress(String sendServiceAddress) {
        this.sendServiceAddress = sendServiceAddress;
    }

    public String getAuthCheck() {
        return authCheck;
    }

    public void setAuthCheck(String authCheck) {
        this.authCheck = authCheck;
    }

    public String getSenderMailAddress() {
        return senderMailAddress;
    }

    public void setSenderMailAddress(String senderMailAddress) {
        this.senderMailAddress = senderMailAddress;
    }

    public String getSenderMailPassword() {
        return senderMailPassword;
    }

    public void setSenderMailPassword(String senderMailPassword) {
        this.senderMailPassword = senderMailPassword;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

}
