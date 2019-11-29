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
	 * @param b ԴͼƬ��byte[]
	 * @param outPath Ŀ���ļ���·��
	 * @param x ��ԴͼƬ�м�����ʼx��λ��
	 * @param y ��ԴͼƬ�м�����ʼy��λ��
	 * @param cw ��ԴͼƬ�м��ÿ��
	 * @param ch ��ԴͼƬ�м��ø߶�
	 * @param sw Ŀ��ͼƬ�ļ����
	 * @param sh Ŀ��ͼƬ�ļ��߶�
	 * @param bgc Ŀ��ͼƬ����ɫ
	 */
	public static void cutImage(byte[] b, String outPath, int x, int y, int cw, int ch, int sw, int sh, Color bgc){
		InputStream in =  new ByteArrayInputStream(b);
		cutImage(in, outPath, x, y, cw, ch, sw, sh, bgc);
	}
	/**
	 * 
	 * @param in ԴͼƬ��������
	 * @param outPath Ŀ���ļ���·��
	 * @param x ��ԴͼƬ�м�����ʼx��λ��
	 * @param y ��ԴͼƬ�м�����ʼy��λ��
	 * @param cw ��ԴͼƬ�м��ÿ��
	 * @param ch ��ԴͼƬ�м��ø߶�
	 * @param sw Ŀ��ͼƬ�ļ����
	 * @param sh Ŀ��ͼƬ�ļ��߶�
	 * @param bgc Ŀ��ͼƬ����ɫ
	 */
	public static void cutImage(InputStream in, String outPath, int x, int y, int cw, int ch, int sw, int sh, Color bgc){
		//�趨Ĭ�ϱ���ɫΪ��ɫ
		if(bgc == null){
			bgc = Color.white;
		}
		try {
			//���������ж�ȡͼƬ����
			BufferedImage bufImg = ImageIO.read(in);
			//����ͼƬ
			BufferedImage cutImg = bufImg.getSubimage(x, y, cw, ch);
			//�������ź�Ļ���
			BufferedImage scaImg = new BufferedImage(sw, sh,  
                    BufferedImage.TYPE_INT_RGB);
			//����ȱ������ź����ʵ�Ŀ�rw���ߣ�rh��ֵ��
			double scale = (double)cw/ch;
			int rw, rh;
			if(scale>=1){
				rw = sw;
				rh = (int)(rw / scale);
			}else{
				rh = sh;
				rw = (int)(rh * scale);
			}
			//��ȡͼƬ��Ӧ�Ļ���
			Graphics g = scaImg.getGraphics();
			//��䱳��ɫ����������
			g.setColor(bgc);
			g.fillRect(0, 0, sw, sh);
			//�����ú��ͼƬ���ŵ���ʵ�ߴ磬���滭�������Ͼ��е�λ��
			g.drawImage(  
					cutImg.getScaledInstance(rw, rh,  
                            java.awt.Image.SCALE_SMOOTH), (sw-rw)/2, (sh-rh)/2, null);
			//��ͼƬд���ļ�
			ImageIO.write(scaImg, outPath.substring(outPath.indexOf(".")+1), new File(outPath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
