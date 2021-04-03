package com.example.patterns

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.patterns.factory.DeveloperCreator
import com.example.patterns.factory.Employee
import com.example.patterns.factory.QaEngineerCreator
import com.github.javafaker.Faker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val developers: MutableList<Employee> = mutableListOf()
    private val qaEngineers: MutableList<Employee> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        createTeamButton.setOnClickListener {
            createDevelopers()
            createQaEngineers()
        }

        workSlavesButton.setOnClickListener {
            if (developers.isEmpty() && qaEngineers.isEmpty()) {
                Log.i("TAG", "MainActivity: maybe its a weekend")
            } else {
                developers.forEach {
                    Log.i("TAG", "MainActivity: $it")
                }
                qaEngineers.forEach {
                    Log.i("TAG", "MainActivity: $it")
                }
            }
        }
    }

    private fun createDevelopers() {
        val employeeCreator = DeveloperCreator()
        val number = getRandomNumber()

        for (i in 1..number) {
            developers.add(
                employeeCreator.createEmployee(
                    name = getRandomName(),
                    age = getRandomAge()
                )
            )
        }
    }

    private fun createQaEngineers() {
        val qaEngineerCreator = QaEngineerCreator()
        val number = getRandomNumber()

        for (i in 1..number) {
            qaEngineers.add(
                qaEngineerCreator.createEmployee(
                    name = getRandomName(),
                    age = getRandomAge()
                )
            )
        }
    }

    private fun getRandomName(): String =
        Faker().funnyName().name()

    private fun getRandomAge(): Int =
        Faker().number().numberBetween(18, 99)

    private fun getRandomNumber(): Int =
        Faker().number().numberBetween(1, 100)
}