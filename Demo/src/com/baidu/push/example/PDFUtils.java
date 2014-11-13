package com.baidu.push.example;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import com.baidu.push.example.R.id;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFUtils {
	/**
	 * @param args
	 */
	// public static void main(String[] args) throws Exception {
	// String pdfFilePath = "f:/itext-demo.pdf";
	// createPDFByItext(pdfFilePath);
	// }

	public static void createPDFByItext(Activity activity, CheckItem[] ci)
			throws Exception {
		// String pdfFilePath = "/sdcard/aaa5.pdf";

		// for(int i = 0; i < 140; i++)
		// {
		// JSONObject js =
		// Orders.currentOrderJsonObject.getJSONObject(activity.ci[i].title);
		// js.get
		//
		// }
		String pdfFilePath = Utils.DIR + "/"
				+ Orders.currentOrderJsonObject.getString("订单号：") + ".pdf";
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
			Font fontCN_blue = new Font(bfCN, 12, Font.NORMAL, BaseColor.BLUE);
			Font fontCN_black = new Font(bfCN, 12, Font.NORMAL, BaseColor.BLACK);
			// document.add(new
			// Paragraph("使用STSongStd-Light字体,注意才可以输出中文。终于搞定了。天那。", fontCN));

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			Bitmap bitmap = BitmapFactory.decodeResource(activity
					.getBaseContext().getResources(), R.drawable.ic_launcher);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
			Image myImg = Image.getInstance(stream.toByteArray());
			myImg.setAlignment(Image.MIDDLE);

			// PdfPCell pCell = new Pd

			// document.add(myImg);
			// PdfPTable a = new PdfPTable(5);
			// Phrase phrase = new Phrase("你好，同学", fontCN);
			// a.addCell(new Phrase("你好，同学", fontCN));
			//
			// Paragraph paragraph = new Paragraph("我是居中", fontCN);
			// paragraph.setAlignment(Paragraph.ALIGN_MIDDLE);
			// a.addCell(paragraph);
			//
			// a.completeRow();
			// a.addCell("1122");
			// a.completeRow();
			// a.addCell("你好");
			//
			// a.addCell(myImg);
			// a.completeRow();
			// document.add(a);

			// Table(5);
			// Table table = new Table(5, 5);
			// Table(Properties attributes);
			// PdfPTable p = new PdfPTable(5);
			// p.
			CheckItemCategoryForPDF[] checkItemCategoryForPDF = CheckItemCategoryForPDF.CreateCheckItemCategoryForPDF();
			createCategory0(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[0], ci);
			createCategory1(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[1], ci);
			createCategory2(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[2], ci);
			createCategory3(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[3], ci);
			createCategory4(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[4], ci);
			createCategory5(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[5], ci);
			createCategory6(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[6], ci);
			createCategory7(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[7], ci);
			createCategory8(document, fontCN_blue, fontCN_black, checkItemCategoryForPDF[8], ci);
			
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

	// 车辆交易信息
	public static void createCategory0(Document document, Font fontCN_blue,
			Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF,
			CheckItem[] ci) {
		PdfPTable table = new PdfPTable(2);
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("判别", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length; i++) {
			table.addCell(new Paragraph(String.valueOf(i) + "   "
					+ ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));
			if (ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0)
				table.addCell(new Paragraph("是", fontCN_black));
			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 车身外观检查
	public static void createCategory1(Document document, Font fontCN_blue,
			Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF,
			CheckItem[] ci) {
		PdfPTable table = new PdfPTable(6);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("外观部位", fontCN_blue));
		table.addCell(new Paragraph("缺陷描述", fontCN_blue));
		table.addCell(new Paragraph("代码", fontCN_blue));
		table.addCell(new Paragraph("外观部位", fontCN_blue));
		table.addCell(new Paragraph("缺陷描述", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length / 2; i++) {
			table.addCell(String.valueOf(i + 1));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));
			table.addCell(new Paragraph());

			table.addCell(String.valueOf(i
					+ checkItemCategoryForPDF.itemMapping.length / 2 + 1));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i
							+ checkItemCategoryForPDF.itemMapping.length / 2]].title,
					fontCN_black));
			table.addCell(new Paragraph());

			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 发动机检查
	public static void createCategory2(Document document, Font fontCN_blue, Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci){
		PdfPTable table = new PdfPTable(5);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("无", fontCN_blue));
		table.addCell(new Paragraph("轻微", fontCN_blue));
		table.addCell(new Paragraph("严重", fontCN_blue));
		table.completeRow();
		for(int i= 0; i<checkItemCategoryForPDF.itemMapping.length; i++){
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph(ci[checkItemCategoryForPDF.itemMapping[i]].title, fontCN_black));
			
			if(ci[checkItemCategoryForPDF.itemMapping[i]].dropDownListResult[0] == 0){
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
				table.addCell(new Paragraph());
			} else if(ci[checkItemCategoryForPDF.itemMapping[i]].dropDownListResult[0] == 1){
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else if(ci[checkItemCategoryForPDF.itemMapping[i]].dropDownListResult[0] == 2){
				table.addCell(new Paragraph());
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	// 功能性检查
	public static void createCategory3(Document document, Font fontCN_blue, Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {

		PdfPTable table = new PdfPTable(6);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("类别", fontCN_blue));
		table.addCell(new Paragraph("零部件名称", fontCN_blue));
		table.addCell(new Paragraph("正常", fontCN_blue));
		table.addCell(new Paragraph("异常", fontCN_blue));
		table.addCell(new Paragraph("备注", fontCN_blue));
		table.completeRow();
		for(int i= 0; i<checkItemCategoryForPDF.itemMapping.length; i++){
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph());
			table.addCell(new Paragraph(ci[checkItemCategoryForPDF.itemMapping[i]].title, fontCN_black));
			
			if(ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0){
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.addCell(new Paragraph());
			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 驾驶舱检查
	public static void createCategory4(Document document, Font fontCN_blue, Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for(int i= 0; i<checkItemCategoryForPDF.itemMapping.length; i++){
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph());
			table.addCell(new Paragraph(ci[checkItemCategoryForPDF.itemMapping[i]].title, fontCN_black));
			
			if(ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0){
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 地盘检查
	public static void createCategory5(Document document, Font fontCN_blue, Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for(int i= 0; i<checkItemCategoryForPDF.itemMapping.length; i++){
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph());
			table.addCell(new Paragraph(ci[checkItemCategoryForPDF.itemMapping[i]].title, fontCN_black));
			
			if(ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0){
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 事故车判定
	public static void createCategory6(Document document, Font fontCN_blue, Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		PdfPTable table = new PdfPTable(6);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目或车体部位", fontCN_blue));
		table.addCell(new Paragraph("状态描述", fontCN_blue));
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目或车体部位", fontCN_blue));
		table.addCell(new Paragraph("状态描述", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length / 2; i++) {
			table.addCell(String.valueOf(i + 1));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));
			table.addCell(new Paragraph());

			table.addCell(String.valueOf(i
					+ checkItemCategoryForPDF.itemMapping.length / 2 + 1));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i
							+ checkItemCategoryForPDF.itemMapping.length / 2]].title,
					fontCN_black));
			table.addCell(new Paragraph());

			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 启动测试
	public static void createCategory7(Document document, Font fontCN_blue, Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for(int i= 0; i<checkItemCategoryForPDF.itemMapping.length; i++){
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph());
			table.addCell(new Paragraph(ci[checkItemCategoryForPDF.itemMapping[i]].title, fontCN_black));
			
			if(ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0){
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 路试测试
	public static void createCategory8(Document document, Font fontCN_blue, Font fontCN_black, CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for(int i= 0; i<checkItemCategoryForPDF.itemMapping.length; i++){
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph());
			table.addCell(new Paragraph(ci[checkItemCategoryForPDF.itemMapping[i]].title, fontCN_black));
			
			if(ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0){
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void openPdf(Context context, String id) {
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
