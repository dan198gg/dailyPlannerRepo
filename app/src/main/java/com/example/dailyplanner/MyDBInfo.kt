package com.example.dailyplanner

import android.provider.BaseColumns

object MyDBInfo:BaseColumns {
    const val TABLE_NAME="TasksTable"
    const val COLUMN_NAME_TASK="TaskName"
    const val COLUMN_TIME_TASK="TimeTask"
    const val COLUMN_DATE_TASK="DateTask"
    const val DB_NAME="TasksDB.db"
    const val DB_VER=1
    const val CREATE_DB=
        "CREATE TABLE IF NOT EXISTS ${TABLE_NAME}("+
                "${BaseColumns._ID} INTEGER PRIMARY KEY,"+
                "$COLUMN_NAME_TASK TEXT,"+
                "$COLUMN_TIME_TASK TEXT,"+
                "$COLUMN_DATE_TASK TEXT)"

}