package com.baidu.push.example;

import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
	Button process_order_activity_save = null;

	private boolean needSaveCurrentPage = true;

	private RelativeLayout mainLayout;

	private ViewGroup linearLayout[] = new ViewGroup[10];

	public static final int MAX_ITEMS = 140;

	// SourceData_1_ChaYanKeJiaoYiCheLiang.length
	// + SourceData_2_CheShenWaiGuan.length
	// + SourceData_3_FaDongJiCang.length
	// + SourceData_4_GongNengXingLingBuJian.length
	// + SourceData_5_JiaShiCangJianCha.length
	// + SourceData_6_DiPan.length
	// + SourceData_7_PanDingShiGuChe.length
	// + SourceData_8_QiDongJianCha.length + SourceData_9_LuShi.length;

	private SourceDataBase[] sourceDataBase = new SourceDataBase[10];

	CheckItem[] ci = new CheckItem[MAX_ITEMS];

	BasicInfo basicInfo = null;

	public void initSourceDataBase() {
		sourceDataBase[1] = new SourceData_1_ChaYanKeJiaoYiCheLiang();
		sourceDataBase[2] = new SourceData_2_CheShenWaiGuan();
		sourceDataBase[3] = new SourceData_3_FaDongJiCang();
		sourceDataBase[4] = new SourceData_4_GongNengXingLingBuJian();
		sourceDataBase[5] = new SourceData_5_JiaShiCangJianCha();
		sourceDataBase[6] = new SourceData_6_DiPan();
		sourceDataBase[7] = new SourceData_7_PanDingShiGuChe();
		sourceDataBase[8] = new SourceData_8_QiDongJianCha();
		sourceDataBase[9] = new SourceData_9_LuShi();

	}

	public void createCategory(int categoryID, int startItemID,
			SourceDataBase sourceDataBase) {

		LayoutInflater layoutInflater = LayoutInflater.from(this);

		String[] demoListTitle = sourceDataBase.getDemoListTitle();
		String[][] demolistName = sourceDataBase.getDemoListName();
		String[][][] demoDropDownListName = sourceDataBase
				.getDemoDropDownListName();
		double[][][] demodropDownListScore = sourceDataBase
				.getDemoDropDownListScore();
		int[][][] hasRepair = sourceDataBase.getHasRepair();
		boolean[] hasEdit = sourceDataBase.getHasEdit();
		boolean[] hasBtn = sourceDataBase.getHasBtn();

		linearLayout[categoryID] = (ViewGroup) layoutInflater.inflate(
				R.layout.basic_linear_layout, null);

		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

		linearLayout[categoryID].setLayoutParams(params);

		for (int i = 0; i < sourceDataBase.getLength(); i++) {
			ci[startItemID] = new CheckItem(demoListTitle[i], demolistName[i], 
					demoDropDownListName[i], demodropDownListScore[i],hasRepair[i],
					hasEdit[i], hasBtn[i]);
			ci[startItemID].setBasicInfoPtr(basicInfo);
			linearLayout[categoryID].addView(ci[startItemID]
					.createCheckItem(this, startItemID));
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

		process_order_activity_submit_btn = (Button) findViewById(R.id.process_order_activity_submit);

		process_order_activity_submit_btn
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						if (!basicInfo.hasKeyInfo()) {
							Toast.makeText(
									ProcessOrderActivity.this
											.getApplicationContext(),
									"请补全关键信息：订单号 姓名 时间", Toast.LENGTH_LONG)
									.show();
							return;
						}

						// TODO Auto-generated method stub
						needSaveCurrentPage = false;
						try {
							if (Orders.processingBufferedOrderID == -1) {
								if (Orders.currentOrderJsonObject == null)
									Orders.currentOrderJsonObject = new JSONObject();
								saveData(Orders.currentOrderJsonObject);
								getScore(Orders.currentOrderJsonObject);

								Orders.finishCurrentOrder();
							} else {
								saveData(Orders.bufferedOrdersJsonArray
										.getJSONObject(Orders.processingBufferedOrderID));
								getScore(Orders.bufferedOrdersJsonArray
										.getJSONObject(Orders.processingBufferedOrderID));

								Orders.finishBufferedOrder(Orders.processingBufferedOrderID);
								Orders.processingBufferedOrderID = -1;
							}

							Intent intent = new Intent(
									ProcessOrderActivity.this,
									OrdersActivity.class);
							startActivity(intent);

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

		for (int i = 1; i < 10; i++) {
			createCategory(i, index, sourceDataBase[i]);
			index += sourceDataBase[i].getLength();
		}

	}

	public void setPhotoOnClickListener(final CheckItem item,
			final Context activityContext) {

	}

	@Override
	protected void onActivityResult(final int requestCode,  int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == Activity.RESULT_OK) {

			String path = null;

			Uri uri = data.getData();

			String[] projection = { MediaStore.Images.Media.DATA };
			Cursor cursor = this.getContentResolver().query(uri, projection,
					null, null, null);
			int column_index = cursor
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			cursor.moveToFirst();
			path = cursor.getString(column_index);

			Toast.makeText(this, " 文件存放路径： " +  "/" + basicInfo.getOrderID() + "/" + ci[requestCode].title + ".jpg", Toast.LENGTH_LONG).show();
			ProgressDialog pd = ProgressDialog.show(ProcessOrderActivity.this,
					"正在上传图片", "上传中，请稍后……");
			pd.setProgress(0);

			FileUtils.uploadFile(path, "/" + basicInfo.getOrderID() + "/" + ci[requestCode].title + ".jpg" , pd,
					new Callback() {

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
				// Highlight the selected item, update the title, and close the
				// drawer
				mDrawerList.setItemChecked(position, true);
				setTitle(mPlanetTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
				for (int i = 0; i < 10; i++)
					linearLayout[i].setVisibility(View.INVISIBLE);

				linearLayout[position].setVisibility(View.VISIBLE);
			}
		});
	}
}
