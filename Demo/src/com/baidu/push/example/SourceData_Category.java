package com.baidu.push.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class SourceData_Category {

    public static int length = 8;

    public static String[] titleStrings = new String[]{
        "1:查验可交易车辆",
        "2:车身外观",
        "3:发动机仓",
        "4:功能性零部件",
        "5:驾驶舱检查",
        "6:底盘",
        "7:判定事故车",
        "8:启动检查",
        "9:路试"

    };

    public static View createCheckItemTitle(Context activityContext, int i){
        LayoutInflater layoutInflater = LayoutInflater.from(activityContext);
        View buttonLayout = layoutInflater.inflate(R.layout.checkitem_title, null);
        TextView titleTxt = (TextView) buttonLayout.findViewById(R.id.checkitem_title_title);
        titleTxt.setText(SourceData_Category.titleStrings[i]);
        return buttonLayout;
    }


}
