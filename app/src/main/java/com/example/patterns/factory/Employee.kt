package com.example.patterns.factory

import android.util.Log

abstract class Employee(
        private val name: String,
        private val age: Int
) {

    abstract fun doLunch()

    abstract fun doWork()

    override fun toString(): String =
        "Employee(name='$name', age=$age)"
}

class QaEngineer(name: String, age: Int) : Employee(name, age) {

    override fun doLunch() {
        Log.i("TAG", "QaEngineer: doLunch")
    }

    override fun doWork() {
        Log.i("TAG", "QaEngineer: doWork")
    }
}

class Developer(name: String, age: Int) : Employee(name, age) {

    override fun doLunch() {
        Log.i("TAG", "Developer: doLunch")
    }

    override fun doWork() {
        Log.i("TAG", "Developer: doWork")
    }
}