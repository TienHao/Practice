package com.tienhao.practice.matrix;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NumberGraphic {

	static private Graphics2D g;

	static private int[] x = new int[6];
	static private int[] y = new int[6];

	static private final int[] horizontalX = { -30, 30, 40, 30, -30, -40 };
	static private final int[] horizontalY = { -10, -10, 0, 10, 10, 0 };

	static private final int[] verticalX = { -10, -10, 0, 10, 10, 0 };
	static private final int[] verticalY = { -30, 30, 40, 30, -30, -40 };

	static private void setHorizontalXY(int startX, int startY) {
		for (int i = 0; i < 6; i++) {
			x[i] = startX + horizontalX[i];
			y[i] = startY + horizontalY[i];
		}
	}

	static private void setVerticalXY(int startX, int startY) {
		for (int i = 0; i < 6; i++) {
			x[i] = startX + verticalX[i];
			y[i] = startY + verticalY[i];
		}
	}

	static private void setHorizontalLine(int startX, int startY, Color color) {
		setHorizontalXY(startX, startY);
		drawLine(color);
	}

	static private void setVerticalLine(int startX, int startY, Color color) {
		setVerticalXY(startX, startY);
		drawLine(color);
	}

	static private void drawLine(Color color) {
		Polygon poly1 = new Polygon(x, y, 6);
		g.setColor(color);
		g.drawPolygon(poly1);
		g.fillPolygon(poly1);
	}

	static void print(int[] lineColor, Color[] colorArray, String fileName) throws IOException {
		BufferedImage bi = new BufferedImage(110, 200, BufferedImage.TYPE_INT_RGB);
		g = bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 110, 200);

		setHorizontalLine(55, 10, colorArray[lineColor[0]]);
		setVerticalLine(10, 55, colorArray[lineColor[1]]);
		setVerticalLine(100, 55, colorArray[lineColor[2]]);
		setHorizontalLine(55, 100, colorArray[lineColor[3]]);
		setVerticalLine(10, 145, colorArray[lineColor[4]]);
		setVerticalLine(100, 145, colorArray[lineColor[5]]);
		setHorizontalLine(55, 190, colorArray[lineColor[6]]);

		g.dispose();

		File file = new File("D://Graphics/" + fileName + ".png");
		ImageIO.write(bi, "png", file);

	}

	public static void main(String[] args) throws IOException {
//		Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };
//		int[] lineColor = { 0, 2, 3, 1, 0, 2, 1 };
//		print(lineColor, color, "0231021");
		printAll();
	}
	
	private static void printAll() throws IOException {
		BufferedImage bi = new BufferedImage(1000, 1400, BufferedImage.TYPE_INT_RGB);
		g = bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 1400);
		
		g.setFont(new Font(null,Font.BOLD,9));
		
		int x=25;
		int y=25;
		int n=0;
		int anchorX =x;
		int anchorY =y;
		for(int i=0;i<16;i++){	
			for(int j=0;j<16;j++){
				for(int k=0;k<16;k++){
					if(k==0){
						drawTestColor((255-17*j)+"",0,0,0,x+3,y-10);
					}
					if(j==0){
						drawTestColor((255-17*i)+"",0,0,0,x-17,y);
					}
					
					drawTestColor("¡½¡½",255-17*i,255-17*j,255-17*k,x,y);
					drawTestColor(255-17*k+"",255,255,255,x+3,y);

					y=y+10;
					n=n+1;
					if(n%16==0){
						x=x+30;
						y=anchorY;
						if(n%256==0){
							x=x+15;
						}
						if(n%512==0){
							x=anchorX;
							y=y+173;
							anchorY = y;
						}
					}
				}
			}
		}	
		
		g.dispose();

		File file = new File("D://Graphics/test.png");
		ImageIO.write(bi, "png", file);
	}
	
	private static void drawTestColor(String str ,int R,int G,int B, int X,int Y){
		g.setColor(new Color(R,G,B));
		g.drawString(str, X, Y);
	}
}
