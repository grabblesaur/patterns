package com.example.patterns.domain

import com.example.patterns.domain.factory.Employee
import io.reactivex.Single
import javax.inject.Inject

class GetDevelopersUseCase @Inject constructor(
    private val employeeRepository: EmployeeRepository
) {

    operator fun invoke(): Single<List<Employee>> =
        employeeRepository.getDevelopers()
}