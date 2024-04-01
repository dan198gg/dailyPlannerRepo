package com.example.dailyplanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import android.widget.EditText

class UpdateActivity : AppCompatActivity() {
    lateinit var nameEdit: EditText
    lateinit var timeEdit: EditText
    lateinit var dayEdit: EditText
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        getExstraData()
        findViewById<Button>(R.id.buttonUpdate).setOnClickListener {
            var upper=MyDbManager(this)
            upper.updateDB(id.toString(),nameEdit.text.toString(),
                timeEdit.text.toString(),
                dayEdit.text.toString())
            upper.closeDB()
            finish()

        }
    }

    fun getExstraData() {
        nameEdit = findViewById(R.id.updateTextTask)
        timeEdit = findViewById(R.id.updateTextTime)
        dayEdit = findViewById(R.id.updateTextDay)
        if (intent.hasExtra("taskID")) {
            nameEdit.text = SpannableStringBuilder(intent.getStringExtra("taskName"))
            timeEdit.text = SpannableStringBuilder(intent.getStringExtra("taskTime"))
            dayEdit.text = SpannableStringBuilder(intent.getStringExtra("taskData"))
            id=intent.getIntExtra("taskID",0)
        }

    }


    }
