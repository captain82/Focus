package com.example.focus

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: TaskModel)

    @Query("SELECT * FROM `taskmodel`")
    fun query(): Observable<List<TaskModel>>

    @Query("DELETE FROM `taskmodel` WHERE id LIKE :id")
    fun deleteTask(id: Int)
}