package com.example.patterns.domain.factory

abstract class EmployeeCreator {

    abstract fun createEmployee(name: String, age: Int): Employee
}

class DeveloperCreator : EmployeeCreator() {

    override fun createEmployee(name: String, age: Int): Employee =
            Developer(name, age)
}

class QaEngineerCreator : EmployeeCreator() {

    override fun createEmployee(name: String, age: Int): Employee =
            QaEngineer(name, age)
}