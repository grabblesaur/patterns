package com.example.patterns.ui

import android.os.Bundle
import android.widget.Toast
import com.example.patterns.R
import com.example.patterns.base.BaseActivity
import com.example.patterns.dagger.App
import com.example.patterns.domain.factory.Employee
import com.example.patterns.presentation.MainPresenter
import com.example.patterns.presentation.MainView
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadEmployees()
    }

    override fun showEmployees(list: List<Employee>) {
        Toast.makeText(this, list.toString(), Toast.LENGTH_SHORT).show()
    }
}