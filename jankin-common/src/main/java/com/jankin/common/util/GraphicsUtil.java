package com.jankin.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图像生成工具
 *
 * @author jankin
 * @date 2018-07-08
 */
public class GraphicsUtil {
    public static void main(String[] args) throws IOException {
        //绘制探店分享图
        GraphicsUtil.graphicsArticleSharePic();
    }

    /**
     * 绘制探店文章分享图片
     */
    static void graphicsArticleSharePic() throws IOException {
        int width = 600;
        int height = 910;
        //设置探店文章圆形切图直径
        int diameter=248;
        //设置一个临时Y坐标，用于记录计算关健节点的纵坐标
        int tempY;
        String path="C:\\Users\\jankin\\Pictures\\";
        String articlePicPath=path+"artPic.jpg";
        String qrCodeFramePath=path+"qrCodeFrame.png";
        String qrCodePath=path+"qrCode.png";

        //定义一个图形缓冲区
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //在该图形缓冲区设配置一个2D画笔
        Graphics2D graphics2D = bufferedImage.createGraphics();

        //绘制透明背景
        bufferedImage = graphics2D.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        graphics2D.dispose();
        graphics2D = bufferedImage.createGraphics();

        //绘制白灰色 圆角矩形
        graphics2D.setColor(new Color(243,243,243));
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, diameter/2-10, width, height-diameter/2+10, 30, 30);
        graphics2D.fill(roundedRectangle);

        //绘制探店图片
        BufferedImage articlePicBufImg=graphicsArticlePic(diameter,articlePicPath);
        graphics2D.drawImage(articlePicBufImg,(width-diameter)/2,0,diameter,diameter,null);

        //绘制，我在优惠宝看到了一遍文章
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font(graphics2D.getFont().getName(),Font.BOLD,30));
        tempY=diameter+47+30;
        graphics2D.drawString("我在优惠宝看到了一篇文章",110,tempY);

        //绘制， 大家也来看看
        graphics2D.setFont(new Font(graphics2D.getFont().getName(),Font.BOLD,30));
        tempY=tempY+138+30;
        graphics2D.drawString("大家也来看看～",200,tempY);

        //将二维码框模型图片绘制进入指定区域
        BufferedImage qrCodeFrame=ImageIO.read(new File(qrCodeFramePath));
        tempY=tempY+28;
        int qrCodeWidthAndHeight=290;
        graphics2D.drawImage(qrCodeFrame,160,tempY,qrCodeWidthAndHeight,qrCodeWidthAndHeight,null);

        //绘制二维码
        BufferedImage qrCodeBufImg=ImageIO.read(new File(qrCodePath));
        graphics2D.drawImage(qrCodeBufImg,170,tempY+10,qrCodeWidthAndHeight-25,qrCodeWidthAndHeight-25,null);

        //绘制，长按扫码看文章
        graphics2D.setColor(Color.GRAY);
        graphics2D.setFont(new Font(graphics2D.getFont().getName(),Font.PLAIN,23));
        tempY=tempY+qrCodeWidthAndHeight+50;
        graphics2D.drawString("长按扫码看文章",215,tempY);

        graphics2D.dispose();
        File file = new File(path+"1.png");
        if (!file.exists()) {
            boolean createNewFile = file.createNewFile();
            System.out.println("createNewFile:" + createNewFile);
        }
        ImageIO.write(bufferedImage, "png", file);
    }

    /**
     * 截取探店图片为圆形图
     */
    static BufferedImage graphicsArticlePic(int diameter,String path) throws IOException {
        //获取探店图片
        BufferedImage artPicBufImg=ImageIO.read(new File(path));

        //设置一个透明底的图片
        BufferedImage bottomBufImg = new BufferedImage(diameter, diameter, BufferedImage.TYPE_4BYTE_ABGR);
        //在该图形缓冲区设配置一个2D画笔
        Graphics2D graphics = bottomBufImg.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //将图片的切刀，设置为圆形刀片
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, diameter, diameter);
        //预准备图片切刀
        graphics.setClip(shape);
        //将切得的圆形探店图片，绘制在透明底图上
        graphics.drawImage(artPicBufImg, 0, 0, diameter , diameter, null);
        graphics.dispose();

       return bottomBufImg;
    }





}
