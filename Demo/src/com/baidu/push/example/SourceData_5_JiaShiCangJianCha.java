package com.baidu.push.example;
//1
public class SourceData_5_JiaShiCangJianCha extends SourceDataBase{

    public int getLength(){
    	return length;
    }
    
    public int[][][] getHasRepair(){
    	return hasRepair;
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
	
	
    public static int length = 24;

    //此处表示检查项目名字
    private static String[] demoListTitle = new String[]
    		{
    	"全套钥匙",
    	"遥控器及功能",
    	"喇叭高低音色",
    	"玻璃加热功能",
    	"车内是否无水泡痕迹",
     	"车内是否整洁、无异味",
    	"车内后视镜是否完整、无破损、功能正常",
      	"天窗是否移动灵活、关闭正常",
       	"车顶是否无破损、松动及裂缝和污迹",
     	"玻璃窗升降器工作是否正常",
     	"各车门锁止",
     	"左、右后视镜折叠，调整装置工作是否正常",
    	"座椅是否完整、无破损、功能正常",
     	"安全带结构是否完整、功能是否正常",
    	"方向盘自由行程转角是否小于20度",
     	"座椅加热",
     	"储物盒是否无裂痕，配件是否无缺失",
     	"排挡把手柄是否完好、无破损",
     	"驻车制动系统是否灵活有效",
     	"仪表台是否无划痕、配件是否无缺失",
        "方向盘功能键",
    	"中央集控",
      	"前后雨刮器",
      	"仪表板出风管道"
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
                                {{ "正常", "异常", "", "", "", "" },
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
                                                {{ "正常", "异常", "", "", "", "" },
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
                                {{ 0, 0, 0, 0, 0, 0 },
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
                            {{ 0, 0, 0, 0, 0, 0 },
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
    private static boolean hasEdit[] = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};

    //此处表示是否需要传图片
    private static boolean hasBtn[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

}
