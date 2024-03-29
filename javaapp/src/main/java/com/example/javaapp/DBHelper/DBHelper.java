package com.example.javaapp.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.javaapp.model.Category;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

//or mer sarqac bazayic ogtvinq
public class DBHelper extends SQLiteAssetHelper {
    //mer bazai hascene
    private static final String DB_NAME="EDMTQuiz2019.db";
    //mer bazai versione
    private static final int DB_VER=1;
    public static DBHelper instance;
    public static  synchronized DBHelper getInstance(Context context){
        if (instance==null)
instance=new DBHelper(context);
return instance;

    }
    public DBHelper(Context context) {
        super(context,DB_NAME,null, DB_VER);
    }
    //Get All Category
    public List<Category> getAllCategories(){
        SQLiteDatabase db=instance.getWritableDatabase();

        //SELECT column1, column2, ...
        //FROM table_name;
        Cursor cursor=db.rawQuery("SELECT *FROM Category;", null);
        List <Category> categories=new ArrayList<>();
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Category category=new Category(cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("Name")),
                        cursor.getString(cursor.getColumnIndex("Image")));
                categories.add(category);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return categories;
    }

}
