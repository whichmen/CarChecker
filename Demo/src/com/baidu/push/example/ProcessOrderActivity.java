package com.baidu.push.example;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    public static final int MAX_ITEMS = 2;
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
        ci[1] = new CheckItem("车体左右对称性",
                SourceData.demolistName, SourceData.demoDropDownListName,
                SourceData.demodropDownListScore, SourceData.hasEdit,
                SourceData.hasBtn);
        mainLayout.addView(ci[1].createCheckItem(this));

        ci[0] = new CheckItem("车内是否无泡水痕迹",
                SourceData.demolistName, SourceData.demoDropDownListName,
                SourceData.demodropDownListScore, SourceData.hasEdit,
                SourceData.hasBtn);
        mainLayout.addView(ci[0].createCheckItem(this));

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
