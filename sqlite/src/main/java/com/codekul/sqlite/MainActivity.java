package com.codekul.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();
    private DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper=new DbHelper(this,Db.DB_NAME,null,Db.DB_VERSION);
    }

    public void onInsert(View view){
        rawInsert();
    }

    public void onUpdate(View view){
        String table = Db.TabMy_Info.TAB_NAME;
        ContentValues values = new ContentValues();
        values.put(Db.TabMy_Info.COL_NAME,((EditText)findViewById(R.id.nameEt)).getText().toString());
        String whereClause = Db.TabMy_Info.COL_CARD_NUM  + " =? ";
        String[] whereArgs = {((EditText)findViewById(R.id.numberEt)).getText().toString()};

        SQLiteDatabase sqdb = helper.getWritableDatabase();
        int affected = sqdb.update(table,values,whereClause,whereArgs);
        sqdb.close();
    }

    public void onDelete(View view){
        String table = Db.TabMy_Info.TAB_NAME;
        String whereClause = Db.TabMy_Info.COL_CARD_NUM + " =? ";
        String[] whereArgs = {((EditText)findViewById(R.id.numberEt)).getText().toString()};

        SQLiteDatabase sqdb = helper.getWritableDatabase();
        sqdb.delete(table,whereClause,whereArgs);
        sqdb.close();
    }

    public void onQuery(View view){
       selectOne();
    }

    private void selectOne(){
        String table = Db.TabMy_Info.TAB_NAME;
        String[] columns = {Db.TabMy_Info.COL_NAME};
        String selection = Db.TabMy_Info.COL_CARD_NUM + " =? ";
        String[] selectionArgs ={((EditText)findViewById(R.id.numberEt)).getText().toString()};
        String groupBy = null;
        String having = null;
        String orderBy =null;

        SQLiteDatabase sqdb = helper.getReadableDatabase();
        Cursor cursor = sqdb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
        if (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(Db.TabMy_Info.COL_NAME));
            ((EditText)findViewById(R.id.nameEt)).setText(name);
            Log.i(TAG,"Name= "+name);

        }
        sqdb.close();
    }

    private void selectAll(){
        String table = Db.TabMy_Info.TAB_NAME;
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy =null;

        SQLiteDatabase sqdb = helper.getReadableDatabase();
        Cursor cursor = sqdb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(Db.TabMy_Info.COL_NAME));
            String cardnumber = cursor.getString(cursor.getColumnIndex(Db.TabMy_Info.COL_CARD_NUM));

            Log.i(TAG,"Name= "+name +" Card ="+cardnumber);

        }
        sqdb.close();
    }

    private void simpleInsert(){
        SQLiteDatabase sqdb =helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Db.TabMy_Info.COL_NAME,((EditText)findViewById(R.id.nameEt)).getText().toString());
        values.put(Db.TabMy_Info.COL_CARD_NUM,((EditText)findViewById(R.id.numberEt)).getText().toString());

        Long rowId = sqdb.insert(Db.TabMy_Info.TAB_NAME,null,values);
        Log.i(TAG,"RowId = "+rowId);
        sqdb.close();
    }

    private void rawInsert(){
        SQLiteDatabase sqdb = helper.getWritableDatabase();
        sqdb.execSQL("insert into "+Db.TabMy_Info.TAB_NAME +" values ('kivi' ,'1')");
        sqdb.close();
    }
}
