package com.example.al_madaris;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "student.db";
    private static String TABLE_NAME = "student";

    private static String COLUMN_ID = "id";
    private static String COLUMN_NAME = "name";
    private static String COLUMN_ROLLNO = "rollno";
    private static String COLUMN_FATHER_CONTACT = "father_contact";
    private static String COLUMN_PARANO = "parano";
    private static String COLUMN_AYAT_FROM = "ayat_from";
    private static String COLUMN_AYAT_TO = "ayat_to";
    private static String COLUMN_SABKI = "sabki";
    private static String COLUMN_MANZIL = "manzil";

    public DBHandler(@Nullable Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME+" ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ROLLNO + " TEXT, " +
                COLUMN_FATHER_CONTACT + " TEXT, " +
                COLUMN_PARANO + " TEXT, " +
                COLUMN_AYAT_FROM + " TEXT, " +
                COLUMN_AYAT_TO + " TEXT, " +
                COLUMN_SABKI + " TEXT, " +
                COLUMN_MANZIL + " TEXT );";

        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+ TABLE_NAME ;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(Student s)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(COLUMN_NAME, s.getName());
        value.put(COLUMN_ROLLNO, s.getRollno());
        value.put(COLUMN_FATHER_CONTACT, s.getFather_contact());
        value.put(COLUMN_PARANO, s.getParano());
        value.put(COLUMN_AYAT_FROM, s.getAyatfrom());
        value.put(COLUMN_AYAT_TO, s.getAyatto());
        value.put(COLUMN_SABKI, s.getSabki());
        value.put(COLUMN_MANZIL, s.getManzil());

        db.insert(TABLE_NAME, null, value);

        db.close();

    }
    // on edit buttion update those student data

//    public void updateStudent(String parano,String ayatfrom , String ayatto,String sabki , String manzil)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues value = new ContentValues();
//        value.put(COLUMN_PARANO, parano.getParano());
//        value.put(COLUMN_AYAT_FROM, ayatfrom.getAyatfrom());
//        value.put(COLUMN_AYAT_TO, ayatto.getAyatto());
//        value.put(COLUMN_SABKI, sabki.getSabki());
//        value.put(COLUMN_MANZIL, manzil.getManzil());
//
//        db.insert(TABLE_NAME, null, value);
//
//        db.close();
//
//    }
//
    public void deleteStudent(String rollno)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ROLLNO + " = '" + rollno + "'";
        // on below line we are creating
        // a variable to write our database.

        DB.execSQL(sql);
    }

     //get data from db;

    public List<Student > getStudentRecord(){
        List<Student> stuData = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst())
        {
            do{
                @SuppressLint("Range") String Stuid = cursor.getString(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") String rollno = cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNO));
                @SuppressLint("Range") String para = cursor.getString(cursor.getColumnIndex(COLUMN_PARANO));
                @SuppressLint("Range") String ayatfrom = cursor.getString(cursor.getColumnIndex(COLUMN_AYAT_FROM));
                @SuppressLint("Range") String ayatto = cursor.getString(cursor.getColumnIndex(COLUMN_AYAT_TO));
                @SuppressLint("Range") String sabki = cursor.getString(cursor.getColumnIndex(COLUMN_SABKI));
                @SuppressLint("Range") String manzil = cursor.getString(cursor.getColumnIndex(COLUMN_MANZIL));
                @SuppressLint("Range") String contact = cursor.getString(cursor.getColumnIndex(COLUMN_FATHER_CONTACT));

                stuData.add(new Student(name,rollno ,contact, para, ayatfrom, ayatto, sabki, manzil));

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return stuData;
    }

}
