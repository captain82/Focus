package com.example.focus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
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
    private var id = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        if(intent.hasExtra(CONST.IS_EDIT)){
            isEdit = true
        }

        if(intent.hasExtra(CONST.TITLE)) title = intent.getStringExtra(CONST.TITLE)
        if(intent.hasExtra(CONST.DESC)) desc = intent.getStringExtra(CONST.DESC)
        if(intent.hasExtra(CONST.ID)) id = intent.getIntExtra(CONST.ID,-1)


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
            val title = titile.text.toString()
            val desc = description.text.toString()
            if(!isEdit && (titile.text.isNotBlank() or titile.text.isNotEmpty())){
                val randNum = (0..4).random()
                viewModel.insertTask(TaskModel(0,title,desc,randNum,false))
                onBackPressed()
            }else if(titile.text.isNotBlank() or titile.text.isNotEmpty())
            {
                viewModel.updateTask(title,desc,id)
            }

            if(titile.text.isNotBlank() or titile.text.isNotEmpty()){
                //Toast.makeText(this,"Title cannot be empty" , Toast.LENGTH_SHORT).show()
            }
        }

        deleteButton.setOnClickListener {
            viewModel.deleteTask(id)
            onBackPressed()
        }
    }

    private fun editTask(){

    }
}
