package com.example.focus

import androidx.room.*
import io.reactivex.Observable

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: TaskModel)

    @Query("UPDATE taskmodel SET title = :title,description = :desc WHERE id=:id")
    fun updateTask(title: String, desc: String, id: Int)

    @Query("UPDATE taskmodel SET isCompleted = :isCompleted WHERE id=:id")
    fun updateChecker(isCompleted: Boolean, id: Int)

    @Query("SELECT * FROM `taskmodel`")
    fun query(): Observable<List<TaskModel>>

    @Query("DELETE FROM `taskmodel` WHERE id LIKE :id")
    fun deleteTask(id: Int)
}