package com.baidu.push.example;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CheckItem {

	private final int FORCE_GOOD = 0;
	private final int FORCE_REPAIR = 1;
	private final int USER_NO_REPAIR = 2;
	private final int USER_SUCC_REPAIR = 3;
	private final int USER_SAFE_REPAIR = 4;

	// check info not need init
	public String title = null;

	public String[] listName = null;
	public String[][] dropDownListName = null;
	public double[][] dropDownListScore = null;

	public String[] tempDropDownListName = null;
	public boolean hasEdit = false;
	public boolean hasBtn = false;
	private int[][] repairTag = null;
	private BasicInfo basicInfo = null;

	// widget need init
	private Spinner[] spinner = new Spinner[6];
	private ArrayAdapter<String> adapter;
	private TextView[] spinner_name = new TextView[6];
	private EditText editText;
	private Button btn;
	private TextView titleTxt;

	// result info need init
	public int[] dropDownListResult = new int[6];
	public int repairResult = 0;
	private Spinner repairSpinner = null;
	private static String[] repairSpinnerName = { "无需整备", "建议整备", "安全整备" };
	private String editContent = "";

	private boolean[] spinnerAutoVisitedTag = { false, false, false, false,
			false, false };
	private boolean repairSpinnerAutoVisitedTag = false;

	public CheckItem(String title, String[] listName, String[][] itemName,
			double[][] itemScore, int[][] repairTag, boolean hasEdit,
			boolean hasBtn) {

		dropDownListName = itemName;
		dropDownListScore = itemScore;

		this.repairTag = repairTag;
		this.title = title;
		this.listName = listName;
		this.hasEdit = hasEdit;
		this.hasBtn = hasBtn;

	}

	public void setBasicInfoPtr(BasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}

	public void setPictureUploaded() {
		btn.setText("已上传");
	}

	public View createCheckItem(final Context activityContext, final int itemID) {

		LayoutInflater layoutInflater = LayoutInflater.from(activityContext);
		View buttonLayout = layoutInflater.inflate(R.layout.checkitem, null);

		titleTxt = (TextView) buttonLayout.findViewById(R.id.checkitem_title);
		titleTxt.setText(title);

		repairSpinner = (Spinner) buttonLayout
				.findViewById(R.id.Spinner_repair);

		adapter = new ArrayAdapter<String>(activityContext,
				android.R.layout.simple_spinner_item, repairSpinnerName);

		repairSpinner.setAdapter(adapter);
		repairSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (repairSpinnerAutoVisitedTag == false) {
					repairSpinnerAutoVisitedTag = true;
					return;
				}
				// TODO Auto-generated method stub
				repairResult = arg2 + 2;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinner[0] = (Spinner) buttonLayout.findViewById(R.id.Spinner1);
		spinner[1] = (Spinner) buttonLayout.findViewById(R.id.Spinner2);
		spinner[2] = (Spinner) buttonLayout.findViewById(R.id.Spinner3);
		spinner[3] = (Spinner) buttonLayout.findViewById(R.id.Spinner4);
		spinner[4] = (Spinner) buttonLayout.findViewById(R.id.Spinner5);
		spinner[5] = (Spinner) buttonLayout.findViewById(R.id.Spinner6);

		spinner_name[0] = (TextView) buttonLayout
				.findViewById(R.id.Spinner_txt1);
		spinner_name[1] = (TextView) buttonLayout
				.findViewById(R.id.Spinner_txt2);
		spinner_name[2] = (TextView) buttonLayout
				.findViewById(R.id.Spinner_txt3);
		spinner_name[3] = (TextView) buttonLayout
				.findViewById(R.id.Spinner_txt4);
		spinner_name[4] = (TextView) buttonLayout
				.findViewById(R.id.Spinner_txt5);
		spinner_name[5] = (TextView) buttonLayout
				.findViewById(R.id.Spinner_txt6);

		for (int i = 0; i < 6; i++) {

			spinner_name[i].setText(listName[i]);

			adapter = new ArrayAdapter<String>(activityContext,
					android.R.layout.simple_spinner_item, dropDownListName[i]);

			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			spinner[i].setAdapter(adapter);

			spinner[i].setVisibility(View.VISIBLE);

			spinner[i].setSelection(dropDownListResult[i]);

			if (listName[i].equals("")) {
				spinner_name[i].setVisibility(View.INVISIBLE);
				spinner[i].setVisibility(View.INVISIBLE);
			}

		}

		spinner[0].setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (spinnerAutoVisitedTag[0] == false) {
					spinnerAutoVisitedTag[0] = true;
					return;
				}

				dropDownListResult[0] = arg2;
				setRepairSpinnerStatus(checkRepairSpinnerStatus());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinner[1].setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (spinnerAutoVisitedTag[1] == false) {
					spinnerAutoVisitedTag[1] = true;
					return;
				}

				// TODO Auto-generated method stub
				dropDownListResult[1] = arg2;
				setRepairSpinnerStatus(checkRepairSpinnerStatus());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinner[2].setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (spinnerAutoVisitedTag[2] == false) {
					spinnerAutoVisitedTag[2] = true;
					return;
				}
				// TODO Auto-generated method stub
				dropDownListResult[2] = arg2;
				setRepairSpinnerStatus(checkRepairSpinnerStatus());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinner[3].setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (spinnerAutoVisitedTag[3] == false) {
					spinnerAutoVisitedTag[3] = true;
					return;
				}
				// TODO Auto-generated method stub
				dropDownListResult[3] = arg2;
				setRepairSpinnerStatus(checkRepairSpinnerStatus());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinner[4].setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (spinnerAutoVisitedTag[4] == false) {
					spinnerAutoVisitedTag[4] = true;
					return;
				}
				// TODO Auto-generated method stub
				dropDownListResult[4] = arg2;
				setRepairSpinnerStatus(checkRepairSpinnerStatus());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinner[5].setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (spinnerAutoVisitedTag[5] == false) {
					spinnerAutoVisitedTag[5] = true;
					return;
				}
				// TODO Auto-generated method stub
				dropDownListResult[5] = arg2;
				setRepairSpinnerStatus(checkRepairSpinnerStatus());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

//		setRepairSpinnerStatus(checkRepairSpinnerStatus());
		
		switch (repairResult) {
		case FORCE_GOOD:
			repairSpinner.setVisibility(View.INVISIBLE);
			break;
		case FORCE_REPAIR:
			repairSpinner.setVisibility(View.VISIBLE);
			repairSpinner.setSelection(2);
			repairSpinner.setClickable(false);
			break;
		case USER_NO_REPAIR:
			repairSpinner.setVisibility(View.VISIBLE);
			repairSpinner.setSelection(0);
			repairSpinner.setClickable(true);
			break;
		case USER_SUCC_REPAIR:
			repairSpinner.setVisibility(View.VISIBLE);
			repairSpinner.setSelection(1);
			repairSpinner.setClickable(true);
			break;

		case USER_SAFE_REPAIR:
			repairSpinner.setVisibility(View.VISIBLE);
			repairSpinner.setSelection(2);
			repairSpinner.setClickable(true);
			break;

		default:
			break;
		}

		editText = (EditText) buttonLayout.findViewById(R.id.checkitem_edit);
		if (!hasEdit)
			editText.setVisibility(View.INVISIBLE);
		else {
			editText.setText(editContent);
			editText.addTextChangedListener(new TextWatcher() {

				@Override
				public void onTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub
					editContent = String.valueOf(arg0);
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterTextChanged(Editable arg0) {
					// TODO Auto-generated method stub

				}
			});
		}

		btn = (Button) buttonLayout.findViewById(R.id.checkitem_btn);
		if (!hasBtn)
			btn.setVisibility(View.INVISIBLE);
		else {
			btn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					if (!basicInfo.hasKeyInfo()) {
						Toast.makeText(activityContext, "请补全关键信息：订单号 姓名 时间",
								Toast.LENGTH_LONG).show();
						return;
					}

					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_PICK);
					intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

					((Activity) activityContext).startActivityForResult(intent,
							itemID);

				}
			});
		}

		return buttonLayout;
	}

	private int checkRepairSpinnerStatus() {

		int max = 0;
		for (int i = 0; i < 6; i++) {
			max = java.lang.Math.max(max, repairTag[i][dropDownListResult[i]]);
		}
		return max;
	}

	private void setRepairSpinnerStatus(int status) {

		switch (status) {
		// 强制安全
		case 0:
			repairResult = FORCE_GOOD;
			repairSpinner.setVisibility(View.INVISIBLE);
			repairSpinner.setClickable(false);
			repairSpinner.setSelection(0);
			break;
		// 用户可以选择是否整备
		case 1:
			if (repairResult == USER_NO_REPAIR
					|| repairResult == USER_SAFE_REPAIR
					|| repairResult == USER_SUCC_REPAIR)
				break;
			else {
				repairResult = USER_NO_REPAIR;
				repairSpinner.setVisibility(View.VISIBLE);
				repairSpinner.setSelection(0);
				repairSpinner.setClickable(true);
				break;
			}
			// 强制必须整备
		case 2:
			repairResult = FORCE_REPAIR;
			repairSpinner.setVisibility(View.VISIBLE);
			repairSpinner.setSelection(2);
			repairSpinner.setClickable(false);
			break;
		default:
			break;
		}

	}

	public void uploadPicture() {

	}

	public void setPhotoOnclickListener(OnClickListener listener) {
		if (hasBtn)
			btn.setOnClickListener(listener);
	}

	public void getUserInput(JSONObject js) {
		JSONObject itemJs = new JSONObject();
		for (int i = 0; i < 6; i++) {
			try {
				if(dropDownListResult[i] != 0)
				itemJs.put(listName[i], dropDownListResult[i]);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			if(repairResult != 0)
			itemJs.put("repairMode", repairResult);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (hasEdit) {
			try {
				if(!editContent.trim().equals(""))
				itemJs.put("edit", editContent);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			js.put(title, itemJs);
			// Log.e("", "getUserInput itemjs = " + itemJs);
			// Log.e("", "getUserInput js = " + js);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public void setUserInput(JSONObject js) {
		JSONObject itemJs = new JSONObject();
		try {
			itemJs = js.getJSONObject(title);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 6; i++) {
			try {
				dropDownListResult[i] = itemJs.getInt(listName[i]);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		try {
			repairResult = itemJs.getInt("repairMode");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (hasEdit)
			try {
				editContent = itemJs.getString("edit");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		// Log.e("", "setUserInput itemjs = " + itemJs);
		// Log.e("", "setUserInput js = " + js);
	}

	public double getSore() {
		double itemScore = 0;
		for (int i = 0; i < 6; i++) {
			itemScore += dropDownListScore[i][dropDownListResult[i]];
		}
		return itemScore;
	}

}
