package com.mandiri.test.di

import android.content.Context
import com.mandiri.core.base.BaseService
import com.mandiri.test.BuildConfig
import com.mandiri.test.config.GlobalConfig
import com.mandiri.test.domain.local.LocalDataSource
import com.mandiri.test.domain.remote.RemoteDataSource
import com.mandiri.test.domain.remote.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideService() = BaseService.createService(
        serviceClass = RemoteService::class.java,
        url = BuildConfig.SERVER_URL,
        isDebug = GlobalConfig.IS_DEBUG
    )

    @Singleton
    @Provides
    fun provideRemoteDataSource(service: RemoteService) = RemoteDataSource(service)

    /**
     * @param context Context of application
     */
    @Singleton
    @Provides
    fun provideLocalDataSource(@ApplicationContext context: Context) = LocalDataSource(context)
}