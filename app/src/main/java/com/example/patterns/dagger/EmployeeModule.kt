package com.example.patterns.dagger

import com.example.patterns.data.DeveloperDataSource
import com.example.patterns.data.EmployeeRepositoryImpl
import com.example.patterns.domain.EmployeeRepository
import dagger.Binds
import dagger.Module

@Module
interface EmployeeModule {

    @Binds
    fun bindEmployeeRepository(repository: EmployeeRepositoryImpl): EmployeeRepository

    @Binds
    fun bindDeveloperDataSource(dataSource: DeveloperDataSource): DeveloperDataSource
}