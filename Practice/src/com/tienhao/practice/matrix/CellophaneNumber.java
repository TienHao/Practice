package com.tienhao.practice.matrix;

import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CellophaneNumber {

	public static void main(String[] args) {
		Set<String> validateSet = new HashSet<String>();
		Set<String> reverseSet = new HashSet<String>();
		Map<Integer, String> numberMap = new HashMap<Integer, String>();
		numberMap.put(119, "0");
		numberMap.put(36, "1a");
		numberMap.put(18, "1b");
		numberMap.put(93, "2");
		numberMap.put(109, "3a");
		numberMap.put(91, "3b");
		numberMap.put(46, "4a");
		numberMap.put(58, "4b");
		numberMap.put(107, "5");
		numberMap.put(122, "6a");
		numberMap.put(123, "6b");
		numberMap.put(37, "7a");
		numberMap.put(39, "7b");
		numberMap.put(82, "7c");
		numberMap.put(114, "7d");
		numberMap.put(127, "8");
		numberMap.put(47, "9a");
		numberMap.put(111, "9b");

		int[][] fullMatrix = { // ¬õrºñgÂÅb¶Ày¬v¬õm«Cc
				{ 0, 1, 1, 0, 0, 1 }, // ¬õR
				{ 1, 0, 1, 0, 1, 0 }, // ºñG
				{ 1, 1, 0, 1, 0, 0 }, // ÂÅB
				{ 1, 1, 1, 0, 1, 1 }, // ¶ÀY
				{ 1, 1, 1, 1, 0, 1 }, // ¬v¬õM
				{ 1, 1, 1, 1, 1, 0 }// «CC
		};
		// int[][] celleophaneMatrix = { //¬õºñÂÅ¶À 8 56
		// { 0, 1, 1, 0 },
		// { 1, 0, 1, 0 },
		// { 1, 1, 0, 1 },
		// { 1, 1, 1, 0 } };

		// int[][] celleophaneMatrix = { // ¬õÂÅºñ 12
		// { 0, 1, 1 },
		// { 1, 0, 1 },
		// { 1, 1, 0 } };

		// int[][] celleophaneMatrix = { // ¬õ(ºñ)ÂÅ¶À 110 354
		// { 0, 1, 1, 0 },
		// { 1, 1, 0, 1 },
		// { 1, 1, 1, 0 } };

		// int[][] celleophaneMatrix = { // ¬õºñ(ÂÅ)¶À 46
		// { 0, 1, 1, 0 },
		// { 1, 0, 1, 0 },
		// { 1, 1, 1, 0 } };

		// int[][] celleophaneMatrix = { // ¬õ'ºñ'ÂÅ¶À 16
		// { 0, 1, 0 },
		// { 1, 1, 0 },
		// { 1, 0, 1 },
		// { 1, 1, 0 } };

		// int[][] celleophaneMatrix = { //¬õºñÂÅ¶À¬v¬õ 4
		// { 0, 1, 1, 0, 0 },
		// { 1, 0, 1, 0, 1 },
		// { 1, 1, 0, 1, 0 },
		// { 1, 1, 1, 0, 1 },
		// { 1, 1, 1, 1, 0 }
		// };

		// int[][] celleophaneMatrix = { //¬õÂÅ¶À?¬v¬õ?
		// { 0, 1, 0, 0 },
		// { 1, 0, 1, 0 },
		// { 1, 1, 0, 0 },
		// { 1, 1, 0, 0 }
		// };
		Map<String, Integer> indexMap = new HashMap<String, Integer>();
		indexMap.put("R", 0);
		indexMap.put("G", 1);
		indexMap.put("B", 2);
		indexMap.put("Y", 3);
		indexMap.put("M", 4);
		indexMap.put("C", 5);

		indexMap.put("r", 0);
		indexMap.put("g", 1);
		indexMap.put("b", 2);
		indexMap.put("y", 3);
		indexMap.put("m", 4);
		indexMap.put("c", 5);

		Map<String, Color> colorMap = new HashMap<String, Color>();
		colorMap.put("R", new Color(255,75,75));
		colorMap.put("G", new Color(195,255,0 ));
		colorMap.put("B", new Color(0,195,255));
		colorMap.put("Y", new Color(255,255,0));
		colorMap.put("M", Color.MAGENTA);
		colorMap.put("C", Color.CYAN);

		colorMap.put("r", new Color(255,75,75));
		colorMap.put("g", new Color(195,255,0 ));
		colorMap.put("b", new Color(0,195,255));
		colorMap.put("y", new Color(255,255,0));
		colorMap.put("m", Color.MAGENTA);
		colorMap.put("c", Color.CYAN);
  
		String ink = "rgbym";
		String celleophane = "RGBY";
		int leastColor = 4;
		Color[] colorArray = new Color[ink.length()];
		for (int i = 0; i < ink.length(); i++) {
			colorArray[i] = colorMap.get(ink.substring(i, i + 1));
		}

		int[][] celleophaneMatrix = new int[celleophane.length()][ink.length()];
		for (int i = 0; i < celleophane.length(); i++) {
			for (int j = 0; j < ink.length(); j++) {
				celleophaneMatrix[i][j] = fullMatrix[indexMap.get(celleophane.substring(i, i + 1))][indexMap
						.get(ink.substring(j, j + 1))];
			}
		}

		int colorNum = ink.length();
		int celleophangeNum = celleophane.length();
		for (int no1 = 0; no1 < colorNum; no1++) {
			for (int no2 = 0; no2 < colorNum; no2++) {
				for (int no3 = 0; no3 < colorNum; no3++) {
					for (int no4 = 0; no4 < colorNum; no4++) {
						for (int no5 = 0; no5 < colorNum; no5++) {
							for (int no6 = 0; no6 < colorNum; no6++) {
								for (int no7 = 0; no7 < colorNum; no7++) {
									// ÃC®ÆÁ`¼Æ
									HashSet<Integer> colorSet = new HashSet<Integer>();
									colorSet.add(no1);
									colorSet.add(no2);
									colorSet.add(no3);
									colorSet.add(no4);
									colorSet.add(no5);
									colorSet.add(no6);
									colorSet.add(no7);
									if (colorSet.size() < leastColor) {
										break;
									}

									int[][] testMatrix = new int[colorNum][7];
									testMatrix[no1][0] = 1;
									testMatrix[no2][1] = 1;
									testMatrix[no3][2] = 1;
									testMatrix[no4][3] = 1;
									testMatrix[no5][4] = 1;
									testMatrix[no6][5] = 1;
									testMatrix[no7][6] = 1;

									int[][] resultMatrix = new int[celleophangeNum][7];

									// celleophaneMatrix*testMatrix=resultMatrix
									for (int i = 0; i < celleophangeNum; i++) {
										for (int k = 0; k < colorNum; k++) {
											if (celleophaneMatrix[i][k] != 0) {
												for (int j = 0; j < 7; j++) {
													resultMatrix[i][j] += celleophaneMatrix[i][k] * testMatrix[k][j];
												}
											}
										}
									}

									boolean matchAll = true;
									String numbers = "";
									for (int i = 0; i < celleophangeNum; i++) {
										boolean match = false;
										int value = 0;
										for (int j = 0; j < 7; j++) {
											value = value + (int) (resultMatrix[i][j] * Math.pow(2, j));
										}
										if (value == 119 || value == 36 || value == 18 || value == 93 || value == 109
												|| value == 91 || value == 46 || value == 58 || value == 107
												|| value == 122 || value == 123 || value == 37 || value == 39
												|| value == 82 || value == 114 || value == 127 || value == 47
												|| value == 111) {
											numbers = numbers + numberMap.get(value) + " ";
											match = true;
										}
										if (match == false) {
											matchAll = false;
											break;
										}

									}
									if (matchAll) {
										if (!reverseSet.contains("" + no1 + no2 + no3 + no4 + no5 + no6 + no7)) {

											reverseSet.add("" + no7 + no6 + no5 + no4 + no3 + no2 + no1);
											int[] lineColor = { no1, no2, no3, no4, no5, no6, no7 };
											try {
												NumberGraphic.print(lineColor, colorArray, numbers);
											} catch (IOException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}
										} else {
										}
										validateSet.add("" + no1 + no2 + no3 + no4 + no5 + no6 + no7);
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(validateSet.size());
		for (String validate : validateSet) {
			System.out.println(validate);
			reverseSet.remove(validate);
		}
//
//		for (String reverse : reverseSet) {
//			String validate = "";
//			for (int i = 0; i < 7; i++) {
//				validate = reverse.substring(i, i + 1) + validate;
//			}
//			validateSet.remove(validate);
//			
//		}
//		System.out.println("kind:"+reverseSet.size());
//		System.out.println("matched:"+validateSet.size());
//		for (String colorSet : validateSet) {
//			System.out.println(colorSet);
//		}
		
		
		System.out.println("unmatched:"+reverseSet.size());
		for (String reverse : reverseSet) {
			System.out.println(reverse);
		}
		
	}

}
