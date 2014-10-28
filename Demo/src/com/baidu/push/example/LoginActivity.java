package com.baidu.push.example;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    Button loginBtn = null;
    TextView usernameTxtTextView = null;
    EditText passwordEditText = null;

    ProgressDialog pd = null;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {// handler接收到消息后就会执行此方法
            pd.dismiss();// 关闭ProgressDialog

            Intent intent = new Intent(LoginActivity.this, OrdersActivity.class);
            startActivity(intent);
            finish();

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginBtn = (Button) findViewById(R.id.login_activity_btn_login);
        usernameTxtTextView = (TextView) findViewById(R.id.login_activity_text_username);
        usernameTxtTextView.setText("用户名：" + Users.userNameString);

        passwordEditText = (EditText)findViewById(R.id.login_activity_text_password);

        loginBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(passwordEditText.getText().toString().equals(Users.loadPassword(getApplicationContext()))){

                    pd = ProgressDialog.show(LoginActivity.this, "正在抓取用户数据", "加载中，请稍后……");

                    Orders.getUserOrders(getApplicationContext(),  new com.baidu.push.example.Callback() {

                        @Override
                        public void onSuccess() {
                            // TODO Auto-generated method stub
                            handler.sendEmptyMessage(0);
                        }

                        @Override
                        public void onFail() {
                            // TODO Auto-generated method stub

                        }
                    } );
                }
                else {
                    Toast.makeText(getApplicationContext(), "密码出错", Toast.LENGTH_LONG).show();
                }

            }});

    }
}
