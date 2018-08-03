package com.tienhao.practice.matrix;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	static private void drawColorNumber(String lineColorStr, Color[] colorArray, int x, int y){
		
		int[] lineColor = {Integer.parseInt(lineColorStr.substring(0, 1)),
				Integer.parseInt(lineColorStr.substring(1, 2)),
				Integer.parseInt(lineColorStr.substring(2, 3)),
				Integer.parseInt(lineColorStr.substring(3, 4)),
				Integer.parseInt(lineColorStr.substring(4, 5)),
				Integer.parseInt(lineColorStr.substring(5, 6)),
				Integer.parseInt(lineColorStr.substring(6, 7)),};
		
		setHorizontalLine(x+55, y+10, colorArray[lineColor[0]]);
		setVerticalLine(x+10, y+55, colorArray[lineColor[1]]);
		setVerticalLine(x+100, y+55, colorArray[lineColor[2]]);
		setHorizontalLine(x+55, y+100, colorArray[lineColor[3]]);
		setVerticalLine(x+10, y+145, colorArray[lineColor[4]]);
		setVerticalLine(x+100, y+145, colorArray[lineColor[5]]);
		setHorizontalLine(x+55, y+190, colorArray[lineColor[6]]);
	}

	static void print(String lineColorStr, Color[] colorArray, String fileName,int reverseCount) throws IOException {
		BufferedImage bi = new BufferedImage(110, 200, BufferedImage.TYPE_INT_RGB);
		g = bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 110, 200);
		drawColorNumber(lineColorStr,colorArray,0,0);
		
		g.dispose();

		File file = new File("D://Graphics/" +reverseCount+File.separator+ fileName + ".png");
		ImageIO.write(bi, "png", file);

	}
	
	private static void printNumbers(String[] lineColor, Color[] colorArray, String fileName,int reverseCount) throws IOException {
		BufferedImage bi = new BufferedImage(110+130*(lineColor.length-1), 200, BufferedImage.TYPE_INT_RGB);
		g = bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,110+130*(lineColor.length-1), 200);
		for(int i=0;i<lineColor.length;i++){			
			drawColorNumber(lineColor[i],colorArray,130*i,0);
		}
		
		g.dispose();

		File file = new File("D://Graphics/" +reverseCount+File.separator+ fileName + ".png");
		ImageIO.write(bi, "png", file);

	}

	
	private static void printListNumbers(String[][] lineColor, Color[] colorArray, String fileName,int reverseCount) throws IOException {
		BufferedImage bi = new BufferedImage(2800, 2000, BufferedImage.TYPE_INT_RGB);
		g = bi.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,2800, 2000);
		int xa=60;
		int ya=20;
		Map<String,Color> color = new HashMap<String,Color>();
		color.put("1", Color.RED);
		color.put("2", Color.GREEN);
		color.put("3", Color.BLUE);
		color.put("4", Color.YELLOW);
		for(int i=0;i<lineColor.length;i++){
			for(int j=0;j<3;j++){
				drawColorNumber(lineColor[i][j],colorArray,xa+130*j,ya);
			}
			drawCelleophoneColor(color.get(lineColor[i][3]),xa-30,ya+100);
			ya = ya + 250;
			if((i+1)%8==0){
				ya = 20;
				xa=xa+470;
			}
		}
		
		g.dispose();

		File file = new File("D://Graphics/" +reverseCount+File.separator+ fileName + ".png");
		ImageIO.write(bi, "png", file);

	}

	private static void drawCelleophoneColor(Color color, int i, int ya) {
		setVerticalLine(i,ya, color);
	}

	public static void main(String[] args) throws IOException {
//		Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };
//		int[] lineColor = { 0, 2, 3, 1, 0, 2, 1 };
//		print(lineColor, color, "0231021");
//		printAll();
//		printNumbers(new String[]{"1012202","0232212","1013010"},new Color[]{ Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW},"test",5);
		printListNumbers(new String[][]{
				{"1012202","0232212","1013010","2"},
				{"0100212","1232202","0103101","1"},
				{"0201121","1323323","0121323","3"},
				{"0103101","1232202","0100212","4"},
				{"1231231","1011202","1232202","3"},
				{"0023323","0203121","1121323","1"},
				{"1121321","3121323","1213020","4"},
				{"0020320","3020323","1123323","1"},
				{"0200121","0230230","1012202","2"},
				{"2122010","0320320","0203121","3"},
				{"0121323","0023020","2022321","4"},
				{"1323323","0023020","1121323","2"},
				
				{"0023323","2122320","2022101","1"},
				{"0020323","1211020","1011202","1"},
				{"0121323","1020323","0201121","2"},
				{"0323323","1020323","2021101","2"},
				{"1211020","0232212","1232202","3"},
				{"0200121","0232212","1232202","3"},
				{"0103101","1123121","0203121","4"},
				{"0103101","0023020","1123121","4"},
				
				{"1121321","2022101","1123323","2"},
				{"0020320","0100212","0203121","1"},
				{"1121321","3121323","2120010","4"},
				{"2122320","3020323","1123323","1"},
				{"0023020","1011202","2022322","3"},
				{"2232212","1211020","3230200","1"},
				{"1011202","1232202","3231211","3"},
				{"2022101","0121323","2122322","2"},
				{"0023323","2021101","0103101","4"},
				{"1231231","3230200","2021101","3"}
				},new Color[]{ new Color(255,75,75), new Color(195,255,0 ), new Color(0,195,255), new Color(255,255,0)},"test",5);
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
