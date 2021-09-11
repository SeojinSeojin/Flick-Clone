package org.sopt.flickclone.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.persistance.TodoDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val todoDao: TodoDao,
    private val ioDispatcher: CoroutineDispatcher
) : Repository {

    @WorkerThread
    fun insertTodo(content: String) {
        todoDao.insertToDo(
            TodoData(
                createdAt = System.currentTimeMillis(),
                content = content
            )
        )
    }

    @WorkerThread
    suspend fun getFeedToDos() = flow {
        val todos = todoDao.getFeedToDos()
        emit(todos)
    }.flowOn(ioDispatcher)
}