package org.sopt.flickclone.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.WorkerThread
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.persistance.TodoDao
import java.sql.Date
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject

class MainRepository @Inject constructor(private val todoDao: TodoDao) : Repository {
    @RequiresApi(Build.VERSION_CODES.O)
    @WorkerThread
    suspend fun insertTodo(content: String) {
        todoDao.insertToDos(
            TodoData(
                createdAt = Date.from(
                    LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()
                ),
                content = content
            )
        )
    }
}