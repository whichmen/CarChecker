package com.baidu.push.example;
//1
public class SourceData_7_PanDingShiGuChe extends SourceDataBase{

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
    
    public double[][][] getDemoDropDownListScore(){
    	return demodropDownListScore;
    }
	
	
    public static int length = 17;

    //此处表示检查项目名字
    private static String[] demoListTitle = new String[]
    		{"车体左右对称性",
    	"左A柱",
    	"左B柱",
    	"左C柱",
    	"左D柱",
    	"右A柱",
    	"右B柱",
    	"右C柱",
    	"右D柱",
    	"左前纵梁",
    	"右前纵梁",
    	"左前减震器悬挂部位",
    	"右前减震器悬挂部位",
    	"左后减震器悬挂部位",
    	"右后减震器悬挂部位",
    	"左底大边",
    	"右底大边"
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
            {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" },
                { "", "", "", "", "", "" }},
                {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" },
                    { "", "", "", "", "", "" }},
                    {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" },
                        { "", "", "", "", "", "" }},
                        {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" },
                            { "", "", "", "", "", "" }},
                            {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" },
                                { "", "", "", "", "", "" }},
                                {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" },
                                    { "", "", "", "", "", "" }},
                                    {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" },
                                        { "", "", "", "", "", "" }},
                                        {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" },
                                            { "", "", "", "", "", "" }},
                                            {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" },
                                                { "", "", "", "", "", "" }},
                                                {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" },
                                                    { "", "", "", "", "", "" }},
                                                    {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" },
                                                        { "", "", "", "", "", "" }},
                                                        {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" },
                                                            { "", "", "", "", "", "" }},
                                                            {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" },
                                                                { "", "", "", "", "", "" }},
                                                                {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" },
                                                                    { "", "", "", "", "", "" }},
                                                                    {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" },
                                                                        { "", "", "", "", "", "" }},
                                                                        {{ "变形", "扭曲", "更换", "烧焊", "褶皱", "" },
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
                                                                            { 0, 0, 0, 0, 0, 0 }}
    		};


    //此处表示是否整备，0代表默认情况下不显示，1代表“无需整备”“建议整备”“安全整备”三选一，2代表强制生成“安全整备”
    public static int[][][]  hasRepair = new int[][][] {
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
            

    //此处表示是否需要备注框
    private static boolean hasEdit[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    //此处表示是否需要传图片
    private static boolean hasBtn[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

}
