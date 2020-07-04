package com.example.focus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_recycler_item.view.*

class RecyclerViewAdapter:RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    lateinit var context: Context

    private var taskList:MutableList<TaskModel> = mutableListOf()

    private lateinit var cardThemeBackground:IntArray
    private lateinit var cardThemeDark:IntArray
    private lateinit var cardThemeLight:IntArray

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        initializeColors()
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_recycler_item,parent,false))
    }

    private fun initializeColors() {
        cardThemeBackground = context.resources.getIntArray(R.array.cardThemeBackground)
        cardThemeDark = context.resources.getIntArray(R.array.cardThemeDark)
        cardThemeLight = context.resources.getIntArray(R.array.cardThemeLight)
    }

    override fun getItemCount(): Int = taskList.size

    fun setData(list:MutableList<TaskModel>){
        taskList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if(taskList[position].description.isEmpty() || taskList[position].description.isBlank()){
            holder.itemView.descTextView.visibility = View.GONE
        }
        holder.itemView.taskTitle.text = taskList[position].title
        holder.itemView.descTextView.text = taskList[position].description

        holder.itemView.sleekBar.setBackgroundColor(cardThemeLight[taskList[position].themeNumber])

        /*holder.itemView.cardView.setCardBackgroundColor(cardThemeBackground[taskList[position].themeNumber])
        holder.itemView.taskTitle.setTextColor(cardThemeDark[taskList[position].themeNumber])
        holder.itemView.descTextView.setTextColor(cardThemeLight[taskList[position].themeNumber])*/

        holder.itemView.cardView.setOnClickListener {
            val intent = Intent(context,EmptyActivity::class.java)
            intent.putExtra(CONST.TITLE,taskList[position].title)
            intent.putExtra(CONST.DESC,taskList[position].description)
            intent.putExtra(CONST.IS_EDIT,true)
            startActivity(context,intent,null)
        }

    }

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){

    }

}