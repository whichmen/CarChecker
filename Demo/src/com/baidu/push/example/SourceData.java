package com.baidu.push.example;

public class SourceData {

    //此处表示检查项目的类名字
    public static String demoListTitle = "车体左右对称性";

    //此处表示每一个检测选项的名字
    public static String[][] demoDropDownListName = new String[][] {
            { "无", "轻微", "严重", "很严重", "太严重", "" },
            { "无", "轻微", "严重", "很严重", "太严重", "" },
            { "无", "轻微", "严重", "很严重", "太严重", "" },
            { "无", "轻微", "严重", "很严重", "太严重", "" },
            { "无", "轻微", "严重", "很严重", "太严重", "" },
            { "无", "轻微", "严重", "很严重", "太严重", "" }, };

    //此处表示检查项目的名字
    public static String[] demolistName = new String[] { "BX变形", "NQ扭曲",
            "GH更换", "SH烧焊", "ZZ褶皱", "更换" };

    //此处表示得分情况
    public static int[][] demodropDownListScore = new int[][] {
            { 0, -1, -2, -3, -4, 0 }, { 0, -1, -2, -3, -4, 0 },
            { 0, -1, -2, -3, -4, 0 }, { 0, -1, -2, -3, -4, 0 },
            { 0, -1, -2, -3, -4, 0 }, { 0, -1, -2, -3, -4, 0 } };

    //此处表示是否需要备注框
    public static boolean hasEdit = true;

    //此处表示是否需要传图片
    public static boolean hasBtn = true;

}
