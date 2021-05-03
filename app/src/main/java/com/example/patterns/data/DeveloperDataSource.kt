package com.example.patterns.data

import com.example.patterns.domain.factory.DeveloperCreator
import com.example.patterns.domain.factory.Employee
import com.example.patterns.getRandomAge
import com.example.patterns.getRandomName
import com.example.patterns.getRandomNumber
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DeveloperDataSource @Inject constructor(
    private val developerCreator: DeveloperCreator
) {
    fun getDevelopers(): Single<List<Employee>> =
        Single.fromCallable {
            val developers = mutableListOf<Employee>()
            val number = getRandomNumber()

            for (i in 1..number) {
                developers.add(
                    developerCreator.createEmployee(getRandomName(), getRandomAge())
                )
            }

            developers.toList()
        }
            .subscribeOn(Schedulers.io())
}