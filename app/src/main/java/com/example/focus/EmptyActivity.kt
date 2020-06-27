package com.example.focus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_empty.*

class EmptyActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(TaskViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

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
                viewModel.insertTask(TaskModel(0,title,desc,false))
            }
        }
    }
}
