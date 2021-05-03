package com.example.patterns.domain

import com.example.patterns.domain.factory.Employee
import io.reactivex.Single

interface EmployeeRepository {

    fun getDevelopers(): Single<List<Employee>>
}