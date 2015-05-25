package com.aisino.cec.common.util.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

import com.aisino.cec.common.enumpackage.captcha.CaptchaCodeLevel;

public class Captcha {

    private static int width = 102;

    private static int height = 34;

    private static Random random = new Random();

    /**
     * 验证码图片
     */
    private static BufferedImage buffImg;

    /**
     * 随机产生的验证码
     * 
     * @param codeCount
     * @param level
     * @param isCanRepeat
     * @return
     */
    public static String createRandomCode(int codeCount, CaptchaCodeLevel level, boolean isCanRepeat) {
        StringBuffer randomCode = new StringBuffer();

        String strRand = null;
        int xx = width / (codeCount + 1);
        int codeY = height - 4;

        char[] codeSequence =
                { '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm',
                        'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                        'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        // 根据不同的难度截取字符数组
        if (level == CaptchaCodeLevel.Simple) {
            codeSequence = Arrays.copyOfRange(codeSequence, 0, 8);
        }
        else if (level == CaptchaCodeLevel.Medium) {
            codeSequence = Arrays.copyOfRange(codeSequence, 0, 32);
        }
        else if (level == CaptchaCodeLevel.Hard) {
            codeSequence = Arrays.copyOfRange(codeSequence, 0, 57);
        }

        // 字符集合长度
        int n = codeSequence.length;
        // 抛出运行时异常
        if (codeCount > n && isCanRepeat == false) {
            throw new RuntimeException(String.format("调用SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)出现异常，"
                    + "当isCanRepeat为%3$s时，传入参数%1$s不能大于%4$s", codeCount, level, isCanRepeat, n));
        }

        Graphics2D graphics = graphicsInit();
        graphics.setColor(createColor());

        // 判断能否出现重复的字符
        for (int i = 0; i < codeCount; i++) {
            // 索引 0 and n-1
            int r = (int) (Math.random() * n);
            strRand = String.valueOf(codeSequence[r]);
            randomCode.append(strRand);
            if (!isCanRepeat) {
                codeSequence[r] = codeSequence[n - 1];
                n--;
            }
            // 设置每个字符的随机旋转
            AffineTransform at = new AffineTransform();
            int number = random.nextInt(3) - 1;
            double role = number * random.nextDouble() * (Math.PI / 4);
            at.setToRotation(role, (i + 1) * xx, codeY); // role:旋转角度,后面两个参数是设置围绕坐标点旋转
            graphics.setTransform(at);
            graphics.drawString(strRand, (i + 1) * xx, codeY);
        }

        // for (int i = 0; i < codeCount; i++) {
        // strRand = String.valueOf(codeSequence[random.nextInt(32)]);
        // randomCode.append(strRand);
        //
        // // 设置每个字符的随机旋转
        // AffineTransform at = new AffineTransform();
        // int number = random.nextInt(3) - 1;
        // double role = number * random.nextDouble() * (Math.PI / 4);
        // at.setToRotation(role, (i + 1) * xx, codeY); //
        // role:旋转角度,后面两个参数是设置围绕坐标点旋转
        // graphics.setTransform(at);
        //
        // graphics.drawString(strRand, (i + 1) * xx, codeY);
        // }

        return randomCode.toString();
    }

    /**
     * 创建颜色
     * 
     * @return
     */
    private static Color createColor() {
        Color color[] = new Color[10];
        color[0] = new Color(113, 31, 71);
        color[1] = new Color(37, 0, 37);
        color[2] = new Color(111, 33, 36);
        color[3] = new Color(0, 0, 112);
        color[4] = new Color(14, 51, 16);
        color[5] = new Color(1, 1, 1);
        color[6] = new Color(72, 14, 73);
        color[7] = new Color(65, 67, 29);
        color[8] = new Color(116, 86, 88);
        color[9] = new Color(41, 75, 71);

        return color[random.nextInt(10)];
    }

    /**
     * 绘制类初始化
     * 
     * @return
     */
    private static Graphics2D graphicsInit() {
        Graphics2D graphics = buffImgInit().createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setFont(new Font("Fixedsys", Font.BOLD, height - 2));
        graphics.drawRect(0, 0, width - 1, height - 1);
        return graphics;
    }

    /**
     * BufferedImage初始化
     * 
     * @return
     */
    private static BufferedImage buffImgInit() {
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        return buffImg;
    }

    /**
     * 绘制干扰特性的BufferedImage
     * 
     * @return
     */
    public static BufferedImage disturb() {
        drawDisturbLine(buffImg.createGraphics());
        return twistImage();
    }

    /**
     * 画干扰线使图象中的认证码不易被其它程序探测到
     * 
     * @param graphics
     */
    private static void drawDisturbLine(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        int x = 0;
        int y = 0;
        int xl = 0;
        int yl = 0;
        for (int i = 0; i < 15; i++) {
            x = random.nextInt(width);
            y = random.nextInt(height);
            xl = random.nextInt(20);
            yl = random.nextInt(10);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        for (int i = 0; i < 30; i++) {
            x = random.nextInt(width);
            y = random.nextInt(height);
            graphics.drawRect(x, y, 1, 1);
        }
    }

    /**
     * 正弦曲线Wave扭曲图片
     * 
     * @return
     */
    private static BufferedImage twistImage() {
        double dMultValue = random.nextInt(7) + 3;// 波形的幅度倍数，越大扭曲的程序越高，一般为3
        double dPhase = random.nextInt(6);// 波形的起始相位，取值区间（0-2＊PI）

        BufferedImage destBi = new BufferedImage(buffImg.getWidth(), buffImg.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < destBi.getWidth(); i++) {
            for (int j = 0; j < destBi.getHeight(); j++) {
                int nOldX = getXPosition4Twist(dPhase, dMultValue, destBi.getHeight(), i, j);
                int nOldY = j;
                if (nOldX >= 0 && nOldX < destBi.getWidth() && nOldY >= 0 && nOldY < destBi.getHeight()) {
                    destBi.setRGB(nOldX, nOldY, buffImg.getRGB(i, j));
                }
            }
        }
        return destBi;
    }

    /**
     * 获取扭曲后的x轴位置
     * 
     * @param dPhase
     * @param dMultValue
     * @param height
     * @param xPosition
     * @param yPosition
     * @return
     */
    private static int getXPosition4Twist(double dPhase, double dMultValue, int height, int xPosition, int yPosition) {
        double PI = 3.1415926535897932384626433832799; // 此值越大，扭曲程度越大
        double dx = (double) (PI * yPosition) / height + dPhase;
        double dy = Math.sin(dx);
        return xPosition + (int) (dy * dMultValue);
    }

}
