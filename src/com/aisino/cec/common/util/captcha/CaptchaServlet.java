package com.aisino.cec.common.util.captcha;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aisino.cec.common.enumpackage.captcha.CaptchaCodeLevel;
import com.aisino.cec.common.enumpackage.captcha.LoginEnum;

@SuppressWarnings("serial")
public class CaptchaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            // 获取设定难度和长度的验证码
            String captchaCode = Captcha.createRandomCode(4, CaptchaCodeLevel.Hard, true);
            HttpSession session = request.getSession();
            session.removeAttribute(LoginEnum.LOGIN_CAPTCHA.getValue());
            session.setAttribute(LoginEnum.LOGIN_CAPTCHA.getValue(), captchaCode);
            ImageIO.write(Captcha.disturb(), "JPEG", response.getOutputStream());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
