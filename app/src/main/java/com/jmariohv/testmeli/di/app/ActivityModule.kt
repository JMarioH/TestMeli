package com.jmariohv.testmeli.di.app

import com.jmariohv.testmeli.modules.search.domain.SearchRepoImpl
import com.jmariohv.testmeli.modules.search.domain.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun provideSearchRepository(searchRepoImpl: SearchRepoImpl) : SearchRepository

}