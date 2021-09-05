package org.sopt.flickclone.persistance

import androidx.room.TypeConverter
import java.util.*

class DateLongTypeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}