package com.example.dailyplanner

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context):SQLiteOpenHelper(context,MyDBInfo.DB_NAME,null,MyDBInfo.DB_VER) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db!=null){
            db.execSQL(MyDBInfo.CREATE_DB)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}