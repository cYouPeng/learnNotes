package com.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class ImgHelper {
	/**
	 * 
	 * @param b 源图片的byte[]
	 * @param outPath 目标文件的路径
	 * @param x 在源图片中剪裁起始x轴位置
	 * @param y 在源图片中剪裁起始y轴位置
	 * @param cw 在源图片中剪裁宽度
	 * @param ch 在源图片中剪裁高度
	 * @param sw 目标图片文件宽度
	 * @param sh 目标图片文件高度
	 * @param bgc 目标图片背景色
	 */
	public static void cutImage(byte[] b, String outPath, int x, int y, int cw, int ch, int sw, int sh, Color bgc){
		InputStream in =  new ByteArrayInputStream(b);
		cutImage(in, outPath, x, y, cw, ch, sw, sh, bgc);
	}
	/**
	 * 
	 * @param in 源图片的输入流
	 * @param outPath 目标文件的路径
	 * @param x 在源图片中剪裁起始x轴位置
	 * @param y 在源图片中剪裁起始y轴位置
	 * @param cw 在源图片中剪裁宽度
	 * @param ch 在源图片中剪裁高度
	 * @param sw 目标图片文件宽度
	 * @param sh 目标图片文件高度
	 * @param bgc 目标图片背景色
	 */
	public static void cutImage(InputStream in, String outPath, int x, int y, int cw, int ch, int sw, int sh, Color bgc){
		//设定默认背景色为白色
		if(bgc == null){
			bgc = Color.white;
		}
		try {
			//从输入流中读取图片对象
			BufferedImage bufImg = ImageIO.read(in);
			//剪裁图片
			BufferedImage cutImg = bufImg.getSubimage(x, y, cw, ch);
			//创建缩放后的画布
			BufferedImage scaImg = new BufferedImage(sw, sh,  
                    BufferedImage.TYPE_INT_RGB);
			//计算等比例缩放后的真实的宽（rw）高（rh）值：
			double scale = (double)cw/ch;
			int rw, rh;
			if(scale>=1){
				rw = sw;
				rh = (int)(rw / scale);
			}else{
				rh = sh;
				rw = (int)(rh * scale);
			}
			//获取图片对应的画布
			Graphics g = scaImg.getGraphics();
			//填充背景色到整个画布
			g.setColor(bgc);
			g.fillRect(0, 0, sw, sh);
			//将剪裁后的图片缩放到真实尺寸，并绘画到画布上居中的位置
			g.drawImage(  
					cutImg.getScaledInstance(rw, rh,  
                            java.awt.Image.SCALE_SMOOTH), (sw-rw)/2, (sh-rh)/2, null);
			//将图片写入文件
			ImageIO.write(scaImg, outPath.substring(outPath.indexOf(".")+1), new File(outPath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
