package org.sopt.flickclone.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import org.sopt.flickclone.persistance.AppDataBase
import org.sopt.flickclone.persistance.TodoDao

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context
    ): AppDataBase {
        return Room
            .databaseBuilder(appContext, AppDataBase::class.java, "todo_table.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDataBase): TodoDao {
        return appDatabase.todoDao()
    }
}