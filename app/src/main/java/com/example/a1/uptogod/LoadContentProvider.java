package com.example.a1.uptogod;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by 1 on 2017/5/6.
 */

public class LoadContentProvider extends ContentProvider {

    public static  final  Uri URI = Uri.parse("content://sally.loadInfoContentProvider");
    LoadInfoSQLiteHelper loadInfoSQLiteHelper;

    @Override
    public boolean onCreate() {
        loadInfoSQLiteHelper = new LoadInfoSQLiteHelper(getContext(),"loadInfo", null, 1);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String orderBy) {
        Cursor cursor = loadInfoSQLiteHelper.getWritableDatabase().query("LoadInfos",projection,selection,selectionArgs,null,null,orderBy);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);//设置对所有注册在此Uri的监听器
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        loadInfoSQLiteHelper.getWritableDatabase().insert("LoadInfos",null,contentValues);
        getContext().getContentResolver().notifyChange(uri,null);//通知所有挂在此Uri上的Cursor重新query。
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        loadInfoSQLiteHelper.getWritableDatabase().delete("LoadInfos",s,strings);
        getContext().getContentResolver().notifyChange(uri,null);//通知所有挂在此Uri上的Cursor重新query。
        return  loadInfoSQLiteHelper.getWritableDatabase().delete("LoadInfos",s,strings);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) { //修改的情况
        loadInfoSQLiteHelper.getWritableDatabase().update("LoadInfos",contentValues,s,strings);
        getContext().getContentResolver().notifyChange(uri,null);//通知所有挂在此Uri上的Cursor重新query。
        return loadInfoSQLiteHelper.getWritableDatabase().update("LoadInfos",contentValues,s,strings);
    }
}
