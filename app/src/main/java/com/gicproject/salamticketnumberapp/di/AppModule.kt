package com.gicproject.salamticketnumberapp.di

import android.content.Context
import com.gicproject.salamticketnumberapp.common.Constants
import com.gicproject.emojisurveyapp.domain.repository.DataStoreRepository
import com.gicproject.salamticketnumberapp.data.remote.MyApi
import com.gicproject.salamticketnumberapp.data.repository.DataStoreRepositoryImpl
import com.gicproject.salamticketnumberapp.data.repository.MyRepositoryImpl
import com.gicproject.salamticketnumberapp.domain.repository.MyRepository
import com.gicproject.salamticketnumberapp.domain.use_case.GetBlinkCount
import com.gicproject.salamticketnumberapp.domain.use_case.GetCounterStatus
import com.gicproject.salamticketnumberapp.domain.use_case.GetLocations
import com.gicproject.salamticketnumberapp.domain.use_case.MyUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext app: Context
    ): DataStoreRepository = DataStoreRepositoryImpl(app)

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi): MyRepository {
        return MyRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideSurveyUseCases(
        repository: MyRepository,
        dataStoreRepository: DataStoreRepository
    ): MyUseCases {
        return MyUseCases(
            getLocations = GetLocations(repository = repository),
            getCounterStatus = GetCounterStatus(repository = repository),
            getBlinkCount = GetBlinkCount(repository = repository)
        )
    }
}