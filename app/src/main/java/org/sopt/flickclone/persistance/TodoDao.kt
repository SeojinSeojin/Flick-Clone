package org.sopt.flickclone.persistance

import androidx.paging.DataSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.sopt.flickclone.model.TodoData

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDo(todo: TodoData)

    @Update
    fun updateToDo(todo: TodoData)

    @Delete
    suspend fun deleteTodo(todo: TodoData)

    @Query("SELECT * FROM todo_table WHERE doneAt is NULL ORDER BY createdAt")
    fun getFeedToDos(): DataSource.Factory<Int, TodoData>

    @Query("SELECT * FROM todo_table WHERE doneAt is NOT NULL ORDER BY doneAt")
    fun getHistoryToDos(): DataSource.Factory<Int, TodoData>
}