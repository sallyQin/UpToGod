package com.example.a1.uptogod;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 1 on 2017/4/30.
 */

public class LoadInfoSQLiteHelper extends SQLiteOpenHelper { //"加载"信息

    static int recyclerCounts;//在"加载"界面中，共需要多少个recyclerView
    int countsNum;//是可选数
    String resPic;//资源图
    String question;//问题
    String answer[];//答案

//    private static List<LoadInfoSQLiteHelper> DEFAULT_List_2 = new ArrayList<>();
//    private static List<LoadInfoSQLiteHelper> DEFAULT_List_3 = new ArrayList<>();
//    static {
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","我该买么？",new String[]{"买","不买"}));
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","我该出门么？",new String[]{"该出门","不该"}));
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","坚持还是放弃？",new String[]{"坚持","放弃"}));
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","现在该向她求婚吗？",new String[]{"该","不该"}));
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","该答应他的求婚吗？",new String[]{"该","不该"}));
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","向左还是向右走？",new String[]{"向左","向右"}));
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","今天该健身么？",new String[]{"该","不该"}));
//        DEFAULT_List_2.add(new LoadInfoSQLiteHelper(2,"choices2_pie","选1还是选2？",new String[]{"1","2"}));
//
//        DEFAULT_List_3.add(new LoadInfoSQLiteHelper(3,"choices3_pie","去哪里度假？",new String[]{"历史名胜","海岛","自然风光"}));
//        DEFAULT_List_3.add(new LoadInfoSQLiteHelper(3,"choices3_pie","今天吃什么菜系呢？",new String[]{"中餐","西餐","日本菜"}));
//        DEFAULT_List_3.add(new LoadInfoSQLiteHelper(3,"choices3_pie","是否该买辆新车？",new String[]{"买","不买","再说"}));
//        DEFAULT_List_3.add(new LoadInfoSQLiteHelper(3,"choices3_pie","周末去哪里玩？",new String[]{"本市","周边","家里呆"}));
//        DEFAULT_List_3.add(new LoadInfoSQLiteHelper(3,"choices3_pie","在哪里买房？",new String[]{"本市","周边","暂时不考虑"}));
//    }

    public LoadInfoSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "loadInfo", null, version);
    }





//    public LoadInfoSQLiteHelper(int countsNum,String resPic,String question, String[] answer){
//        this.countsNum = countsNum;
//        this.resPic = resPic;
//        this.question = question;
//        this.answer = answer;
//
//    }

//    public static List<LoadInfoSQLiteHelper> getLoadInfo(){
//        List list = new ArrayList();
//        if(oneOfN == 2){
//            list.addAll(DEFAULT_List_2);
//            recyclerCounts = 1;
//        }else if(oneOfN == 3){
//            list.addAll(DEFAULT_List_3);
//            recyclerCounts = 1;
//        }else{
//            recyclerCounts = 2;
//            list.addAll(DEFAULT_List_2);
//            list.addAll(DEFAULT_List_3);
//        }
//        return list;
//    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table LoadInfos (loadId INTEGER PRIMARY KEY,countsNum INTEGER,resPic VARCHAR,question VARCHAR,answer VARCHAR)");
        ContentValues cv = new ContentValues();
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","我该买么？");
        cv.put("answer","买,不买");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","我该出门么？");
        cv.put("answer","该出门,不该");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","坚持还是放弃？");
        cv.put("answer","坚持,放弃");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","现在该向她求婚吗？");
        cv.put("answer","该,不该");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","该答应他的求婚吗？");
        cv.put("answer","该,不该");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","向左还是向右走？");
        cv.put("answer","向左,向右");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","今天该健身么？");
        cv.put("answer","该,不该");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",2);
        cv.put("resPic","choices2_pie");
        cv.put("question","选1还是选2？");
        cv.put("answer","1,2");
        sqLiteDatabase.insert("LoadInfos",null,cv);//以上是2选1
        cv.put("countsNum",3);
        cv.put("resPic","choices3_pie");
        cv.put("question","去哪里度假？");
        cv.put("answer","历史名胜,海岛,自然风光");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",3);
        cv.put("resPic","choices3_pie");
        cv.put("question","今天吃什么菜系呢？");
        cv.put("answer","中餐,西餐,日本菜");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",3);
        cv.put("resPic","choices3_pie");
        cv.put("question","是否该买辆新车？");
        cv.put("answer","买,不买,再说");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",3);
        cv.put("resPic","choices3_pie");
        cv.put("question","周末去哪里玩？");
        cv.put("answer","本市,周边,家里呆");
        sqLiteDatabase.insert("LoadInfos",null,cv);
        cv.put("countsNum",3);
        cv.put("resPic","choices3_pie");
        cv.put("question","在哪里买房？");
        cv.put("answer","本市,周边,暂时不考虑");
        sqLiteDatabase.insert("LoadInfos",null,cv);//以上是3选1

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


//    public static ArrayMap<String,String[]> getLoadInfo(){
//        ArrayMap <String,String[]> load_Infos = new ArrayMap<>();
//        if(oneOfN == 2){
//            load_Infos.putAll(DEFAULT_MAP_2);
//        }else if(oneOfN == 3){
//            load_Infos.putAll(DEFAULT_MAP_3);
//        }else{
//            load_Infos.putAll(DEFAULT_MAP_2);
//            load_Infos.putAll(DEFAULT_MAP_3);
//        }
//        return load_Infos;
//    }
}
