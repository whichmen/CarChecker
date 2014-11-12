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

		checkItemCategoryForPDFArray[0] = new CheckItemCategoryForPDF("爸爸",
				new int[] { 1,2 }, 30);
		checkItemCategoryForPDFArray[1] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		checkItemCategoryForPDFArray[2] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		checkItemCategoryForPDFArray[3] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		checkItemCategoryForPDFArray[4] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		checkItemCategoryForPDFArray[5] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		checkItemCategoryForPDFArray[6] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		checkItemCategoryForPDFArray[7] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		checkItemCategoryForPDFArray[8] = new CheckItemCategoryForPDF("1",
				new int[] { 1, 2 }, 3);
		return checkItemCategoryForPDFArray;
	}

}
