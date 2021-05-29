package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "database";
    private static final String TABLE_NAME= "Userdata.db";


     DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
         String createTable = "create table " + TABLE_NAME +"(id INTEGER PRIMARY KEY,txt TEXT)";
        DB.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(DB);

    }

    public boolean addtext(String category){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put("firstName",fName);
//        contentValues.put("lastName",lName);
//        contentValues.put("number",mobileNum);
//        contentValues.put("email",email);
        contentValues.put("category",category);
        DB.insert(TABLE_NAME,null,contentValues);
        return  true;
//        if(result == -1){
//            return  false;
//        }else{
//            return true;
//        }

    }



//    public Boolean updateuserdata(String fName,String lName,Integer mobileNum,String email,String category){
//        SQLiteDatabase DB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("firstName",fName);
//        Cursor cursor = DB.rawQuery("Select * from Userdetails where name =?",new String[] {fName});
//        if(cursor.getCount()>0) {
//            long result = DB.insert("Userdetails", contentValues, "name =?", new String[]{fName});
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }else{
//            return false;
//            }
//
//    }

//    public Cursor getdata(){
//        SQLiteDatabase DB = this.getWritableDatabase();
//        Cursor cursor =DB.rawQuery("Select * from Userdetails",new String[]{});
//        return cursor;
//
//    }

    public ArrayList getAllText(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList= new ArrayList<String>();
        Cursor cursor =sqLiteDatabase.rawQuery("Select * from " +TABLE_NAME,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("category")));
            cursor.moveToNext();
        }
        return arrayList;

    }


}
