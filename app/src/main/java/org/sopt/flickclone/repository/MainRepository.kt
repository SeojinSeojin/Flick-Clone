package org.sopt.flickclone.repository

import kotlinx.coroutines.flow.Flow
import org.sopt.flickclone.model.TodoData

interface MainRepository {

    fun insertTodo(content: String)

    fun completeTodo(todo: TodoData)

    fun updateTodo(todo: TodoData, newContent: String)

    fun deleteTodo(todo: TodoData)

    fun getFeedTodos(): Flow<List<TodoData>>

    fun getHistoryTodos(): Flow<List<TodoData>>

}