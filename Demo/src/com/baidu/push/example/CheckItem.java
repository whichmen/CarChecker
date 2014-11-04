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

    private String filePath = null;

    // public static String[][] demoDropDownListName = new String[][] {
    // { "鏃�", "杞诲井", "涓ラ噸", "寰堜弗閲�", "澶弗閲�", "" },
    // { "鏃�", "杞诲井", "涓ラ噸", "寰堜弗閲�", "澶弗閲�", "" },
    // { "鏃�", "杞诲井", "涓ラ噸", "寰堜弗閲�", "澶弗閲�", "" },
    // { "鏃�", "杞诲井", "涓ラ噸", "寰堜弗閲�", "澶弗閲�", "" },
    // { "鏃�", "杞诲井", "涓ラ噸", "寰堜弗閲�", "澶弗閲�", "" },
    // { "鏃�", "杞诲井", "涓ラ噸", "寰堜弗閲�", "澶弗閲�", "" }, };
    //
    // public static String[] demolistName = new String[] { "BX鍙樺舰", "NQ鎵洸",
    // "GH鏇存崲", "SH鐑х剨", "ZZ瑜剁毐" };
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

    public void setBasicInfoPtr(BasicInfo basicInfo) {
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

        title = "妫�娴嬮」鐩�";
        this.listName = new String[] { "鍓嶉潰", "鍚庨潰", "宸﹂潰", "鍙抽潰", "涓婇潰", "涓嬮潰" };
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

            // for(int j=5; j>=0; j--)
            // {
            // if(dropDownListName[i][j].equals(""))
            // continue;
            //
            // tempDropDownListName=
            // }

            spinner_name[i].setText(listName[i]);

            // 灏嗗彲閫夊唴瀹逛笌ArrayAdapter杩炴帴璧锋潵
            adapter = new ArrayAdapter<String>(activityContext,
                    android.R.layout.simple_spinner_item, dropDownListName[i]);

            // 璁剧疆涓嬫媺鍒楄〃鐨勯鏍�
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // 灏哸dapter 娣诲姞鍒皊pinner涓�
            spinner[i].setAdapter(adapter);

            // 璁剧疆榛樿鍊�
            spinner[i].setVisibility(View.VISIBLE);

            if (listName[i].equals("")) {
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

        editText = (EditText) buttonLayout.findViewById(R.id.checkitem_edit);
        if (!hasEdit)
            editText.setVisibility(View.INVISIBLE);

        btn = (Button) buttonLayout.findViewById(R.id.checkitem_btn);
        if (!hasBtn)
            btn.setVisibility(View.INVISIBLE);
        else {
            btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (!basicInfo.hasKeyInfo()) {
                        Toast.makeText(activityContext,
                                "璇峰厛杈撳叆璁㈠崟鍙凤紝鍚﹀垯鐓х墖鏃犳硶鏍规嵁璁㈠崟鍙峰懡鍚�",
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    // TODO Auto-generated method stub

                    File path1 = new File(Config.LOCAL_FILE_PATH
                            + basicInfo.getOrderID() + "/");
                    if (!path1.exists()) {
                        path1.mkdirs();
                    }

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    File path2 = new File(Config.LOCAL_FILE_PATH
                            + basicInfo.getOrderID() + "/"
                            + basicInfo.getKeyInfo() + "_" + title + ".jpg");

                    Uri uri = Uri.fromFile(path2);

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    intent.putExtra("pictureName", path2);
                    ((Activity) activityContext).startActivityForResult(intent,
                            1);

                }
            });
        }

        return buttonLayout;
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

    public void setUserInput(JSONObject js) {
        JSONObject itemJs = new JSONObject();
        try {
            itemJs = js.getJSONObject(title);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int i = 0; i < 6; i++) {
            try {
                spinner[i].setSelection(itemJs.getInt(listName[i]));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (hasEdit)
            try {
                editText.setText(itemJs.getString("edit"));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        Log.e("", "setUserInput itemjs = " + itemJs);
        Log.e("", "setUserInput js = " + js);
    }

    public double getSore() {
        double itemScore = 0;
        for (int i = 0; i < 6; i++) {
            itemScore += dropDownListScore[i][dropDownListResult[i]];
        }
        return itemScore;
    }

}
