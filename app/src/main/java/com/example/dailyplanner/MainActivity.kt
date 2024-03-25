package com.example.dailyplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var dbManager:MyDbManager
    lateinit var taskName:ArrayList<String>
    lateinit var taskTime:ArrayList<String>
    lateinit var taskDay:ArrayList<String>
    lateinit var taskID:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbManager= MyDbManager(this)
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            dbManager.clearDB()
            Toast.makeText(this,"Очищено", Toast.LENGTH_LONG).show()
        }
        findViewById<FloatingActionButton>(R.id.floatingActionButton2).setOnClickListener{
            val intentAdd=Intent(this,AddTaskActivity::class.java)
            startActivity(intentAdd)
        }
        getData()
    }
    fun getData() {
        val cursor = dbManager.readDB()
        taskName= ArrayList()
        taskTime= ArrayList()
        taskDay= ArrayList()
        taskID= ArrayList()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                taskName.add(cursor.getString(1))
                taskTime.add(cursor.getString(2))
                taskDay.add(cursor.getString(3))
                taskID.add(cursor.getString(0))
            }
            println()
        }
    }
}
