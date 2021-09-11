package org.sopt.flickclone.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.sopt.flickclone.model.TodoData

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDo(todo: TodoData)

    @Query("SELECT * FROM todo_table WHERE doneAt is NULL ORDER BY createdAt")
    fun getFeedToDos(): Flow<List<TodoData>>

    @Query("SELECT * FROM todo_table WHERE doneAt is NOT NULL ORDER BY doneAt")
    fun getHistoryToDos(): Flow<List<TodoData>>
}