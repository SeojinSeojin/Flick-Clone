package org.sopt.flickclone.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo_table")
data class TodoData(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "createdAt") val createdAt: Long,
    @ColumnInfo(name = "doneAt") var doneAt: Long? = null,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "isImportant") var isImportant: Boolean = false
)
