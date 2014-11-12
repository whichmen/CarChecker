package com.baidu.push.example;

import android.nfc.NfcAdapter.CreateNdefMessageCallback;

public class CheckItemCategoryForPDF {
	public String categoryName = null;
	public int[] itemMapping = null;
	public int totalScore = 0;

	public CheckItemCategoryForPDF(String categoryName, int[] itemMapping,
			int totalScore) {
		this.categoryName = categoryName;
		this.itemMapping = itemMapping;
		this.totalScore = totalScore;
	}

	public static CheckItemCategoryForPDF[] CreateCheckItemCategoryForPDF() {
		CheckItemCategoryForPDF[] checkItemCategoryForPDFArray = new CheckItemCategoryForPDF[9];

		checkItemCategoryForPDFArray[0] = new CheckItemCategoryForPDF("车辆交易信息检查",
				new int[] {0, 1,2,3,4,5,6,7 }, 0);
		checkItemCategoryForPDFArray[1] = new CheckItemCategoryForPDF("车身外观检查",
				new int[] {30,31,35,42,39,32,34,41,40,36,37,33,29,38,20,22,26,24,19,21,25,23,43,44,52,53,45,54,51,50,46,55 }, 20);
		checkItemCategoryForPDFArray[2] = new CheckItemCategoryForPDF("发动机检查",
				new int[] {58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73 }, 20);
		checkItemCategoryForPDFArray[3] = new CheckItemCategoryForPDF("功能性检查",
				new int[] {56,57,74,90,102,49,95,103,101,100,75,76,77,78,79,80,81,82,83}, 0);
		checkItemCategoryForPDFArray[4] = new CheckItemCategoryForPDF("驾驶舱检查",
				new int[] {84,86,92,85,94,88,99,97,96,87,48,93,98,89,47,91 }, 10);
		checkItemCategoryForPDFArray[5] = new CheckItemCategoryForPDF("底盘检查",
				new int[] { 8,9,10,11,12,13,14,15,16,17,18,27,28 }, 15);
		checkItemCategoryForPDFArray[6] = new CheckItemCategoryForPDF("事故车判定",
				new int[] { 104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120 }, 0);
		checkItemCategoryForPDFArray[7] = new CheckItemCategoryForPDF("启动测试",
				new int[] { 121,122,123,124,125,126,127,128,129,130 }, 20);
		checkItemCategoryForPDFArray[8] = new CheckItemCategoryForPDF("路试测试",
				new int[] { 131,132,133,134,135,136,137,138,139}, 15);
		return checkItemCategoryForPDFArray;
	}

}
