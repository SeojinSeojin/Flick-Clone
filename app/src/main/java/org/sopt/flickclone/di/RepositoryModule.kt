package org.sopt.flickclone.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.sopt.flickclone.repository.MainRepository
import org.sopt.flickclone.repository.MainRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository

}