package com.example.dailyplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var dbManager:MyDbManager
    lateinit var taskName:ArrayList<String>
    lateinit var taskTime:ArrayList<String>
    lateinit var taskDay:ArrayList<String>
    lateinit var taskID:ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbManager= MyDbManager(this)
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            dbManager.clearDB()
            Toast.makeText(this,"Очищено", Toast.LENGTH_LONG).show()
            getRecycler()
        }
        findViewById<FloatingActionButton>(R.id.floatingActionButton2).setOnClickListener{
            val intentAdd=Intent(this,AddTaskActivity::class.java)
            startActivity(intentAdd)
        }

        getRecycler()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            getRecycler()
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
                taskID.add(cursor.getInt(0))
            }
            println()
        }
    }
    fun getRecycler(){
        getData()
        var recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        var customAdapter=CustomAdapter(this@MainActivity,this,taskID,taskName,taskTime,taskDay)
        recyclerView.adapter=customAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}
