package com.baidu.push.example;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 *
 * 推送通知时，自定义打开行为的演示activity。 请在控制台通知推送界面中，高级设置->通知后续行为->自定义打开行为，选中并且填写内容：
 * intent:#Intent;component=com.baidu.push.example/com.baidu.push.example.
 * CustomActivity;end 确认推送后，手机将会收到通知，点击通知后，将打开CustomActivity
 *
 * 用服务端rest api或者sdk推送的朋友，可以通过设置推送方法的open_type和pkg_content参数来实现。具体见api文档
 * 参考：http:
 * //developer.baidu.com/wiki/index.php?title=docs/cplat/push/faq#.E4.B8.
 * BA.E4.BD.95.E9.80.9A.E8.BF.87Server_SDK.E6
 * .8E.A8.E9.80.81.E6.88.90.E5.8A.9F.EF.BC.8CAndroid.E7.AB.AF.E5.8D.B4.E6.94.B6.E4.B8.8D.E5.88.B0.E9.80.9A.E7.9F.A5.EF.BC
 * . 9 F
 */
public class OrdersActivity extends Activity {

    TextView custom_activity_username_txtTextView = null;
    ListView processed_order_txt = null;
    String[] processed_order_contentStrings = null;
    Button process_current_order_btn = null;
    Button process_buffered_order_btn = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources resource = this.getResources();
        String pkgName = this.getPackageName();

        setContentView(resource.getIdentifier("orders_activity", "layout",
                pkgName));

        custom_activity_username_txtTextView = (TextView) findViewById(R.id.custom_activity_username);

        processed_order_txt = (ListView) findViewById(R.id.processed_order_txt);
        process_current_order_btn = (Button) findViewById(R.id.process_current_order_btn);

        process_current_order_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrdersActivity.this,
                        ProcessOrderActivity.class);
                startActivity(intent);
                // TODO Auto-generated method stub

            }
        });

        // Utils.unProcessedOrderContent

        process_buffered_order_btn = (Button)findViewById(R.id.process_buffered_order_btn);
        process_buffered_order_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OrdersActivity.this,
                        BufferedOrdersActivity.class);
                startActivity(intent);
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
        updateView();
        //
    }

    public void updateView(){
        custom_activity_username_txtTextView.setText(Users.userNameString);

        processed_order_contentStrings = new String[Orders.processedOrdersJsonArray
                .length()];
        try {
            // if(!Orders.processedOrderContent.isEmpty())
            int size = Orders.processedOrdersJsonArray.length();
            for (int i = 0; i < Orders.processedOrdersJsonArray.length(); i++)
                processed_order_contentStrings[size-i-1] = Orders.processedOrdersJsonArray
                        .getJSONObject(i).toString();/*FIX ME */
        } catch (Exception e) {
            Log.e("ToArray", "1111failure:" + e.getMessage());
        }

        processed_order_txt.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                processed_order_contentStrings));

    }
}
