package com.baidu.push.example;
//1
public class SourceData_5_JiaShiCangJianCha {

    public static int length = 16;

    //此处表示检查项目名字
    public static String[] demoListTitle = new String[]
    		{"车内是否无水泡痕迹",
    	"车内后视镜是否完整、无破损、功能正常",
    	"座椅是否完整、无破损、功能正常",
    	"车内是否整洁、无异味",
    	"方向盘自由行程转角是否小于20度",
    	"车顶是否无破损、松动及裂缝和污迹",
    	"仪表台是否无划痕、配件是否无缺失",
    	"排挡把手柄是否完好、无破损",
    	"储物盒是否无裂痕，配件是否无缺失",
    	"天窗是否移动灵活、关闭正常",
    	"门窗密封条是否良好、无老化",
    	"安全带结构是否完整、功能是否正常",
    	"驻车制动系统是否灵活有效",
    	"玻璃窗升降器工作是否正常",
    	"门窗工作是否正常",
    	"左、右后视镜折叠，调整装置工作是否正常"
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
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
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
    		{{ 0, -1.5, 0, 0, 0, 0 },
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
                        {{ 0, -1, 0, 0, 0, 0 },
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
                                {{ 0, -1, 0, 0, 0, 0 },
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
                                        {{ 0, -1, 0, 0, 0, 0 },
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
                                                {{ 0, -1, 0, 0, 0, 0 },
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
                                                        {{ 0, -1, 0, 0, 0, 0 },
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
                                                                {{ 0, -1, 0, 0, 0, 0 },
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
                                                                        { 0, 0, 0, 0, 0, 0 }}
    };


    //此处表示整备复选框
    public static boolean hasSpinner[] = {true,};

    //此处表示是否需要备注框
    public static boolean hasEdit[] = {true, true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};

    //此处表示是否需要传图片
    public static boolean hasBtn[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

}
