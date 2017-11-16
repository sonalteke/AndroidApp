package com.codekul.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sonal on 16/11/17.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Db.TabMy_Info.TAB_NAME+" ("+Db.TabMy_Info.COL_NAME+" text,"+Db.TabMy_Info.COL_CARD_NUM+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
