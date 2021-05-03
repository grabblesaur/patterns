package com.example.patterns.dagger

import com.example.patterns.domain.GetDevelopersUseCase
import com.example.patterns.domain.factory.DeveloperCreator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [EmployeeModule::class])
interface MainActivityModule {

    companion object {

        @Provides
        fun provideDeveloperCreator(): DeveloperCreator =
            DeveloperCreator()
    }

    @Binds
    @Reusable
    fun provideGetDevelopersUseCase(useCase: GetDevelopersUseCase): GetDevelopersUseCase
}