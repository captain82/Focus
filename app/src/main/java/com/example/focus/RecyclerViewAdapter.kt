package com.example.focus

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_recycler_item.view.*

class RecyclerViewAdapter(val markChecked:(Boolean,Int)->Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    lateinit var context: Context

    private var taskList: MutableList<TaskModel> = mutableListOf()

    private lateinit var cardThemeBackground: IntArray
    private lateinit var cardThemeDark: IntArray
    private lateinit var cardThemeLight: IntArray

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        initializeColors()
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_recycler_item, parent, false)
        )
    }

    private fun initializeColors() {
        cardThemeBackground = context.resources.getIntArray(R.array.cardThemeBackground)
        cardThemeDark = context.resources.getIntArray(R.array.cardThemeDark)
        cardThemeLight = context.resources.getIntArray(R.array.cardThemeLight)
    }

    override fun getItemCount(): Int = taskList.size

    fun setData(list: MutableList<TaskModel>) {
        taskList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if (taskList[position].description.isEmpty() || taskList[position].description.isBlank()) {
            holder.itemView.descTextView.visibility = View.GONE
        } else {
            holder.itemView.descTextView.visibility = View.VISIBLE

        }
        holder.itemView.taskTitle.text = taskList[position].title
        holder.itemView.descTextView.text = taskList[position].description

        holder.itemView.sleekBar.setBackgroundColor(cardThemeDark[taskList[position].themeNumber])

        holder.itemView.radioButtonChecked.visibility =
            if (taskList[position].isCompleted) View.VISIBLE else View.GONE

        holder.itemView.radioButtonChecked.setOnClickListener {
            markChecked.invoke(false,taskList[position].id)
        }

        holder.itemView.radioButton.setOnClickListener {
            markChecked.invoke(true,taskList[position].id)
        }

        if(taskList[position].isCompleted){
            holder.itemView.taskTitle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG.inc()
            holder.itemView.descTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG.inc()
        }else
        {


            holder.itemView.taskTitle.paintFlags = holder.itemView.taskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            holder.itemView.descTextView.paintFlags = holder.itemView.taskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()


        }

        holder.itemView.taskTitle.setOnClickListener {
            val intent = Intent(context, EmptyActivity::class.java)
            intent.putExtra(CONST.TITLE, taskList[position].title)
            intent.putExtra(CONST.DESC, taskList[position].description)
            intent.putExtra(CONST.IS_EDIT, true)
            intent.putExtra(CONST.ID, taskList[position].id)

            startActivity(context, intent, null)
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}