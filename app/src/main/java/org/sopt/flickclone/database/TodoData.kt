package org.sopt.flickclone.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoData(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "createdAt") val createdAt: String,
    @ColumnInfo(name = "doneAt") val doneAt: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "isImportant") val isImportant: Boolean
)
