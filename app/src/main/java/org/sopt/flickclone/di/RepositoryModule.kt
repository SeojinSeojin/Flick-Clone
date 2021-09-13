package org.sopt.flickclone.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.sopt.flickclone.persistance.TodoDao
import org.sopt.flickclone.repository.MainRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(todoDao: TodoDao): MainRepository {
        return MainRepository(todoDao)
    }

}