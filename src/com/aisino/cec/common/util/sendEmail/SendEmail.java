package com.aisino.cec.common.util.sendEmail;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.aisino.cec.common.enumpackage.sendEmail.SendMailEnum;

/**
 * 发送邮件工具类
 * 
 * @author leo
 */
public class SendEmail {

    /**
     * 根据邮件地址创建邮件接收者网络地址
     * 
     * @param addressSet
     *            收件人邮件地址集合
     * @return
     */
    private static InternetAddress[] createInternetAddress(List<String> addressList) {
        InternetAddress[] receivers = new InternetAddress[addressList.size()];
        for (int i = 0; i < receivers.length; i++) {
            try {
                receivers[i] = new InternetAddress(addressList.get(i));
            }
            catch (AddressException e) {
                e.printStackTrace();
            }
        }
        return receivers;
    }

    /**
     * 发送邮件
     * 
     * @param emailSettings
     *            邮件参数
     * @return 发送结果
     */
    public static boolean sendEmail(EmailSettings emailSettings) {
        boolean result = false;
        if (emailSettings.getAddressList().size() != 0) {
            // 邮件接收者网络地址
            InternetAddress[] receivers = createInternetAddress(emailSettings.getAddressList());
            Properties props = new Properties();
            // 设置协议
            props.put("mail.store.protocol", emailSettings.getSendProtocol());
            // 设置端口
            props.put("mail.smtp.port", emailSettings.getSendPort());
            // 设置SMTP服务器地址
            props.put("mail.smtp.host", emailSettings.getSendServiceAddress());
            // 如果是TRUE，就会登录SMTP服务器，获得授权才能发送邮件;默认为False。
            props.put("mail.smtp.auth", emailSettings.getAuthCheck());
            // 系统发送邮箱地址
            final String senderMailAddress = emailSettings.getSenderMailAddress();
            // 系统发送邮箱密码
            final String senderMailPassword = emailSettings.getSenderMailPassword();
            // 邮件服务器登录验证
            Authenticator authenticator = new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderMailAddress, senderMailPassword);
                }
            };
            // 使用Properties创建Session
            Session session = Session.getDefaultInstance(props, authenticator);
            // 是否输出测试信息
            session.setDebug(false);
            try {
                // 使用session创建MIME类型的消息
                MimeMessage mimeMessage = new MimeMessage(session);
                // 设置发送者邮箱地址
                mimeMessage.setFrom(new InternetAddress(senderMailAddress));
                // 设置收件人
                // Message.RecipientType.TO表示主要接收人，Message.RecipientType.CC表示抄送人，Message.RecipientType.BCC表示秘密抄送人
                mimeMessage.setRecipients(Message.RecipientType.TO, receivers);
                // 设置邮件主题
                mimeMessage.setSubject(emailSettings.getMailSubject(), emailSettings.getCharset());
                // 设置邮件内容
                mimeMessage.setContent(emailSettings.getMailContent(), emailSettings.getMimetype() + ";charset="
                        + emailSettings.getCharset());
                // 设置发送时间
                mimeMessage.setSentDate(new Date());
                // 发送邮件
                Transport.send(mimeMessage);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            result = true;
        }
        return result;
    }

    /**
     * 设置发送邮件内容
     * 
     * @param emailType
     *            邮件类型
     * @param id
     *            用户唯一标识
     * @param verifyCode
     *            验证码
     * @return
     */
    public static String createEmailContent(String emailType, String id, String verifyCode) {
        StringBuffer mailContent = new StringBuffer();
        // 注册
        if (SendMailEnum.MAIL_TYPE_REGISTER.getValue().equals(emailType)) {
            mailContent.append("点击下面链接激活账号，48小时内有效，超期请重新注册账号，链接只能使用一次，请尽快激活！</br>");
//            mailContent.append("<a href=\"" + SendMailEnum.SENDER_OUTSIDE_WEB_ADDRESS.getValue()
//                    + "/account/activateAccount.html");
            
            mailContent.append("<a href=\"" + SendMailEnum.SENDER_INSIDE_WEB_ADDRESS.getValue()
                    + "/user/activateUser.html");
        }
        // 找回密码
        if (SendMailEnum.MAIL_TYPE_FINDPWD.getValue().equals(emailType)) {
            mailContent.append("点击下面链接找回密码，48小时内有效，超期请重新点击首页的“找回密码”，请尽快找回！</br>");
            mailContent.append("<a href=\"" + SendMailEnum.SENDER_OUTSIDE_WEB_ADDRESS.getValue()
                    + "/user/retakePwd.html");
        }
        mailContent.append("?" + SendMailEnum.SENDER_MAIL_HLINK_PINCODE.getValue() + "=" + id);
        mailContent.append("&" + SendMailEnum.SENDER_MAIL_HLINK_CDKEY.getValue() + "=" + verifyCode);
        mailContent.append("\" target=\"new_window\">");
        // 注册
        if (SendMailEnum.MAIL_TYPE_REGISTER.getValue().equals(emailType)) {
            mailContent.append("点此激活您的账户");
        }
        // 找回密码
        if (SendMailEnum.MAIL_TYPE_FINDPWD.getValue().equals(emailType)) {
            mailContent.append("点此找回您的账号密码");
        }
        mailContent.append("</a>");
        return mailContent.toString();
    }
    
}
