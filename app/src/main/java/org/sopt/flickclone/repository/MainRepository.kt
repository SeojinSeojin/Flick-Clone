package org.sopt.flickclone.repository

import androidx.paging.DataSource
import org.sopt.flickclone.model.TodoData

interface MainRepository {

    fun insertTodo(content: String)

    fun completeTodo(todo: TodoData)

    fun updateTodo(todo: TodoData, newContent: String)

    suspend fun deleteTodo(todo: TodoData)

    fun getFeedTodos(): DataSource.Factory<Int, TodoData>

    fun getHistoryTodos(): DataSource.Factory<Int, TodoData>

}