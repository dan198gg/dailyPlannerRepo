package com.example.dailyplanner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(context: Context,
                    tasksID:ArrayList<Int>,
                    tasks:ArrayList<String>,
                    tasksTime:ArrayList<String>,
                    tasksData:ArrayList<String>):
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
        var thisCon=context
        var taskID=tasksID
        var task=tasks
        var taskTime=tasksTime
        var taskData=tasksData
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    lateinit var taskName:TextView
    lateinit var taskTime:TextView
    lateinit var taskData:TextView
    init {
        taskName=itemView.findViewById(R.id.textTaskName)
        taskTime=itemView.findViewById(R.id.textTime)
        taskData=itemView.findViewById(R.id.textData)
    }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater:LayoutInflater=LayoutInflater.from(thisCon)
        var view:View=inflater.inflate(R.layout.task_row,parent,false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }
}