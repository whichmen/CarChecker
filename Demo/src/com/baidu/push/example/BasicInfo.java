package com.baidu.push.example;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BasicInfo {

	public String basicInfo[] = new String[] { "订单号：", "客户姓名：", "时间：", "地点：",
			"联系电话：", "品牌：", "车系：", "排量：", "车身颜色：", "牌照号码：", "VIN码：", "发动机号：",
			"初次登记日期：", "表征里程：", "产地：国产/进口", "环保标准：" };

	private TextView title[] = new TextView[basicInfo.length];
	public EditText content[] = new EditText[basicInfo.length];
	public Button[] buttons = new Button[8];

	public View createBasicInfoItem(final Context activityContext) {

		LayoutInflater layoutInflater = LayoutInflater.from(activityContext);
		ViewGroup Layout = (ViewGroup) layoutInflater.inflate(
				R.layout.basic_linear_layout, null);

		for (int i = 0; i < basicInfo.length; i++) {
			View layout_item = layoutInflater.inflate(R.layout.basic_info_item,
					null);
			title[i] = (TextView) layout_item
					.findViewById(R.id.basic_info_title);
			title[i].setText(basicInfo[i]);
			content[i] = (EditText) layout_item
					.findViewById(R.id.basic_info_content);
			Layout.addView(layout_item);
		}

		ViewGroup buttonLayout = (ViewGroup) layoutInflater.inflate(
				R.layout.basic_info_item_upload_picture, null);
		Layout.addView(buttonLayout);

		buttons[0] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_1);
		buttons[1] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_2);
		buttons[2] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_3);
		buttons[3] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_4);
		buttons[4] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_5);
		buttons[5] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_6);
		buttons[6] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_7);
		buttons[7] = (Button) Layout
				.findViewById(R.id.basic_info_upload_picture_8);
		for(int i = 0; i<8 ;i ++)
		{
			initButton(Layout, i, activityContext);
		}
		
		return Layout;

	}

	public void initButton(ViewGroup Layout, final int num,
			final Context activityContext) {

		buttons[num].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_PICK);
				intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				((Activity) activityContext).startActivityForResult(intent,
						200 + num);

			}
		});

	}

	public void getUserInput(JSONObject js) {

		for (int i = 0; i < basicInfo.length; i++) {
			try {
				js.put(basicInfo[i], content[i].getText().toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setUserInput(JSONObject js) {
		for (int i = 0; i < basicInfo.length; i++) {
			try {
				content[i].setText(js.getString(basicInfo[i]));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean hasKeyInfo() {
		for (int i = 0; i < 3; i++) {
			if (content[i].getText().toString().equals("")
					|| content[i].getText().toString().isEmpty())
				return false;
		}
		return true;

	}

	public String getKeyInfo() {
		return (content[0].getText().toString() + "_"
				+ content[1].getText().toString() + "_" + content[2].getText()
				.toString());
	}

	public String getOrderID() {
		return (content[0].getText().toString());
	}

	public String getCustomerName() {
		return (content[1].getText().toString());
	}

	public String getCheckTime() {
		return (content[2].getText().toString());
	}

}
