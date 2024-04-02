package com.example.dailyplanner

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    var activity: MainActivity,
    val context: Context,
    var tasksID:ArrayList<Int>,
    var tasks:ArrayList<String>,
    var tasksTime:ArrayList<String>,
    var tasksData:ArrayList<String>):
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var taskName: TextView
        lateinit var taskTime: TextView
        lateinit var taskData: TextView
        var translateAnim:Animation
        var layoutTask: ConstraintLayout

        init {
            taskName = itemView.findViewById(R.id.textTaskName)
            taskTime = itemView.findViewById(R.id.textTime)
            layoutTask = itemView.findViewById(R.id.rowLayout)
            taskData = itemView.findViewById(R.id.textData)
            translateAnim=AnimationUtils.loadAnimation(context,R.anim.translate_anim)
            layoutTask.animation=translateAnim
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(context)
        var view: View = inflater.inflate(R.layout.task_row, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.taskName.text = tasks[position]
        holder.taskTime.text = tasksTime[position]
        holder.taskData.text = tasksData[position]
        holder.layoutTask.setOnClickListener {
            var intent1 = Intent(context, UpdateActivity::class.java)
            intent1.putExtra("taskID",tasksID[position])
            intent1.putExtra("taskName",tasks[position])
            intent1.putExtra("taskData",tasksData[position])
            intent1.putExtra("taskTime",tasksTime[position])
            activity.startActivityForResult(intent1,1)

        }
    }
}

