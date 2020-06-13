package com.example.focus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_recycler_item.view.*

class RecyclerViewAdapter:RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_recycler_item,parent,false))
    }

    override fun getItemCount(): Int = 6

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (position==0)holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.blueBackground))
        if (position==1)holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.orangeBackground))
        if (position==2)holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.greenBackground))
        if (position==3)holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.greyBackground))
        if (position==4)holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.redBackground))
        if (position==5)holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.blueBackground))
        if (position==6)holder.itemView.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.greenBackground))

        if (position==0)holder.itemView.sleekBar.setBackgroundColor(ContextCompat.getColor(context,R.color.darkBlue))
        if (position==1)holder.itemView.sleekBar.setBackgroundColor(ContextCompat.getColor(context,R.color.darkOrange))
        if (position==2)holder.itemView.sleekBar.setBackgroundColor(ContextCompat.getColor(context,R.color.darkGreen))
        if (position==3)holder.itemView.sleekBar.setBackgroundColor(ContextCompat.getColor(context,R.color.darkGrey))
        if (position==4)holder.itemView.sleekBar.setBackgroundColor(ContextCompat.getColor(context,R.color.darkRed))
        if (position==5)holder.itemView.sleekBar.setBackgroundColor(ContextCompat.getColor(context,R.color.darkBlue))
        if (position==6)holder.itemView.sleekBar.setBackgroundColor(ContextCompat.getColor(context,R.color.darkGreen))

        if (position==0)holder.itemView.taskTitle.setTextColor(ContextCompat.getColor(context,R.color.darkBlue))
        if (position==1)holder.itemView.taskTitle.setTextColor(ContextCompat.getColor(context,R.color.darkOrange))
        if (position==2)holder.itemView.taskTitle.setTextColor(ContextCompat.getColor(context,R.color.darkGreen))
        if (position==3)holder.itemView.taskTitle.setTextColor(ContextCompat.getColor(context,R.color.darkGrey))
        if (position==4)holder.itemView.taskTitle.setTextColor(ContextCompat.getColor(context,R.color.darkRed))
        if (position==5)holder.itemView.taskTitle.setTextColor(ContextCompat.getColor(context,R.color.darkBlue))
        if (position==6)holder.itemView.taskTitle.setTextColor(ContextCompat.getColor(context,R.color.darkGreen))

        if (position==0)holder.itemView.descTextView.text = "Is there a way to make CardView only have corner radius at the top?"
        if (position==1)holder.itemView.descTextView.text = "Unless you try to extend the Android CardView class, you cannot customize that attribute from XML.Place a CardView inside another CardView and apply a transparent background to your outer CardView and remove its corner radius (\"cornerRadios = 0dp\"). Your inner CardView will have a cornerRadius value of 3dp, for example. "
        if (position==2)holder.itemView.descTextView.text = "Then apply a marginTop to your inner CardView, so its bottom bounds will be cut by the outer CardView. This way, the bottom corner radius of your inner CardView will be hidden."
        if (position==3)holder.itemView.descTextView.visibility = View.GONE
        if (position==4)holder.itemView.descTextView.text = "We think data protection is important! No data is sent. The magic happens in your browser."
        if (position==5)holder.itemView.descTextView.text = "Is there a way to make CardView only have corner radius at the top?"
        if (position==6)holder.itemView.descTextView.visibility = View.GONE

        if (position==0)holder.itemView.descTextView.setTextColor(ContextCompat.getColor(context,R.color.lightBlue))
        if (position==2)holder.itemView.descTextView.setTextColor(ContextCompat.getColor(context,R.color.greenlight))
        if (position==1)holder.itemView.descTextView.setTextColor(ContextCompat.getColor(context,R.color.lightOrange))

    }

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view)

}