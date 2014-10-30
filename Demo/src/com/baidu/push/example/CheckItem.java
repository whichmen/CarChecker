package com.baidu.push.example;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
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

    public String title = null;

    public String[] listName = new String[6];
    public String[][] dropDownListName = new String[6][6];
    public double[][] dropDownListScore = new double[6][6];

    public String[] dropDownListName_length3 = new String[3];
    public String[] dropDownListName_length4 = new String[4];
    public String[] dropDownListName_length5 = new String[5];
    public String[] tempDropDownListName = null;

    public boolean hasEdit = false;
    public boolean hasBtn = false;

    private Spinner[] spinner = new Spinner[6];
    private ArrayAdapter<String> adapter;

    private TextView[] spinner_name = new TextView[6];
    private EditText editText;
    private Button btn;
    private TextView titleTxt;

    private BasicInfo basicInfo = null;
    private int[] dropDownListResult = new int[6];

    // public static String[][] demoDropDownListName = new String[][] {
    // { "无", "轻微", "严重", "很严重", "太严重", "" },
    // { "无", "轻微", "严重", "很严重", "太严重", "" },
    // { "无", "轻微", "严重", "很严重", "太严重", "" },
    // { "无", "轻微", "严重", "很严重", "太严重", "" },
    // { "无", "轻微", "严重", "很严重", "太严重", "" },
    // { "无", "轻微", "严重", "很严重", "太严重", "" }, };
    //
    // public static String[] demolistName = new String[] { "BX变形", "NQ扭曲",
    // "GH更换", "SH烧焊", "ZZ褶皱" };
    //
    // public static int[][] demodropDownListScore = new int[][] {
    // {0, -1, -2, -3, -4, 0},
    // {0, -1, -2, -3, -4, 0},
    // {0, -1, -2, -3, -4, 0},
    // {0, -1, -2, -3, -4, 0},
    // {0, -1, -2, -3, -4, 0},
    // {0, -1, -2, -3, -4, 0}
    // };

    public CheckItem(String title, String[] listName, String[][] itemName,
            double[][] itemScore, boolean hasEdit, boolean hasBtn) {

        // for (int i = 0; i < 6; i++) {
        // for (int j = 0; j < 6; j++) {
        // if (!itemName[i][j].equals("")) {
        // dropDownListName[i][j] = itemName[i][j];
        // dropDownListScore[i][j] = itemScore[i][j];
        // }
        // }
        // }

        dropDownListName = itemName;
        dropDownListScore = itemScore;

        this.title = title;
        this.listName = listName;
        this.hasEdit = hasEdit;
        this.hasBtn = hasBtn;

        dropDownListResult = new int[6];
    }

    public void setBasicInfoPtr(BasicInfo basicInfo){
        this.basicInfo = basicInfo;
    }

    public CheckItem() {
        spinner_name = new TextView[6];

        dropDownListName = new String[6][6];
        dropDownListScore = new double[6][6];
        dropDownListResult = new int[6];

        for (int i = 0; i < 6; i++) {
            dropDownListName[i] = new String[6];
            dropDownListScore[i] = new double[6];
            for (int j = 0; j < 6; j++) {
                {
                    dropDownListName[i][j] = "abc";
                    dropDownListScore[i][j] = 1;
                }
            }
        }

        title = "检测项目";
        this.listName = new String[] { "前面", "后面", "左面", "右面", "上面", "下面" };
        this.hasEdit = true;
        this.hasBtn = true;

    }

    public View createCheckItem(final Context activityContext) {
        LayoutInflater layoutInflater = LayoutInflater.from(activityContext);
        View buttonLayout = layoutInflater.inflate(R.layout.checkitem, null);

        titleTxt = (TextView) buttonLayout.findViewById(R.id.checkitem_title);
        titleTxt.setText(title);

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

//            for(int j=5; j>=0; j--)
//            {
//                if(dropDownListName[i][j].equals(""))
//                    continue;
//
//                tempDropDownListName=
//            }

            spinner_name[i].setText(listName[i]);

            // 将可选内容与ArrayAdapter连接起来
            adapter = new ArrayAdapter<String>(activityContext,
                    android.R.layout.simple_spinner_item, dropDownListName[i]);

            // 设置下拉列表的风格
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // 将adapter 添加到spinner中
            spinner[i].setAdapter(adapter);


            // 设置默认值
            spinner[i].setVisibility(View.VISIBLE);

            if(listName[i].equals("")){
                spinner_name[i].setVisibility(View.INVISIBLE);
                spinner[i].setVisibility(View.INVISIBLE);
            }



            // TODO Auto-generated constructor stub
        }

        spinner[0].setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int arg2, long arg3) {
                // TODO Auto-generated method stub
                dropDownListResult[0] = arg2;
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
                // TODO Auto-generated method stub
                dropDownListResult[1] = arg2;
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
                // TODO Auto-generated method stub
                dropDownListResult[2] = arg2;
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
                // TODO Auto-generated method stub
                dropDownListResult[3] = arg2;
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
                // TODO Auto-generated method stub
                dropDownListResult[4] = arg2;
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
                // TODO Auto-generated method stub
                dropDownListResult[5] = arg2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });





            editText = (EditText) buttonLayout
                    .findViewById(R.id.checkitem_edit);
            if (!hasEdit)
                editText.setVisibility(View.INVISIBLE);


            btn = (Button) buttonLayout.findViewById(R.id.checkitem_btn);
            if (!hasBtn)
                btn.setVisibility(View.INVISIBLE);
            else {
                btn.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if(!basicInfo.hasKeyInfo()){
                            Toast.makeText(activityContext, "请先输入订单号，否则照片无法根据订单号命名", Toast.LENGTH_LONG).show();
                            return;
                        }
                        // TODO Auto-generated method stub

                        File path1 = new File("/sdcard/CarChecker");
                        if(!path1.exists()){
                         path1.mkdirs();
                        }

                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        File path2 = new File("/sdcard/CarChecker/" + basicInfo.getKeyInfo() + "_" + title + ".jpg");

                        Uri uri = Uri.fromFile(path2);

                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                        ((Activity)activityContext).startActivityForResult(intent, 1);

                    }
                });
            }


        return buttonLayout;
    }

    public void setPhotoOnclickListener(OnClickListener listener){
        if(hasBtn)
            btn.setOnClickListener(listener);
    }

    public void getUserInput(JSONObject js) {
        JSONObject itemJs = new JSONObject();
        for (int i = 0; i < 6; i++) {
            try {
                itemJs.put(listName[i], dropDownListResult[i]);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (hasEdit) {
            try {
                itemJs.put("edit", editText.getText().toString());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        /*
         * if(hasBtn){ try { itemJs.put("photo_address",
         * editText.getText().toString()); } catch (JSONException e) { // TODO
         * Auto-generated catch block e.printStackTrace(); } }
         */

        try {
            js.put(title, itemJs);
            Log.e("", "getUserInput itemjs = " + itemJs);
            Log.e("", "getUserInput js = " + js);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void setUserInput(JSONObject js){
        JSONObject itemJs = new JSONObject();
        try {
            itemJs = js.getJSONObject(title);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i = 0; i< 6; i++){
            try {
                spinner[i].setSelection(itemJs.getInt(listName[i]));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(hasEdit)
            try {
                editText.setText(itemJs.getString("edit"));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        Log.e("", "setUserInput itemjs = " + itemJs);
        Log.e("", "setUserInput js = " + js);
    }

}
