package com.example.patterns.data

import com.example.patterns.domain.EmployeeRepository
import com.example.patterns.domain.factory.Employee
import io.reactivex.Single
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(
    private val developerDataSource: DeveloperDataSource
) : EmployeeRepository {

    override fun getDevelopers(): Single<List<Employee>> =
        developerDataSource.getDevelopers()
}