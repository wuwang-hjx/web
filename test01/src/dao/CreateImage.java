package dao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateImage {
	public String yzm="";
	
	public BufferedImage getimage() {
		int width = 80;
		int height = 50;
		int strlen = 4;
		String strbuf = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890";
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		Random rd = new Random();
		for (int i = 0; i < strlen; i++) {
			String s= String.valueOf(strbuf.charAt(rd.nextInt(strbuf.length())));
			g.setColor(new Color(rd.nextInt(128),rd.nextInt(192),rd.nextInt(255)));
			//此处设置字体
			g.drawString(s, i*20, 30);
			this.yzm += s;
		}
		g.dispose();
		
		return image;
	}
}
