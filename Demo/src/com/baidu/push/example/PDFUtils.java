package com.baidu.push.example;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFUtils {
	/**
	 * @param args
	 */
	// public static void main(String[] args) throws Exception {
	// String pdfFilePath = "f:/itext-demo.pdf";
	// createPDFByItext(pdfFilePath);
	// }

	public static void createPDFByItext() throws Exception {
//		String pdfFilePath = "/sdcard/aaa5.pdf";
		
		String pdfFilePath = Utils.DIR + "/" + Orders.currentOrderJsonObject.getString("订单号：") + ".pdf";
		// 第一步： Create a Document
		Document document = new Document(PageSize.A4);
		try {
			if (pdfFilePath == null || pdfFilePath.trim().length() <= 0) {
				return;
			}
			// 第二 步： Get a PdfWriter instance.
			PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));
			// 第三步：Open the Document.
			document.open();

			// 添加Meta信息
			document.addTitle("iText生成PDF入门之Hello World");
			document.addAuthor("360sdn");
			document.addCreator("360sdn.com");
			document.addSubject("itext");
			document.addCreationDate();
			document.addKeywords("开源技术,企业架构,Java,SSH");
			// 添加Header信息
			document.addHeader("web", "http://www.360sdn.com");

			// 添加 中文信息
			BaseFont bfCN = BaseFont.createFont("STSongStd-Light",
					"UniGB-UCS2-H", false);
			
			// 第四步：添加内容
			// 添加 Paragraph
			document.add(new Paragraph("Hello ssss  World."));
			document.add(Chunk.NEWLINE);
			
			// 设置字体大小
			Font fontCN = new Font(bfCN, 12, Font.NORMAL, BaseColor.RED);
			document.add(new Paragraph("使用STSongStd-Light字体,注意才可以输出中文。终于搞定了。天那。", fontCN));
		} catch (Exception ex) {
			ex.printStackTrace();
			Log.e("", ex.toString());
		} finally {
			// 第五步：Close the Document.
			if (document != null) {
				document.close();
			}
			document = null;
		}

	}
	
	public static void openPdf(Context context, String id){
		String path = Utils.DIR + "/" + id + ".pdf";
		File file = new File(path);
		Intent intent = new Intent("android.intent.action.VIEW");
		intent.addCategory("android.intent.category.DEFAULT");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Uri uri = Uri.fromFile(file);
		intent.setDataAndType(uri, "application/pdf");
		context.startActivity(intent);
	}
}
