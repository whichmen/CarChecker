package com.baidu.push.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

/*
 * 云推送Demo主Activity。
 * 代码中，注释以Push标注开头的，表示接下来的代码块是Push接口调用示例
 */

public class PushDemoActivity extends Activity implements View.OnClickListener {

    private static final String TAG = PushDemoActivity.class.getSimpleName();
    RelativeLayout mainLayout = null;
    int akBtnId = 0;
    int initBtnId = 0;
    int richBtnId = 0;
    int setTagBtnId = 0;
    int delTagBtnId = 0;
    int clearLogBtnId = 0;
    Button initButton = null;
    Button initWithApiKey = null;
    Button displayRichMedia = null;
    Button setTags = null;
    Button delTags = null;
    Button clearLog = null;
    Button btn_start_main = null;
    TextView logText = null;
    ScrollView scrollView = null;
    public static int initialCnt = 0;
    TextView main_welcome_txt = null;
    String welcomeInfoString = " 你好，这是调试以及账户设置页面，点击下边这个按钮开始接客";

    Callback callback;

    static Context instance = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Users.init(getApplicationContext());
        Orders.initFrontia(getApplicationContext());

        instance = this;

        Utils.logStringCache = Utils.getLogText(getApplicationContext());

        Resources resource = this.getResources();
        String pkgName = this.getPackageName();

        setContentView(resource.getIdentifier("main", "layout", pkgName));
        akBtnId = resource.getIdentifier("btn_initAK", "id", pkgName);
        initBtnId = resource.getIdentifier("btn_init", "id", pkgName);
        richBtnId = resource.getIdentifier("btn_rich", "id", pkgName);
        setTagBtnId = resource.getIdentifier("btn_setTags", "id", pkgName);
        delTagBtnId = resource.getIdentifier("btn_delTags", "id", pkgName);
        clearLogBtnId = resource.getIdentifier("btn_clear_log", "id", pkgName);
        main_welcome_txt = (TextView) findViewById(R.id.main_welcome_txt);
        main_welcome_txt.setText(welcomeInfoString);

        initWithApiKey = (Button) findViewById(akBtnId);
        initButton = (Button) findViewById(initBtnId);
        displayRichMedia = (Button) findViewById(richBtnId);
        setTags = (Button) findViewById(setTagBtnId);
        delTags = (Button) findViewById(delTagBtnId);
        clearLog = (Button) findViewById(clearLogBtnId);
        btn_start_main = (Button) findViewById(R.id.btn_start_main);

        logText = (TextView) findViewById(resource.getIdentifier("text_log",
                "id", pkgName));
        scrollView = (ScrollView) findViewById(resource.getIdentifier(
                "stroll_text", "id", pkgName));

        btn_start_main.setOnClickListener(this);
        initWithApiKey.setOnClickListener(this);
        initButton.setOnClickListener(this);
        setTags.setOnClickListener(this);
        delTags.setOnClickListener(this);
        displayRichMedia.setOnClickListener(this);
        clearLog.setOnClickListener(this);

        // Push: 以apikey的方式登录，一般放在主Activity的onCreate中。
        // 这里把apikey存放于manifest文件中，只是一种存放方式，
        // 您可以用自定义常量等其它方式实现，来替换参数中的Utils.getMetaValue(PushDemoActivity.this,
        // "api_key")
        // ！！ 请将AndroidManifest.xml 104行处 api_key 字段值修改为自己的 api_key 方可使用 ！！
        // ！！ ATTENTION：You need to modify the value of api_key to your own at
        // row 104 in AndroidManifest.xml to use this Demo !!

        PushManager.startWork(getApplicationContext(),
                PushConstants.LOGIN_TYPE_API_KEY,
                Utils.getMetaValue(PushDemoActivity.this, "api_key"));

        if (Users.loadUserName(this.getApplicationContext()).equals("error") ||  Users.loadUserName(this.getApplicationContext()).equals(""))
        {
            register();
        }
        else {
            Users.userNameString = Users.loadUserName(this.getApplicationContext());
            login();

        }

        // Push: 如果想基于地理位置推送，可以打开支持地理位置的推送的开关
        // PushManager.enableLbs(getApplicationContext());

    }

    public void login() {
        Intent intent = new Intent(PushDemoActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void register(){
        Intent intent = new Intent(PushDemoActivity.this, RegisiterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == akBtnId) {
////            initWithApiKey();
//        } else if (v.getId() == initBtnId) {
////            initWithBaiduAccount();
//        } else if (v.getId() == richBtnId) {
////            openRichMediaList();
//        } else if (v.getId() == setTagBtnId) {
//            setTags();
//        } else if (v.getId() == delTagBtnId) {
//            deleteTags();
//        } else if (v.getId() == clearLogBtnId) {
//            Utils.logStringCache = "";
//            Utils.setLogText(getApplicationContext(), Utils.logStringCache);
//            updateDisplay();
//        } else if (v.getId() == R.id.btn_start_main) {
//
//            // if (Orders.alreadyGetOrderInfo) {
//            // Intent intent = new Intent(PushDemoActivity.this,
//            // OrdersActivity.class);
//            // startActivity(intent);
//            // } else {
//            // Toast.makeText(this, "同学你必须你必须耐心等待，正在从百度狗屎服务器加载账户信息",
//            // Toast.LENGTH_LONG)
//            // .show();
//            // }
//        }

    }

    // // 打开富媒体列表界面
    // private void openRichMediaList() {
    // // Push: 打开富媒体消息列表
    // Intent sendIntent = new Intent();
    // sendIntent.setClassName(getBaseContext(),
    // "com.baidu.android.pushservice.richmedia.MediaListActivity");
    // sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    // PushDemoActivity.this.startActivity(sendIntent);
    // }

    // 删除tag操作
//    private void deleteTags() {
//        LinearLayout layout = new LinearLayout(PushDemoActivity.this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        final EditText textviewGid = new EditText(PushDemoActivity.this);
//        textviewGid.setHint("请输入真实姓名，此功能还有问题。");
//        layout.addView(textviewGid);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(
//                PushDemoActivity.this);
//        builder.setView(layout);
//        builder.setPositiveButton("确定删除",
//                new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // Push: 删除tag调用方式
//                        List<String> tags = Utils.getTagsList(textviewGid
//                                .getText().toString());
//                        PushManager.delTags(getApplicationContext(), tags);
//                    }
//                });
//        builder.show();
//    }

//    // 设置标签,以英文逗号隔开
//    private void setTags() {
//        LinearLayout layout = new LinearLayout(PushDemoActivity.this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//        final EditText textviewGid = new EditText(PushDemoActivity.this);
//        textviewGid.setHint("请输入真实姓名，此用户名非常重要，输入后无法修改");
//        layout.addView(textviewGid);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(
//                PushDemoActivity.this);
//        builder.setView(layout);
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // Push: 设置tag调用方式
//                List<String> tags = Utils.getTagsList(textviewGid.getText()
//                        .toString());
//                PushManager.setTags(getApplicationContext(), tags);
//                if (tags != null && tags.get(0) != "" && tags.get(0) != null
//                        && tags.size() == 1) {
//                    // Users.setUserName(getApplicationContext(), tags.get(0));
//                    Orders.initFrontia(getApplicationContext());
////                    Orders.createUser();
//                } else
//                    Toast.makeText(getApplicationContext(), "同学你这是什么鬼名字，重搞一个",
//                            Toast.LENGTH_LONG).show();
//            }
//
//        });
//        builder.show();
//    }

    // // 以apikey的方式绑定
    // private void initWithApiKey() {
    // // Push: 无账号初始化，用api key绑定
    // PushManager.startWork(getApplicationContext(),
    // PushConstants.LOGIN_TYPE_API_KEY,
    // Utils.getMetaValue(PushDemoActivity.this, "api_key"));
    // }
    //
    // // 以百度账号登陆，获取access token来绑定
    // private void initWithBaiduAccount() {
    // Log.e("", "initwitchBaiduAccount");
    // // if (Orders.isLoginBaidu) {
    // // 已登录则清除Cookie, access token, 设置登录按钮
    // CookieSyncManager.createInstance(getApplicationContext());
    // CookieManager.getInstance().removeAllCookie();
    // CookieSyncManager.getInstance().sync();
    //
    // Orders.isLoginBaidu = false;
    // Orders.isLoginPushManager = false;
    // Orders.alreadyGetOrderInfo = false;
    // Users.userId = null;
    // Users.userNameString = null;
    //
    // initButton.setText("登陆百度账号初始化Channel");
    // // }
    // // 跳转到百度账号登录的activity
    // Intent intent = new Intent(PushDemoActivity.this, LoginActivity.class);
    // startActivity(intent);
    // }

    // @Override
    // public void onStart() {
    // super.onStart();
    // }
    //
    // @Override
    // public void onResume() {
    // super.onResume();
    //
    // Log.d(TAG, "onResume");
    // updateDisplay();
    // }

    // @Override
    // protected void onNewIntent(Intent intent) {
    //
    // instance = this;
    //
    // Log.e("", "onNewIntent");
    // String action = intent.getAction();
    //
    // if (Utils.ACTION_LOGIN.equals(action)) {
    // // Push: 百度账号初始化，用access token绑定
    // String accessToken = intent
    // .getStringExtra(Utils.EXTRA_ACCESS_TOKEN);
    // String expires_in = intent.getStringExtra(Utils.EXTRA_EXPIRES_IN);
    //
    // Users.setAccessToken(getApplicationContext(), accessToken,
    // Long.valueOf(expires_in));
    //
    // Log.e("", "PushManager.startWork onNewIntent");
    // PushManager.startWork(getApplicationContext(),
    // PushConstants.LOGIN_TYPE_ACCESS_TOKEN, accessToken);
    //
    // initButton.setText("更换百度账号");
    //
    // Orders.isLoginBaidu = true;
    // main_welcome_txt.setText( welcomeInfoString);
    //
    // }
    //
    // updateDisplay();
    // }

    // private void setupPushManager(String accessToken) {
    //
    // // Log.e("", "call setup PushManager");
    // Log.e("", "PushManager.startWork setupPushManager");
    // PushManager.startWork(getApplicationContext(),
    // PushConstants.LOGIN_TYPE_ACCESS_TOKEN, accessToken);
    //
    // Resources resource = this.getResources();
    // String pkgName = this.getPackageName();
    // // Push: 设置自定义的通知样式，具体API介绍见用户手册，如果想使用系统默认的可以不加这段代码
    // // 请在通知推送界面中，高级设置->通知栏样式->自定义样式，选中并且填写值：1，
    // // 与下方代码中 PushManager.setNotificationBuilder(this, 1, cBuilder)中的第二个参数对应
    // CustomPushNotificationBuilder cBuilder = new
    // CustomPushNotificationBuilder(
    // getApplicationContext(), resource.getIdentifier(
    // "notification_custom_builder", "layout", pkgName),
    // resource.getIdentifier("notification_icon", "id", pkgName),
    // resource.getIdentifier("notification_title", "id", pkgName),
    // resource.getIdentifier("notification_text", "id", pkgName));
    // cBuilder.setNotificationFlags(Notification.FLAG_AUTO_CANCEL);
    // cBuilder.setNotificationDefaults(Notification.DEFAULT_SOUND
    // | Notification.DEFAULT_VIBRATE);
    // cBuilder.setStatusbarIcon(this.getApplicationInfo().icon);
    // cBuilder.setLayoutDrawable(resource.getIdentifier(
    // "simple_notification_icon", "drawable", pkgName));
    //
    // PushManager.setNotificationBuilder(this, 1, cBuilder);
    //
    // }

    // @Override
    // public void onStop() {
    // super.onStop();
    // }

    @Override
    public void onDestroy() {
        Utils.setLogText(getApplicationContext(), Utils.logStringCache);
        super.onDestroy();
    }

    // 更新界面显示内容
//    private void updateDisplay() {
//        Log.d(TAG, "updateDisplay, logText:" + logText + " cache: "
//                + Utils.logStringCache);
//        if (logText != null) {
//            logText.setText(Utils.logStringCache);
//        }
//        if (scrollView != null) {
//            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
//        }
//    }

}
