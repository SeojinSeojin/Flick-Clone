package org.sopt.flickclone.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.sopt.flickclone.model.TodoData

@Database(entities = [TodoData::class], version = 0, exportSchema = true)
@TypeConverters(DateLongTypeConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}