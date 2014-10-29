package com.baidu.push.example;
//1
public class SourceData_8_QiDongJianCha {

    public static int length = 10;

    //此处表示检查项目名字
    public static String[] demoListTitle = new String[]
    		{"车辆启动是否顺畅（时间小于5s，或一次启动）",
    	"仪表板指示灯显示是否正常，无故障报警",
    	"各类灯光和调节功能是否正常",
    	"泊车辅助系统是否工作正常",
    	"制动防抱死系统（ABS）工作是否正常",
    	"空调系统风量、方向调节、分区控制、自动控制、制冷工作是否正常",
    	"发动机在冷、热车状态下怠速运转是否稳定",
    	"怠速运转时发动机是否无异响",
    	"空挡状态下逐渐增加发动机转速，发动机声音过度是否无异响",
    	"车辆排气是否无异响（白烟、蓝烟、无色）"
    	};

    //此处表示检查项目的狀態
    public static String[][] demolistName = new String[][] {
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" }
    };
    //此处表示每一个檢查項目狀態的程度
    public static String[][][] demoDropDownListName = new String[][][] {
    	{{ "是", "否", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" }},
            {{ "是", "否", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" }},
                {{ "是", "否", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" }},
                    {{ "是", "否", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" }},
                        {{ "是", "否", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" }},
                            {{ "是", "否", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" }},
                                {{ "是", "否", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" }},
                                    {{ "是", "否", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" }},
                                        {{ "是", "否", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" }},
                                            {{ "是", "否", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" }}
     };


    //此处表示得分情况
    public static double[][][] demodropDownListScore = new double[][][] {
    	{{ 0, -2, 0, 0, 0, 0 },
    		{ 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 }},
            {{ 0, -2, 0, 0, 0, 0 },
        		{ 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }},
                {{ 0, -1, 0, 0, 0, 0 },
            		{ 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 }},
                    {{ 0, -0.5, 0, 0, 0, 0 },
                		{ 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 }},
                        {{ 0, -0.5, 0, 0, 0, 0 },
                    		{ 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 }},
                            {{ 0, -0.5, 0, 0, 0, 0 },
                        		{ 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 }},
                                {{ 0, -0.5, 0, 0, 0, 0 },
                            		{ 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 }},
                                    {{ 0, -10, 0, 0, 0, 0 },
                                		{ 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 }},
                                        {{ 0, -10, 0, 0, 0, 0 },
                                    		{ 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 }},
                                            {{ 0, -10, 0, 0, 0, 0 },
                                        		{ 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 }}
    };

    //此处表示整备复选框
    public static int hasSpinner[] = {1,};
    //此处表示是否需要备注框
    public static boolean hasEdit[] = {true,true,true,true,true,true,true,true,true,true};

    //此处表示是否需要传图片
    public static boolean hasBtn[] = {false,false,false,false,false,false,false,false,false,false,};

}
