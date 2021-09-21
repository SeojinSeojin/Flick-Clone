package org.sopt.flickclone.presentation

import org.sopt.flickclone.model.TodoData

interface TodoHandler {
    fun completeTodo(todoData: TodoData)
    fun updateTodo(todoData: TodoData, newContent: String)
    fun deleteTodo(todoData: TodoData)
}