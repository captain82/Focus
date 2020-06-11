package com.example.focus

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private var database = AppDatabase.getDatabase(application)
    private val compositeDisposable = CompositeDisposable()
    val taskList:MutableLiveData<List<TaskModel>> = MutableLiveData()


    fun fetchTasks(){
        compositeDisposable.add(database!!.taskDao().query()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                taskList.value=it
            },{t-> Log.i("error" , t.localizedMessage)}))
    }

    fun insertTask(task:TaskModel){
        Completable.fromAction { database?.taskDao()
            ?.insertTask(task) }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun deleteTask(id: Int){
        Completable.fromAction { database?.taskDao()
            ?.deleteTask(id)}.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    sealed class TaskResponseAction {
        object Loading : TaskResponseAction()
        data class Success(val data: List<TaskModel>) : TaskResponseAction()
        data class Error(val error: String) : TaskResponseAction()
    }

}