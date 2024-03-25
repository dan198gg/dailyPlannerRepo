package com.example.dailyplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            var textTask=findViewById<EditText>(R.id.editTextTask).text.toString()
            var textTime=findViewById<EditText>(R.id.editTextTime).text.toString()
            var textDay=findViewById<EditText>(R.id.editTextDay).text.toString()
            var db=MyDbManager(context=this)
            db.insertDb(textTask,textTime,textDay)
            val intentToMain=Intent(this,MainActivity::class.java)
            startActivity(intentToMain)
            finish()
        }
    }
}