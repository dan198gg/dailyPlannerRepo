package com.example.dailyplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
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