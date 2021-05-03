package com.example.patterns.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.patterns.R
import com.example.patterns.dagger.App
import com.example.patterns.domain.factory.DeveloperCreator
import com.example.patterns.domain.factory.Employee
import com.example.patterns.domain.factory.EmployeeCreator
import com.example.patterns.domain.factory.QaEngineerCreator
import com.example.patterns.presentation.MainPresenter
import com.github.javafaker.Faker
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val team: MutableList<Employee> = mutableListOf()

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.poof()
        initViews()
    }

    private fun initViews() {

        createTeamButton.setOnClickListener {
            createDevelopers()
            createQaEngineers()
        }

        workSlavesButton.setOnClickListener {
            if (team.isEmpty()) {
                Log.i("TAG", "MainActivity: team is empty")
            } else {
                team.forEach {
                    Log.i("TAG", "MainActivity: ${it.name} ${it.age}")
                    it.doWork()
                }
            }
        }
    }

    private fun createDevelopers() {
        val employeeCreator = DeveloperCreator()
        val number = getRandomNumber()

        createEmployees(employeeCreator, number)
    }

    private fun createQaEngineers() {
        val qaEngineerCreator = QaEngineerCreator()
        val number = getRandomNumber()

        createEmployees(qaEngineerCreator, number)
    }

    private fun createEmployees(creator: EmployeeCreator, count: Int) {
        for (i in 1..count) {
            val employee = creator.createEmployee(name = getRandomName(), age = getRandomAge())
            team.add(employee)
        }
    }

    private fun getRandomName(): String =
        Faker().funnyName().name()

    private fun getRandomAge(): Int =
        Faker().number().numberBetween(18, 99)

    private fun getRandomNumber(): Int =
        Faker().number().numberBetween(1, 100)
}