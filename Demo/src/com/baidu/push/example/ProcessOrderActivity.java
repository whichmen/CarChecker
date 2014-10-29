package com.baidu.push.example;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProcessOrderActivity extends Activity {

    TextView current_order_txt = null;
    ListView processed_order_txt = null;
    String[] processed_order_contentStrings = null;
    Button process_order_activity_submit_btn = null;
    Button process_order_activity_save = null;

    private boolean needSaveCurrentPage = true;

    private LinearLayout mainLayout;

    public static final int MAX_ITEMS =
            SourceData_1_ChaYanKeJiaoYiCheLiang.length +
            SourceData_2_CheShenWaiGuan.length +
            SourceData_3_FaDongJiCang.length +
            SourceData_4_GongNengXingLingBuJian.length +
            SourceData_5_JiaShiCangJianCha.length +
            SourceData_6_DiPan.length +
            SourceData_7_PanDingShiGuChe.length +
            SourceData_8_QiDongJianCha.length +
            SourceData_9_LuShi.length;

    CheckItem[] ci = new CheckItem[MAX_ITEMS];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_order_activity);

        // Orders.getUserOrders();

        process_order_activity_submit_btn = (Button) findViewById(R.id.process_order_activity_submit);

        process_order_activity_submit_btn
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        needSaveCurrentPage = false;
                        try {
                            if (Orders.processingBufferedOrderID == -1) {
                                if (Orders.currentOrderJsonObject == null)
                                    Orders.currentOrderJsonObject = new JSONObject();
                                saveData(Orders.currentOrderJsonObject);

                                Orders.finishCurrentOrder();
                            } else {
                                saveData(Orders.bufferedOrdersJsonArray
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

        // process_order_activity_save = (Button)
        // findViewById(R.id.process_order_activity_save);
        // process_order_activity_save
        // .setOnClickListener(new View.OnClickListener() {
        //
        // @Override
        // public void onClick(View v) {
        // // TODO Auto-generated method stub
        // // Orders.showAll();
        //
        // try {
        //
        // Orders.currentOrderJsonObject.put("CarName",
        // "current 皇马");
        //
        // JSONObject jsonObject1 = new JSONObject();
        // jsonObject1.put("CarName", "array 自行车1");
        // JSONObject jsonObject2 = new JSONObject();
        // jsonObject2.put("CarName", "array 自行车2");
        //
        // Orders.processedOrdersJsonArray.put(0, jsonObject1);
        // Orders.processedOrdersJsonArray.put(1, jsonObject2);
        // } catch (JSONException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //
        // Orders.update();
        //
        // // Orders.insert();
        // // Orders.findData();
        //
        // }
        // });

        mainLayout = (LinearLayout) findViewById(R.id.process_order_activity);

        // public CheckItem(String title, String[] listName, String[][]
        // itemName,
        // int[][] itemScore, boolean hasEdit, boolean hasBtn) {
//        ci[1] = new CheckItem("车体左右对称性",
//                SourceData.demolistName, SourceData.demoDropDownListName,
//                SourceData.demodropDownListScore, SourceData.hasEdit,
//                SourceData.hasBtn);
//        mainLayout.addView(ci[1].createCheckItem(this));
//
//        ci[0] = new CheckItem("车内是否无泡水痕迹",
//                SourceData.demolistName, SourceData.demoDropDownListName,
//                SourceData.demodropDownListScore, SourceData.hasEdit,
//                SourceData.hasBtn);
//        mainLayout.addView(ci[0].createCheckItem(this));




        int index = -1;

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 0) );

//NOTE 8 items
        for(int i = 0; i< SourceData_1_ChaYanKeJiaoYiCheLiang.length; i++){
            ci[++index] = new CheckItem(SourceData_1_ChaYanKeJiaoYiCheLiang.demoListTitle[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.demolistName[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.demoDropDownListName[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.demodropDownListScore[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.hasEdit[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }


//NOTE 32 items
        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 1) );

        for(int i = 0; i< SourceData_2_CheShenWaiGuan.length; i++){
            ci[++index] = new CheckItem(SourceData_2_CheShenWaiGuan.demoListTitle[i],
                    SourceData_2_CheShenWaiGuan.demolistName[i],
                    SourceData_2_CheShenWaiGuan.demoDropDownListName[i],
                    SourceData_2_CheShenWaiGuan.demodropDownListScore[i],
                    SourceData_2_CheShenWaiGuan.hasEdit[i],
                    SourceData_2_CheShenWaiGuan.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }


        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 2) );

        for(int i = 0; i< SourceData_3_FaDongJiCang.length; i++){
            ci[++index] = new CheckItem(SourceData_3_FaDongJiCang.demoListTitle[i],
                    SourceData_3_FaDongJiCang.demolistName[i],
                    SourceData_3_FaDongJiCang.demoDropDownListName[i],
                    SourceData_3_FaDongJiCang.demodropDownListScore[i],
                    SourceData_3_FaDongJiCang.hasEdit[i],
                    SourceData_3_FaDongJiCang.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }


        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 3) );

        for(int i = 0; i< SourceData_4_GongNengXingLingBuJian.length; i++){
            ci[++index] = new CheckItem(SourceData_4_GongNengXingLingBuJian.demoListTitle[i],
                    SourceData_4_GongNengXingLingBuJian.demolistName[i],
                    SourceData_4_GongNengXingLingBuJian.demoDropDownListName[i],
                    SourceData_4_GongNengXingLingBuJian.demodropDownListScore[i],
                    SourceData_4_GongNengXingLingBuJian.hasEdit[i],
                    SourceData_4_GongNengXingLingBuJian.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }


        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 4) );

        for(int i = 0; i< SourceData_5_JiaShiCangJianCha.length; i++){
            ci[++index] = new CheckItem(SourceData_5_JiaShiCangJianCha.demoListTitle[i],
                    SourceData_5_JiaShiCangJianCha.demolistName[i],
                    SourceData_5_JiaShiCangJianCha.demoDropDownListName[i],
                    SourceData_5_JiaShiCangJianCha.demodropDownListScore[i],
                    SourceData_5_JiaShiCangJianCha.hasEdit[i],
                    SourceData_5_JiaShiCangJianCha.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 5) );

        for(int i = 0; i< SourceData_6_DiPan.length; i++){
            ci[++index] = new CheckItem(SourceData_6_DiPan.demoListTitle[i],
                    SourceData_6_DiPan.demolistName[i],
                    SourceData_6_DiPan.demoDropDownListName[i],
                    SourceData_6_DiPan.demodropDownListScore[i],
                    SourceData_6_DiPan.hasEdit[i],
                    SourceData_6_DiPan.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 6) );

        for(int i = 0; i< SourceData_7_PanDingShiGuChe.length; i++){
            ci[++index] = new CheckItem(SourceData_7_PanDingShiGuChe.demoListTitle[i],
                    SourceData_7_PanDingShiGuChe.demolistName[i],
                    SourceData_7_PanDingShiGuChe.demoDropDownListName[i],
                    SourceData_7_PanDingShiGuChe.demodropDownListScore[i],
                    SourceData_7_PanDingShiGuChe.hasEdit[i],
                    SourceData_7_PanDingShiGuChe.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 7) );

        for(int i = 0; i< SourceData_8_QiDongJianCha.length; i++){
            ci[++index] = new CheckItem(SourceData_8_QiDongJianCha.demoListTitle[i],
                    SourceData_8_QiDongJianCha.demolistName[i],
                    SourceData_8_QiDongJianCha.demoDropDownListName[i],
                    SourceData_8_QiDongJianCha.demodropDownListScore[i],
                    SourceData_8_QiDongJianCha.hasEdit[i],
                    SourceData_8_QiDongJianCha.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 8) );

        for(int i = 0; i< SourceData_9_LuShi.length; i++){
            ci[++index] = new CheckItem(SourceData_9_LuShi.demoListTitle[i],
                    SourceData_9_LuShi.demolistName[i],
                    SourceData_9_LuShi.demoDropDownListName[i],
                    SourceData_9_LuShi.demodropDownListScore[i],
                    SourceData_9_LuShi.hasEdit[i],
                    SourceData_9_LuShi.hasBtn[i]
                    );
            mainLayout.addView(ci[index].createCheckItem(this));

        }


        // CheckItem ci3 = new CheckItem(SourceData.demoListTitle,
        // SourceData.demolistName, SourceData.demoDropDownListName,
        // SourceData.demodropDownListScore, SourceData.hasEdit,
        // SourceData.hasBtn);
        // mainLayout.addView(ci3.createCheckItem(this));
        //
        // CheckItem ci4 = new CheckItem(SourceData.demoListTitle,
        // SourceData.demolistName, SourceData.demoDropDownListName,
        // SourceData.demodropDownListScore, SourceData.hasEdit,
        // SourceData.hasBtn);
        // mainLayout.addView(ci4.createCheckItem(this));
        //
        //
        // CheckItem ci5 = new CheckItem(SourceData.demoListTitle,
        // SourceData.demolistName, SourceData.demoDropDownListName,
        // SourceData.demodropDownListScore, SourceData.hasEdit,
        // SourceData.hasBtn);
        // mainLayout.addView(ci5.createCheckItem(this));
        //
        // CheckItem ci6 = new CheckItem(SourceData.demoListTitle,
        // SourceData.demolistName, SourceData.demoDropDownListName,
        // SourceData.demodropDownListScore, SourceData.hasEdit,
        // SourceData.hasBtn);
        // mainLayout.addView(ci6.createCheckItem(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("", "hello world");
/*        if (resultCode == Activity.RESULT_OK) {

            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                Log.v("TestFile",
                        "SD card is not avaiable/writeable right now.");
                return;
            }

//            Bundle bundle = data.getExtras();
//            Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
            FileOutputStream b = null;
//            File file = new File("/sdcard/myImage/");
//            file.mkdirs();// 创建文件夹
            String fileName = "/sdcard/test/111.jpg";
            File path1 = new File(fileName);

            try {
                b = new FileOutputStream(fileName);

//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

//            ((ImageView) findViewById(R.id.imageView)).setImageBitmap(bitmap);// 将图片显示在ImageView里
            Uri uri = Uri.fromFile(path1);
            ImageView imageView = new ImageView(this);
            imageView.setImageURI(uri);
//            imageView.layout(0, 0, 600, 600);

//            Log.e("", "height = " + bitmap.getHeight() + " width = " + bitmap.getWidth());
//            imageView.setImageBitmap(bitmap);

            final int wLP = ViewGroup.LayoutParams.WRAP_CONTENT;
            final int hLP = ViewGroup.LayoutParams.WRAP_CONTENT;
            PopupWindow pupWin = new PopupWindow(imageView, wLP, hLP, false);

//            pupWin.setAnimationStyle(R.style.ParsePopupAnimation);
            pupWin.showAtLocation(imageView, Gravity.CENTER, 0, 0);
            // pupWin.setBackgroundDrawable(new ColorDrawable(-00000));
            pupWin.setHeight(800);
            pupWin.setWidth(800);
*/

//            AlertDialog dialog = new AlertDialog.Builder(this)
//            .setTitle("请选择是否重新拍照")
//            .setIcon(android.R.drawable.ic_dialog_info)
//            .setView(imageView)
//            .setPositiveButton("确定上传", null)
//            .setNegativeButton("重拍", null)
//            .show();
//
//            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//             params.width = 1000;
//             params.height = 2000 ;
//             dialog.getWindow().setAttributes(params);

//            dialog.getWindow().setLayout(800, 800);
//        }
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
        for(int i=0; i<MAX_ITEMS; i++ ){
            ci[i].getUserInput(js);
        }
    }

    private void resumeData(JSONObject js) {
        for(int i=0; i<MAX_ITEMS; i++){
            ci[i].setUserInput(js);
        }


    }

}
