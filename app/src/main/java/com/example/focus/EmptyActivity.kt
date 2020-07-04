package com.example.focus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_empty.*

class EmptyActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(TaskViewModel::class.java)
    }

    private lateinit var title:String
    private lateinit var desc:String
    private var isEdit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        if(intent.hasExtra(CONST.IS_EDIT)){
            isEdit = true
        }

        if(intent.hasExtra(CONST.TITLE)) title = intent.getStringExtra(CONST.TITLE)
        if(intent.hasExtra(CONST.DESC)) desc = intent.getStringExtra(CONST.DESC)

        if(isEdit){
            titile.setText(title)
            description.setText(desc)
            heading.setText("Edit Task")
        }else{
            deleteButton.visibility = View.GONE
            val layoutParams = doneButton.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.setMargins(0,CONST.convertDpToPixels(20F,this),
                0,0)
            doneButton.layoutParams = layoutParams
        }


        closeButton.setOnClickListener {
            //finishAndRemoveTask()
            onBackPressed()
        }

        root.setOnClickListener {
            onBackPressed()
        }

        doneButton.setOnClickListener {
            if(titile.text.isNotBlank() or titile.text.isNotEmpty()){
                val title = titile.text.toString()
                val desc = description.text.toString()
                val randNum = (0..4).random()
                viewModel.insertTask(TaskModel(0,title,desc,randNum,false))
                onBackPressed()
            }
        }
    }
}
