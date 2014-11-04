package com.baidu.push.example;

import com.baidu.android.pushservice.PushManager;

public class RegisiterActivity extends Activity {

    Button registerBtn = null;
    EditText usernameEdit = null;
    EditText passwordEditText = null;
    EditText checkNum = null;
    public static ProgressDialog pdFirst = null;
    ProgressDialog pd = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regisiter);

        final Context context = this.getApplicationContext();

        usernameEdit = (EditText) findViewById(R.id.regisiter_activity_edit_username);
        passwordEditText = (EditText) findViewById(R.id.regisiter_activity_edit_password);
        checkNum = (EditText) findViewById(R.id.regisiter_activity_edit_num);

        registerBtn = (Button) findViewById(R.id.regisiter_activity_btn_confirm);
        pdFirst = ProgressDialog.show(RegisiterActivity.this, "首次启动程序配置中",
                "加载中，请稍后……");
        registerBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (checkNum(checkNum.getText().toString())) {
                    Users.setUserNameAndPassword(context
                            .getApplicationContext(), usernameEdit.getText()
                            .toString(), passwordEditText.getText().toString());

                    List<String> stringList = new LinkedList<String>();
                    stringList.add(usernameEdit.getText().toString());
                    PushManager.setTags(getApplicationContext(), stringList);
                    pd = ProgressDialog.show(RegisiterActivity.this,
                            "正在初始化用户数据", "加载中，请稍后……");

                    Orders.createUser(new Callback() {

                        @Override
						@Override
                        public void onSuccess() {
                            // TODO Auto-generated method stub
                            handler.sendEmptyMessage(0);
                        }

                        @Override
						@Override
                        public void onFail() {
                            // TODO Auto-generated method stub

                        }
                    });

                } else {
                    Toast.makeText(context.getApplicationContext(), "邀请码输入有误",
                            Toast.LENGTH_LONG).show();
                }

                // Intent intent = new Intent(OrdersActivity.this,
                // BufferedOrdersActivity.class);
                // startActivity(intent);
                // // TODO Auto-generated method stub

            }
        });

    }

    public boolean checkNum(String num) {
        if (num.equals("ok"))
            return true;
        else
            return false;

    }

    private void spandTimeMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {// handler接收到消息后就会执行此方法
            pd.dismiss();// 关闭ProgressDialog

            Intent intent = new Intent(RegisiterActivity.this,
                    OrdersActivity.class);
            startActivity(intent);
            finish();

        }
    };

    public static Handler handlerFirst = new Handler() {
        @Override
        public void handleMessage(Message msg) {// handler接收到消息后就会执行此方法
            if (pdFirst != null)
                pdFirst.dismiss();// 关闭ProgressDialog
        }
    };

}
