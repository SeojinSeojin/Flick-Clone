package org.sopt.flickclone.repository

import kotlinx.coroutines.flow.Flow
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.persistance.TodoDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val todoDao: TodoDao
) : Repository {

    fun insertTodo(content: String) {
        todoDao.insertToDo(
            TodoData(
                createdAt = System.currentTimeMillis(),
                content = content
            )
        )
    }

    val feedTodos: Flow<List<TodoData>> = todoDao.getFeedToDos()
    val historyTodos: Flow<List<TodoData>> = todoDao.getHistoryToDos()

}