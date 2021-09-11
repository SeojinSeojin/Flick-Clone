package org.sopt.flickclone.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import org.sopt.flickclone.model.TodoData

@Database(entities = [TodoData::class], version = 1, exportSchema = true)
abstract class AppDataBase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}