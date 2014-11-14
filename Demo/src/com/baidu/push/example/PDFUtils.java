package com.baidu.push.example;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
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

	public static void createPDFByItext(Activity activity, CheckItem[] ci,
			BasicInfo basicInfo) throws Exception {
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

			// 设置字体大小
			Font fontCN_blue = new Font(bfCN, 12, Font.NORMAL, BaseColor.BLUE);
			Font fontCN_black = new Font(bfCN, 12, Font.NORMAL, BaseColor.BLACK);
			// document.add(new
			// Paragraph("使用STSongStd-Light字体,注意才可以输出中文。终于搞定了。天那。", fontCN));

			// ByteArrayOutputStream stream = new ByteArrayOutputStream();
			// Bitmap bitmap = BitmapFactory.decodeResource(activity
			// .getBaseContext().getResources(), R.drawable.ic_launcher);
			// bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
			// Image myImg = Image.getInstance(stream.toByteArray());
			// myImg.setAlignment(Image.MIDDLE);

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
			createHeader(activity, document, fontCN_blue, fontCN_black);

			createBasicInfo(activity, document, fontCN_blue, fontCN_black,
					basicInfo);

			CheckItemCategoryForPDF[] checkItemCategoryForPDF = CheckItemCategoryForPDF
					.CreateCheckItemCategoryForPDF();
			createCategory0(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[0], ci);
			createCategory1(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[1], ci);
			createCategory2(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[2], ci);
			createCategory3(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[3], ci);
			createCategory4(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[4], ci);
			createCategory5(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[5], ci);
			createCategory6(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[6], ci);
			createCategory7(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[7], ci);
			createCategory8(activity, document, fontCN_blue, fontCN_black,
					checkItemCategoryForPDF[8], ci);

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

	public static Image createCategoryPicture(Activity activity, int id) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Bitmap bitmap = BitmapFactory.decodeResource(activity.getBaseContext()
				.getResources(), id);
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		Image myImg = null;
		try {
			myImg = Image.getInstance(stream.toByteArray());
			myImg.setAlignment(Image.MIDDLE);
		} catch (BadElementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		float height = myImg.getHeight() * 430 / myImg.getWidth();
		myImg.scaleAbsoluteWidth(430);
		myImg.scaleAbsoluteHeight(height);
		return myImg;
	}

	public static void createHeader(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black) throws MalformedURLException,
			IOException, DocumentException, JSONException {
		document.add(createCategoryPicture(activity, R.drawable.top_border));

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Bitmap bitmap = BitmapFactory.decodeResource(activity.getBaseContext()
				.getResources(), R.drawable.logo);
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		Image myImg = null;
		myImg = Image.getInstance(stream.toByteArray());
		myImg.setAlignment(Image.ALIGN_LEFT);
		float height = myImg.getHeight() * 100 / myImg.getWidth();
		myImg.scaleAbsoluteWidth(100);
		myImg.scaleAbsoluteHeight(height);
		document.add(myImg);

		BaseFont bfCN = BaseFont.createFont("STSongStd-Light",
				"UniGB-UCS2-H", false);
		Font font = new Font(bfCN, 36, Font.NORMAL, BaseColor.BLACK);
		
		Paragraph paragraph = new Paragraph("DCC车辆检测报告", font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日");     
		 Date   curDate   =   new   Date(System.currentTimeMillis());//获取当前时间     
		String   str   =   formatter.format(curDate);  
		
		font.setSize(20);
	    paragraph = new Paragraph("报告编号：" + Orders.currentOrderJsonObject.getString("订单号：") + "  检测日期：" + str, font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		
		document.add(createCategoryPicture(activity, R.drawable.border));
		
		font.setSize(20);
		font.setColor(BaseColor.BLUE);
	    paragraph = new Paragraph("车辆照片展示", font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		document.add(Chunk.NEWLINE);
		

	}

	public static void createBasicInfo(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black, BasicInfo basicInfo) {
		try {
			Log.e("", "document width = " + document.getPageSize().getWidth());
			document.add(createCategoryPicture(activity,
					R.drawable.che_liang_ji_ben_xin_xi));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < basicInfo.basicInfo.length; i++) {
			try {
				document.add(new Paragraph("                   "
						+ basicInfo.basicInfo[i] + " "
						+ basicInfo.content[i].getText().toString(),
						fontCN_black));
				document.add(Chunk.NEWLINE);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// 车辆交易信息
	public static void createCategory0(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {

		try {
			document.add(createCategoryPicture(activity,
					R.drawable.che_liang_jiao_yi_xin_xi_jian_cha));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
	public static void createCategory1(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {

		try {
			document.add(createCategoryPicture(activity,
					R.drawable.che_liang_wai_guan_jian_cha));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
			table.setTotalWidth(400);
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 发动机检查
	public static void createCategory2(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {

		try {
			document.add(createCategoryPicture(activity,
					R.drawable.fa_dong_ji_jian_cha));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfPTable table = new PdfPTable(5);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("无", fontCN_blue));
		table.addCell(new Paragraph("轻微", fontCN_blue));
		table.addCell(new Paragraph("严重", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length; i++) {
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));

			if (ci[checkItemCategoryForPDF.itemMapping[i]].dropDownListResult[0] == 0) {
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
				table.addCell(new Paragraph());
			} else if (ci[checkItemCategoryForPDF.itemMapping[i]].dropDownListResult[0] == 1) {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else if (ci[checkItemCategoryForPDF.itemMapping[i]].dropDownListResult[0] == 2) {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			table.setTotalWidth(400);
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 功能性检查
	public static void createCategory3(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {

		try {
			document.add(createCategoryPicture(activity,
					R.drawable.gong_neng_xing_jian_cha));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfPTable table = new PdfPTable(6);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("类别", fontCN_blue));
		table.addCell(new Paragraph("零部件名称", fontCN_blue));
		table.addCell(new Paragraph("正常", fontCN_blue));
		table.addCell(new Paragraph("异常", fontCN_blue));
		table.addCell(new Paragraph("备注", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length; i++) {
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph());
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));

			if (ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0) {
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
			table.setTotalWidth(400);
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 驾驶舱检查
	public static void createCategory4(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {

		try {
			document.add(createCategoryPicture(activity,
					R.drawable.jia_shi_cang_jian_cha));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length; i++) {
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));

			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));
			// table.addCell(new Paragraph());

			if (ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0) {
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			table.setTotalWidth(400);
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 地盘检查
	public static void createCategory5(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		try {
			document.add(createCategoryPicture(activity,
					R.drawable.di_pan_jian_cha));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length; i++) {
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));

			if (ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0) {
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			table.setTotalWidth(400);
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 事故车判定
	public static void createCategory6(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		try {
			document.add(createCategoryPicture(activity,
					R.drawable.shi_gu_che_pan_ding));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
			table.setTotalWidth(400);
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 启动测试
	public static void createCategory7(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {

		try {
			document.add(createCategoryPicture(activity,
					R.drawable.qi_dong_ce_shi));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length; i++) {
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));

			if (ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0) {
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			table.setTotalWidth(400);
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 路试测试
	public static void createCategory8(Activity activity, Document document,
			Font fontCN_blue, Font fontCN_black,
			CheckItemCategoryForPDF checkItemCategoryForPDF, CheckItem[] ci) {
		try {
			document.add(createCategoryPicture(activity,
					R.drawable.lu_shi_ce_shi));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PdfPTable table = new PdfPTable(4);
		table.addCell(new Paragraph("序号", fontCN_blue));
		table.addCell(new Paragraph("检查项目", fontCN_blue));
		table.addCell(new Paragraph("是", fontCN_blue));
		table.addCell(new Paragraph("否", fontCN_blue));
		table.completeRow();
		for (int i = 0; i < checkItemCategoryForPDF.itemMapping.length; i++) {
			table.addCell(new Paragraph(String.valueOf(i), fontCN_black));
			table.addCell(new Paragraph(
					ci[checkItemCategoryForPDF.itemMapping[i]].title,
					fontCN_black));

			if (ci[checkItemCategoryForPDF.itemMapping[i]].repairResult == 0) {
				table.addCell(new Paragraph("是", fontCN_black));
				table.addCell(new Paragraph());
			} else {
				table.addCell(new Paragraph());
				table.addCell(new Paragraph("是", fontCN_black));
			}
			table.completeRow();
		}
		try {
			table.setTotalWidth(400);
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
