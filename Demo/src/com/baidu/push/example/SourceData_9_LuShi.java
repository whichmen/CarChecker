package com.baidu.push.example;
//1
public class SourceData_9_LuShi extends SourceDataBase{

    public int getLength(){
    	return length;
    }
    
   // public int[] getHasSpinner(){
  //  	return hasSpinner;
  //  }
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
    
    public double[][][] getDemoDropDownListScore(){
    	return demodropDownListScore;
    }
	
	
    public static int length = 9;

    //此处表示检查项目名字
    private static String[] demoListTitle = new String[]
    		{"发动机运转、加速是否正常",
    	"车辆启动前踩下制动踏板，保持5s-10s，踏板无向下移动的迹象",
    	"踩住制动踏板启动发动机，踏板是否向下移动",
    	"行车制动系最大制动效能在踏板全行程的4/5以内达到",
    	"行驶是否无跑偏，啃胎现象",
    	"制动系统工作是否正常有效、制动不跑偏",
    	"变速箱工作是否正常、无异响",
    	"行驶过程中车辆底盘部位是否无异响",
    	"行驶过程中车辆转向系统是否无异响"
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
    	{ " ", "", "", "", "", "" }
    };
    //此处表示每一个檢查項目狀態的程度
    private static String[][][] demoDropDownListName = new String[][][] {
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
    private static double[][][] demodropDownListScore = new double[][][] {
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
                                        {{ 0, -2, 0, 0, 0, 0 },
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
                            {{ 0, 2, 0, 0, 0, 0 },
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
    private static boolean hasEdit[] = {true,true,true,true,true,true,true,true,true};

    //此处表示是否需要传图片
    private static boolean hasBtn[] = {false,false,false,false,false,false,false,false,false,};

}
