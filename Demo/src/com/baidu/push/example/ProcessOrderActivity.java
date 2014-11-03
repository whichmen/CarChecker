package com.baidu.push.example;

import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    BasicInfo basicInfo = null;

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

                        if(!basicInfo.hasKeyInfo()){
                            Toast.makeText(ProcessOrderActivity.this.getApplicationContext(), "请补全关键信息：订单号 姓名 时间", Toast.LENGTH_LONG).show();
                            return;
                        }

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


        mainLayout = (LinearLayout) findViewById(R.id.process_order_activity);

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 0) );

        basicInfo = new BasicInfo();
        mainLayout.addView(basicInfo.createBasicInfoItem(this));

        int index = -1;

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 1) );


        for(int i = 0; i< SourceData_1_ChaYanKeJiaoYiCheLiang.length; i++){
            ci[++index] = new CheckItem(SourceData_1_ChaYanKeJiaoYiCheLiang.demoListTitle[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.demolistName[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.demoDropDownListName[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.demodropDownListScore[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.hasEdit[i],
                    SourceData_1_ChaYanKeJiaoYiCheLiang.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }


        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 2) );

        for(int i = 0; i< SourceData_2_CheShenWaiGuan.length; i++){
            ci[++index] = new CheckItem(SourceData_2_CheShenWaiGuan.demoListTitle[i],
                    SourceData_2_CheShenWaiGuan.demolistName[i],
                    SourceData_2_CheShenWaiGuan.demoDropDownListName[i],
                    SourceData_2_CheShenWaiGuan.demodropDownListScore[i],
                    SourceData_2_CheShenWaiGuan.hasEdit[i],
                    SourceData_2_CheShenWaiGuan.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }


        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 3) );

        for(int i = 0; i< SourceData_3_FaDongJiCang.length; i++){
            ci[++index] = new CheckItem(SourceData_3_FaDongJiCang.demoListTitle[i],
                    SourceData_3_FaDongJiCang.demolistName[i],
                    SourceData_3_FaDongJiCang.demoDropDownListName[i],
                    SourceData_3_FaDongJiCang.demodropDownListScore[i],
                    SourceData_3_FaDongJiCang.hasEdit[i],
                    SourceData_3_FaDongJiCang.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }


        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 4) );

        for(int i = 0; i< SourceData_4_GongNengXingLingBuJian.length; i++){
            ci[++index] = new CheckItem(SourceData_4_GongNengXingLingBuJian.demoListTitle[i],
                    SourceData_4_GongNengXingLingBuJian.demolistName[i],
                    SourceData_4_GongNengXingLingBuJian.demoDropDownListName[i],
                    SourceData_4_GongNengXingLingBuJian.demodropDownListScore[i],
                    SourceData_4_GongNengXingLingBuJian.hasEdit[i],
                    SourceData_4_GongNengXingLingBuJian.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }


        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 5) );

        for(int i = 0; i< SourceData_5_JiaShiCangJianCha.length; i++){
            ci[++index] = new CheckItem(SourceData_5_JiaShiCangJianCha.demoListTitle[i],
                    SourceData_5_JiaShiCangJianCha.demolistName[i],
                    SourceData_5_JiaShiCangJianCha.demoDropDownListName[i],
                    SourceData_5_JiaShiCangJianCha.demodropDownListScore[i],
                    SourceData_5_JiaShiCangJianCha.hasEdit[i],
                    SourceData_5_JiaShiCangJianCha.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 6) );

        for(int i = 0; i< SourceData_6_DiPan.length; i++){
            ci[++index] = new CheckItem(SourceData_6_DiPan.demoListTitle[i],
                    SourceData_6_DiPan.demolistName[i],
                    SourceData_6_DiPan.demoDropDownListName[i],
                    SourceData_6_DiPan.demodropDownListScore[i],
                    SourceData_6_DiPan.hasEdit[i],
                    SourceData_6_DiPan.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 7) );

        for(int i = 0; i< SourceData_7_PanDingShiGuChe.length; i++){
            ci[++index] = new CheckItem(SourceData_7_PanDingShiGuChe.demoListTitle[i],
                    SourceData_7_PanDingShiGuChe.demolistName[i],
                    SourceData_7_PanDingShiGuChe.demoDropDownListName[i],
                    SourceData_7_PanDingShiGuChe.demodropDownListScore[i],
                    SourceData_7_PanDingShiGuChe.hasEdit[i],
                    SourceData_7_PanDingShiGuChe.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 8) );

        for(int i = 0; i< SourceData_8_QiDongJianCha.length; i++){
            ci[++index] = new CheckItem(SourceData_8_QiDongJianCha.demoListTitle[i],
                    SourceData_8_QiDongJianCha.demolistName[i],
                    SourceData_8_QiDongJianCha.demoDropDownListName[i],
                    SourceData_8_QiDongJianCha.demodropDownListScore[i],
                    SourceData_8_QiDongJianCha.hasEdit[i],
                    SourceData_8_QiDongJianCha.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }

        mainLayout.addView(  SourceData_Category.createCheckItemTitle(this, 9) );

        for(int i = 0; i< SourceData_9_LuShi.length; i++){
            ci[++index] = new CheckItem(SourceData_9_LuShi.demoListTitle[i],
                    SourceData_9_LuShi.demolistName[i],
                    SourceData_9_LuShi.demoDropDownListName[i],
                    SourceData_9_LuShi.demodropDownListScore[i],
                    SourceData_9_LuShi.hasEdit[i],
                    SourceData_9_LuShi.hasBtn[i]
                    );
            ci[index].setBasicInfoPtr(basicInfo);
            mainLayout.addView(ci[index].createCheckItem(this));
        }

    }

    public void setPhotoOnClickListener(final CheckItem item, final Context activityContext){



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("", "hello world");

//        pictureName

        if(requestCode == 1)
        {
          Intent intent = new Intent();
          /* 开启Pictures画面Type设定为image */
          intent.setType("image/*");
          /* 使用Intent.ACTION_GET_CONTENT这个Action */
          intent.setAction(Intent.ACTION_GET_CONTENT);
          /* 取得相片后返回本画面 */
          startActivityForResult(intent, 2);
        }else
        if (resultCode == Activity.RESULT_OK) {

            String path = null;

            try {

                Uri originalUri = data.getData();        //获得图片的uri
                ContentResolver resolver = getContentResolver();
               Bitmap bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);        //显得到bitmap图片



                String[] proj = {MediaStore.Images.Media.DATA};

                //好像是android多媒体数据库的封装接口，具体的看Android文档

                Cursor cursor = managedQuery(originalUri, proj, null, null, null);

                //按我个人理解 这个是获得用户选择的图片的索引值

                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                //将光标移至开头 ，这个很重要，不小心很容易引起越界

                cursor.moveToFirst();

                //最后根据索引值获取图片路径

                path = cursor.getString(column_index);

            }catch (IOException e) {

                Log.e("",e.toString());

            }




       /*     String sdStatus = Environment.getExternalStorageState();
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
            Bundle bundle = data.getExtras();
            String string = bundle.getString("pictureName");*/

            File path1 = new File(path);

//            try {
//                b = new FileOutputStream(fileName);
//
////                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    b.flush();
//                    b.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

//            ((ImageView) findViewById(R.id.imageView)).setImageBitmap(bitmap);// 将图片显示在ImageView里
            Uri uri = Uri.fromFile(path1);
            ImageView imageView = new ImageView(this);
            imageView.setImageURI(uri);
//            imageView.layout(0, 0, 600, 600);

//            Log.e("", "height = " + bitmap.getHeight() + " width = " + bitmap.getWidth());
//            imageView.setImageBitmap(bitmap);

//            final int wLP = ViewGroup.LayoutParams.WRAP_CONTENT;
//            final int hLP = ViewGroup.LayoutParams.WRAP_CONTENT;
//            PopupWindow pupWin = new PopupWindow(imageView, wLP, hLP, false);
//
////            pupWin.setAnimationStyle(R.style.ParsePopupAnimation);
//            pupWin.showAtLocation(imageView, Gravity.CENTER, 0, 0);
//            // pupWin.setBackgroundDrawable(new ColorDrawable(-00000));
//            pupWin.setHeight(800);
//            pupWin.setWidth(800);


            AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle("请选择是否重新拍照")
            .setIcon(android.R.drawable.ic_dialog_info)
            .setView(imageView)
            .setPositiveButton("确定上传", null)
            .setNegativeButton("重拍", null)
            .show();

//            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
//             params.width = 1000;
//             params.height = 2000 ;
//             dialog.getWindow().setAttributes(params);

//            dialog.getWindow().setLayout(800, 800);
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
        for(int i=0; i<MAX_ITEMS; i++ ){
            ci[i].getUserInput(js);
        }

    }

    private void resumeData(JSONObject js) {
        basicInfo.setUserInput(js);
        for(int i=0; i<MAX_ITEMS; i++){
            ci[i].setUserInput(js);
        }


    }

}
