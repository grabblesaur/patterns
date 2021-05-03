package com.example.patterns.presentation

import com.example.patterns.base.BaseView
import com.example.patterns.domain.factory.Employee

interface MainView : BaseView {

    fun showEmployees(list: List<Employee>)
}
