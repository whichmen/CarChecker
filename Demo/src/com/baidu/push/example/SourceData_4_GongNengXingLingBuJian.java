package com.baidu.push.example;
//1
public class SourceData_4_GongNengXingLingBuJian extends SourceDataBase{

    public int getLength(){
    	return length;
    }
    
    public int[] getHasSpinner(){
    	return hasSpinner;
    }
    public boolean[] getHasEdit(){
    	return hasEdit;
    }
    public boolean[] getHasBtn(){
    	return hasBtn;
    }

    public String[] getDemoListTitle(){
    	return demoListTitle;
    }
    
    public String[][] getDemoListName(){
    	return demolistName;
    }
    
    public String[][][] getDemoDropDownListName(){
    	return demoDropDownListName;
    }
    
    public  double[][][] getDemoDropDownListScore(){
    	return demodropDownListScore;
    }
	
	
    public static int length = 19;

    //此处表示检查项目名字
    private static String[] demoListTitle = new String[]
    		{"发动机舱盖锁止",
    	"发动机舱盖液压撑杆",
    	"后门/后备箱液压支撑杆",
    	"各车门锁止",
    	"前后雨刮器",
    	"立柱密封胶条",
    	"座椅加热",
    	"仪表板出风管道",
    	"中央集控",
    	"方向盘功能键",
    	"全套钥匙",
    	"遥控器及功能",
    	"喇叭高低音色",
    	"玻璃加热功能",
    	"备胎",
    	"千斤顶",
    	"轮胎扳手及随车工具",
    	"三角警示牌",
    	"灭火器"
    	};

    //此处表示检查项目的狀態
    private static String[][] demolistName = new String[][] {
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
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" },
    	{ " ", "", "", "", "", "" }
    };
    //此处表示每一个檢查項目狀態的程度
    private static String[][][] demoDropDownListName = new String[][][] {
    		{{ "正常", "异常", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" },
            { "", "", "", "", "", "" }},

            {{ "正常", "异常", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" }},

                {{ "正常", "异常", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" }},

                    {{ "正常", "异常", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" }},

                        {{ "正常", "异常", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" }},

                            {{ "正常", "异常", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" }},

                                {{ "正常", "异常", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" }},

                                    {{ "正常", "异常", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" }},
                                        {{ "正常", "异常", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" }},
                                            {{ "正常", "异常", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" }},
                                                {{ "正常", "异常", "", "", "", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" }},
                                                    {{ "正常", "异常", "", "", "", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" }},
                                                        {{ "正常", "异常", "", "", "", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" }},
                                                            {{ "正常", "异常", "", "", "", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" }},
                                                                {{ "有", "无", "", "", "", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" }},
                                                                    {{ "有", "无", "", "", "", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" }},
                                                                        {{ "有", "无", "", "", "", "" },
                                                                            { "", "", "", "", "", "" },
                                                                            { "", "", "", "", "", "" },
                                                                            { "", "", "", "", "", "" },
                                                                            { "", "", "", "", "", "" },
                                                                            { "", "", "", "", "", "" }},
                                                                            {{ "有", "无", "", "", "", "" },
                                                                                { "", "", "", "", "", "" },
                                                                                { "", "", "", "", "", "" },
                                                                                { "", "", "", "", "", "" },
                                                                                { "", "", "", "", "", "" },
                                                                                { "", "", "", "", "", "" }},
                                                                                {{ "有", "无", "", "", "", "" },
                                                                                    { "", "", "", "", "", "" },
                                                                                    { "", "", "", "", "", "" },
                                                                                    { "", "", "", "", "", "" },
                                                                                    { "", "", "", "", "", "" },
                                                                                    { "", "", "", "", "", "" }}
    };


    //此处表示得分情况
    private static double[][][] demodropDownListScore = new double[][][] {
    		{{ 0, 0, 0, 0, 0, 0 },
    		{ 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 }},
            {{ 0, 0, 0, 0, 0, 0 },
        		{ 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }},
                {{ 0, 0, 0, 0, 0, 0 },
            		{ 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 }},
                    {{ 0, 0, 0, 0, 0, 0 },
                		{ 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 }},
                        {{ 0, 0, 0, 0, 0, 0 },
                    		{ 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 }},
                            {{ 0, 0, 0, 0, 0, 0 },
                        		{ 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 }},
                                {{ 0, 0, 0, 0, 0, 0 },
                            		{ 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 }},
                                    {{ 0, 0, 0, 0, 0, 0 },
                                		{ 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 }},
                                        {{ 0, 0, 0, 0, 0, 0 },
                                    		{ 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 }},
                                            {{ 0, 0, 0, 0, 0, 0 },
                                        		{ 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 }},
                                                {{ 0, 0, 0, 0, 0, 0 },
                                            		{ 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 }},
                                                    {{ 0, 0, 0, 0, 0, 0 },
                                                		{ 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 }},
                                                        {{ 0, 0, 0, 0, 0, 0 },
                                                    		{ 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 }},
                                                            {{ 0, 0, 0, 0, 0, 0 },
                                                        		{ 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 }},
                                                                {{ 0, 0, 0, 0, 0, 0 },
                                                            		{ 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 }},
                                                                    {{ 0, 0, 0, 0, 0, 0 },
                                                                		{ 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 }},
                                                                        {{ 0, 0, 0, 0, 0, 0 },
                                                                    		{ 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 }},
                                                                            {{ 0, 0, 0, 0, 0, 0 },
                                                                        		{ 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 }},
                                                                                {{ 0, 0, 0, 0, 0, 0 },
                                                                            		{ 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 }}
  };



    //此处表示是否整备，0代表默认情况下不显示，1代表“无需整备”“建议整备”“安全整备”三选一，2代表强制生成“安全整备”
    public static int[][][]  hasRepair = new int[][][] {
		{{ 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 }},

            {{ 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }},

                {{ 0, 1, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0 }},


                    {{ 0, 1, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 }},

                        {{ 0, 1, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 },
                            { 0, 0, 0, 0, 0, 0 }},

                            {{ 0, 1, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0 }},

                                {{ 0, 1, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 },
                                    { 0, 0, 0, 0, 0, 0 }},

                                    {{ 0, 1, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 }},
                                        {{ 0, 1, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 },
                                            { 0, 0, 0, 0, 0, 0 }},
                                            {{ 0, 1, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 },
                                                { 0, 0, 0, 0, 0, 0 }},
                                                {{ 0, 1, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 },
                                                    { 0, 0, 0, 0, 0, 0 }},
                                                    {{ 0, 1, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 },
                                                        { 0, 0, 0, 0, 0, 0 }},
                                                        {{ 0, 1, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 },
                                                            { 0, 0, 0, 0, 0, 0 }},
                                                            {{ 0, 1, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 },
                                                                { 0, 0, 0, 0, 0, 0 }},
                                                                {{ 0, 1, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                    { 0, 0, 0, 0, 0, 0 }},
                                                                    {{ 0, 1, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 },
                                                                        { 0, 0, 0, 0, 0, 0 }},
                                                                        {{ 0, 1, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 },
                                                                            { 0, 0, 0, 0, 0, 0 }},
                                                                            {{ 0, 1, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 },
                                                                                { 0, 0, 0, 0, 0, 0 }},
                                                                                {{ 0, 1, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 },
                                                                                    { 0, 0, 0, 0, 0, 0 }}
    };
    //此处表示是否需要备注框
    private static boolean hasEdit[] = {true, true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};

    //此处表示是否需要传图片
    private static boolean hasBtn[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,};

}
