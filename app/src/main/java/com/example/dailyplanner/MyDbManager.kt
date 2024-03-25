package com.example.dailyplanner

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import kotlinx.coroutines.currentCoroutineContext

class MyDbManager(context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDB() {
        db = myDbHelper.writableDatabase
    }

    fun insertDb(task: String, time: String, data: String) {
        openDB()
        val values = ContentValues().apply {
            put(MyDBInfo.COLUMN_NAME_TASK, task)
            put(MyDBInfo.COLUMN_TIME_TASK, time)
            put(MyDBInfo.COLUMN_DATE_TASK, data)
        }
        db?.insert(MyDBInfo.TABLE_NAME, null, values)
        closeDB()
    }

    fun readDB(): Cursor? {
        var query: String = "SELECT * FROM ${MyDBInfo.TABLE_NAME}"
        db = myDbHelper.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db?.rawQuery(query, null)
        }
        return cursor
//        .query(MyDBInfo.TABLE_NAME, null, null, null,null,null,null)
    }

    fun clearDB(): Int {

        /* returns # of rows deleted (would be 1 or 0 if id is primary key) */
        return db!!.delete(MyDBInfo.TABLE_NAME, null, null)

    }


    fun closeDB() {
        myDbHelper.close()
    }
}

