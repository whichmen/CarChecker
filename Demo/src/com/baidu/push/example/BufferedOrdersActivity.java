package com.baidu.push.example;

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
 * .8E.A8.E9.80.81.E6.88.90.E5.8A.9F.EF.BC.8CAndroid.E7.AB.AF.E5.8D.B4.E6.94.B6.E4.B8.8D.E5.88.B0.E9.80.9A.E7.9F.A5.EF.
 * B C . 9 F
 */
public class BufferedOrdersActivity extends Activity {

    private TextView buffered_orders_activity_username_txtTextView = null;
//    private TextView current_order_txt = null;
    private ListView buffered_order_txt = null;
    private String[] buffered_order_contentStrings = null;
//    private Button process_current_order_btn = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources resource = this.getResources();
        String pkgName = this.getPackageName();

        setContentView(resource.getIdentifier("buffered_orders_activity",
                "layout", pkgName));

        // processed_order_contentStrings = new
        // String[Orders.processedOrderContent.size()];

        buffered_orders_activity_username_txtTextView = (TextView) findViewById(R.id.buffered_orders_activity_username);

        buffered_order_txt = (ListView) findViewById(R.id.buffered_orders_activity_txt);
        buffered_order_txt.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                Intent intent = new Intent(BufferedOrdersActivity.this,
                        ProcessOrderActivity.class);
                Orders.processingBufferedOrderID = position;
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

    public void updateView() {
        buffered_orders_activity_username_txtTextView
                .setText(Users.userNameString);
        if (Orders.bufferedOrdersJsonArray == null
                || Orders.bufferedOrdersJsonArray.length() == 0) {
            return;
        }

        buffered_order_contentStrings = new String[Orders.bufferedOrdersJsonArray
                .length()];
        try {
            int size = Orders.bufferedOrdersJsonArray.length();
            for (int i = 0; i < Orders.bufferedOrdersJsonArray.length(); i++)
                buffered_order_contentStrings[i] = Orders.bufferedOrdersJsonArray
                        .getJSONObject(i).getString("OrderDescription");
        } catch (Exception e) {
            Log.e("ToArray", "failure:" + e.getMessage());
        }

        buffered_order_txt.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                buffered_order_contentStrings));

    }
}
