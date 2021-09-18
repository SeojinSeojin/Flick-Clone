package org.sopt.flickclone.repository

import kotlinx.coroutines.flow.Flow
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.persistance.TodoDao
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : MainRepository {

    override fun insertTodo(content: String) {
        todoDao.insertToDo(
            TodoData(
                createdAt = System.currentTimeMillis(),
                content = content
            )
        )
    }

    override fun completeTodo(todo: TodoData) {
        todo.doneAt = System.currentTimeMillis()
        todoDao.updateToDo(todo)
    }

    override fun updateTodo(todo: TodoData, newContent: String) {
        todo.content = newContent
        todoDao.updateToDo(todo)
    }

    override suspend fun deleteTodo(todo: TodoData) {
        todoDao.deleteTodo(todo)
    }

    override fun getFeedTodos(): Flow<List<TodoData>> = todoDao.getFeedToDos()

    override fun getHistoryTodos(): Flow<List<TodoData>> = todoDao.getHistoryToDos()

}