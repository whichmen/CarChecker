package com.baidu.push.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.MediaColumns;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProcessOrderActivity extends Activity {
	private ListView mDrawerList;
	private String[] mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	TextView current_order_txt = null;
	ListView processed_order_txt = null;
	String[] processed_order_contentStrings = null;
	Button process_order_activity_submit_btn = null;
	Button process_order_activity_preview_btn = null;
	Button process_order_activity_save = null;

	private boolean needSaveCurrentPage = true;

	private RelativeLayout mainLayout;

	private ViewGroup linearLayout[] = new ViewGroup[SourceData_Category.length];

	public static final int MAX_ITEMS = 140;

	// SourceData_1_ChaYanKeJiaoYiCheLiang.length
	// + SourceData_2_CheShenWaiGuan.length
	// + SourceData_3_FaDongJiCang.length
	// + SourceData_4_GongNengXingLingBuJian.length
	// + SourceData_5_JiaShiCangJianCha.length
	// + SourceData_6_DiPan.length
	// + SourceData_7_PanDingShiGuChe.length
	// + SourceData_8_QiDongJianCha.length + SourceData_9_LuShi.length;

	private SourceDataBase[] sourceDataBase = new SourceDataBase[SourceData_Category.length];

	CheckItem[] ci = new CheckItem[MAX_ITEMS];

	BasicInfo basicInfo = null;

	public void initSourceDataBase() {
		sourceDataBase[1] = new SourceData_1_ChaYanKeJiaoYiCheLiang();
		sourceDataBase[2] = new SourceData_2_DiPan();
		sourceDataBase[3] = new SourceData_3_CheShenWaiGuan();
		sourceDataBase[4] = new SourceData_4_FaDongJiCang();
		sourceDataBase[5] = new SourceData_5_JiaShiCangJianCha();
		sourceDataBase[6] = new SourceData_6_PanDingShiGuChe();
		sourceDataBase[7] = new SourceData_7_QiDongJianCha();
		sourceDataBase[8] = new SourceData_8_LuShi();

	}

	public void createCategoryClass(int categoryID, int startItemID,
			SourceDataBase sourceDataBase) {

		String[] demoListTitle = sourceDataBase.getDemoListTitle();
		String[][] demolistName = sourceDataBase.getDemoListName();
		String[][][] demoDropDownListName = sourceDataBase
				.getDemoDropDownListName();
		double[][][] demodropDownListScore = sourceDataBase
				.getDemoDropDownListScore();
		int[][][] hasRepair = sourceDataBase.getHasRepair();
		boolean[] hasEdit = sourceDataBase.getHasEdit();
		boolean[] hasBtn = sourceDataBase.getHasBtn();

		for (int i = 0; i < sourceDataBase.getLength(); i++) {
			ci[startItemID] = new CheckItem(demoListTitle[i], demolistName[i],
					demoDropDownListName[i], demodropDownListScore[i],
					hasRepair[i], hasEdit[i], hasBtn[i]);
			ci[startItemID].setBasicInfoPtr(basicInfo);
			startItemID++;
		}

	}

	public void createCategoryView(int categoryID, int startItemID,
			SourceDataBase sourceDataBase) {
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		linearLayout[categoryID] = (ViewGroup) layoutInflater.inflate(
				R.layout.basic_linear_layout, null);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

		linearLayout[categoryID].setLayoutParams(params);

		for (int i = 0; i < sourceDataBase.getLength(); i++) {
			linearLayout[categoryID].addView(ci[startItemID].createCheckItem(
					this, startItemID));
			startItemID++;
		}
		linearLayout[categoryID].setVisibility(View.INVISIBLE);
		mainLayout.addView(linearLayout[categoryID]);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.process_order_activity);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		initListView();
		initSourceDataBase();

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		process_order_activity_preview_btn = (Button) findViewById(R.id.process_order_activity_preview);

		process_order_activity_preview_btn
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {

						if (!basicInfo.hasKeyInfo()) {
							Toast.makeText(
									ProcessOrderActivity.this
											.getApplicationContext(),
									"请补全关键信息：订单号 姓名 时间", Toast.LENGTH_LONG)
									.show();
							return;
						}

						for (int i = 0; i < 8; i++) {
							if (!fileIsExists(String.valueOf("/sdcard/CarChecker/" + String.valueOf(200 + i) + ".jpg"))) {
								String errorString = String.valueOf("/sdcard/CarChecker/" + String.valueOf(200 + i) + ".jpg");
								Toast.makeText(
										ProcessOrderActivity.this
												.getApplicationContext(),
										"请选择车身８张照片！" + errorString, Toast.LENGTH_LONG)
										.show();
								return;
							}
						}

						try {
							if (Orders.processingBufferedOrderID == -1) {
								if (Orders.currentOrderJsonObject == null)
									Orders.currentOrderJsonObject = new JSONObject();
								saveData(Orders.currentOrderJsonObject);
								getScore(Orders.currentOrderJsonObject);

								try {
									PDFUtils.createPDFByItext(
											ProcessOrderActivity.this, ci,
											basicInfo);

								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								String id = Orders.currentOrderJsonObject
										.getString("订单号：");

								PDFUtils.openPdf(ProcessOrderActivity.this, id);

							} else {
								saveData(Orders.bufferedOrdersJsonArray
										.getJSONObject(Orders.processingBufferedOrderID));
								getScore(Orders.bufferedOrdersJsonArray
										.getJSONObject(Orders.processingBufferedOrderID));

								Orders.finishBufferedOrder(Orders.processingBufferedOrderID);
								Orders.processingBufferedOrderID = -1;
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});

		process_order_activity_submit_btn = (Button) findViewById(R.id.process_order_activity_submit);

		process_order_activity_submit_btn
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						try {
							if (Orders.currentOrderJsonObject != null
									&& Utils.checkPdfCreated(Orders.currentOrderJsonObject
											.getString("订单号："))) {
								needSaveCurrentPage = false;
								Toast.makeText(ProcessOrderActivity.this,
										"pdf already created",
										Toast.LENGTH_LONG).show();
								Orders.finishCurrentOrder();

								ProgressDialog pd = ProgressDialog.show(
										ProcessOrderActivity.this, "正在上传报告",
										"上传中，请稍后……");
								pd.setProgress(0);

								FileUtils.uploadFile("/sdcard/CarChecker/"
										+ basicInfo.getOrderID() + ".pdf", "/"
										+ basicInfo.getOrderID() + "/"
										+ basicInfo.getOrderID() + ".pdf", pd,
										new Callback() {

											@Override
											public void onSuccess() {
												// TODO Auto-generated method
												// stub
												// ci[requestCode].setPictureUploaded();

												Intent intent = new Intent(
														ProcessOrderActivity.this,
														OrdersActivity.class);
												startActivity(intent);
												finish();

											}

											@Override
											public void onFail() {
												// TODO Auto-generated method
												// stub

											}
										});

							} else {
								Toast.makeText(ProcessOrderActivity.this,
										"请先生成检测报告", Toast.LENGTH_LONG).show();
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});

		mainLayout = (RelativeLayout) findViewById(R.id.process_order_activity);
		LayoutInflater layoutInflater = LayoutInflater.from(this);

		// for basic info
		linearLayout[0] = (ViewGroup) layoutInflater.inflate(
				R.layout.basic_linear_layout, null);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

		linearLayout[0].setLayoutParams(params);

		basicInfo = new BasicInfo();
		linearLayout[0].addView(basicInfo.createBasicInfoItem(this));
		linearLayout[0].setVisibility(View.VISIBLE);
		mainLayout.addView(linearLayout[0]);
		setTitle(mPlanetTitles[0]);

		// for check items
		int index = 0;
		//
		for (int i = 1; i < SourceData_Category.length; i++) {
			createCategoryClass(i, index, sourceDataBase[i]);
			index += sourceDataBase[i].getLength();
		}

	}

	public boolean fileIsExists(String path) {
		try {
			File f = new File(path);
			if (!f.exists()) {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public void setPhotoOnClickListener(final CheckItem item,
			final Context activityContext) {

	}

	@Override
	protected void onActivityResult(final int requestCode, int resultCode,
			Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(!(resultCode == Activity.RESULT_OK))
			return;
		
		if (requestCode >= 200) {
			String path = null;

			Uri uri = data.getData();

			String[] projection = { MediaColumns.DATA };
			Cursor cursor = this.getContentResolver().query(uri, projection,
					null, null, null);
			int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
			cursor.moveToFirst();
			path = cursor.getString(column_index);

			copyFile(path, "/sdcard/CarChecker/" + requestCode + ".jpg");
			basicInfo.buttons[requestCode-200].setText("已选定:" + basicInfo.buttons[requestCode-200].getText());
			return;
		}

		if (resultCode == Activity.RESULT_OK) {

			String path = null;

			Uri uri = data.getData();

			String[] projection = { MediaColumns.DATA };
			Cursor cursor = this.getContentResolver().query(uri, projection,
					null, null, null);
			int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
			cursor.moveToFirst();
			path = cursor.getString(column_index);

			Toast.makeText(
					this,
					" 文件存放路径： " + "/" + basicInfo.getOrderID() + "/"
							+ ci[requestCode].title + ".jpg", Toast.LENGTH_LONG)
					.show();
			ProgressDialog pd = ProgressDialog.show(ProcessOrderActivity.this,
					"正在上传图片", "上传中，请稍后……");
			pd.setProgress(0);

			FileUtils.uploadFile(path, "/" + basicInfo.getOrderID() + "/"
					+ ci[requestCode].title + ".jpg", pd, new Callback() {

				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					ci[requestCode].setPictureUploaded();
				}

				@Override
				public void onFail() {
					// TODO Auto-generated method stub

				}
			});

		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (needSaveCurrentPage)
			saveCurrentPage();
		needSaveCurrentPage = true;
	}

	@Override
	public void onResume() {
		super.onResume();
		resumeCurrentPage();
		//
	}

	private void saveCurrentPage() {
		if (Orders.processingBufferedOrderID == -1) {
			if (Orders.currentOrderJsonObject == null)
				Orders.currentOrderJsonObject = new JSONObject();
			saveData(Orders.currentOrderJsonObject);

		} else {
			try {
				saveData(Orders.bufferedOrdersJsonArray
						.getJSONObject(Orders.processingBufferedOrderID));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Orders.processingBufferedOrderID = -1;
		}
		Orders.update();
	}

	private void resumeCurrentPage() {
		if (Orders.processingBufferedOrderID == -1) {
			if (Orders.currentOrderJsonObject != null)

				resumeData(Orders.currentOrderJsonObject);

		} else {
			try {
				resumeData(Orders.bufferedOrdersJsonArray
						.getJSONObject(Orders.processingBufferedOrderID));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void saveData(JSONObject js) {
		basicInfo.getUserInput(js);
		for (int i = 0; i < MAX_ITEMS; i++) {
			ci[i].getUserInput(js);
		}

	}

	private double getScore(JSONObject js) {
		double totoalScore = 0;
		for (int i = 0; i < MAX_ITEMS; i++) {
			totoalScore += ci[i].getSore();
		}
		try {
			js.put("totalScore", 100 + totoalScore);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totoalScore;
	}

	private void resumeData(JSONObject js) {
		basicInfo.setUserInput(js);
		for (int i = 0; i < MAX_ITEMS; i++) {
			ci[i].setUserInput(js);
		}

	}

	private void initListView() {
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mPlanetTitles = SourceData_Category.titleStrings;
		// getResources().getStingArray(R.array.planets_array);

		// Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, mPlanetTitles));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (linearLayout[position] == null) {
					createCategoryView(position,
							sourceDataBase[position].startItemID(),
							sourceDataBase[position]);
				}
				// Highlight the selected item, update the title, and close the
				// drawer
				mDrawerList.setItemChecked(position, true);
				setTitle(mPlanetTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
				// for (int i = 0; i < SourceData_Category.length; i++)
				// linearLayout[i].setVisibility(View.INVISIBLE);
				mainLayout.removeAllViews();

				mainLayout.addView(linearLayout[position]);
				linearLayout[position].setVisibility(View.VISIBLE);
			}
		});
	}

	public void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}
}
