package com.example.patterns.presentation

import com.example.patterns.base.BasePresenter
import com.example.patterns.domain.GetDevelopersUseCase
import com.example.patterns.domain.factory.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val getDevelopersUseCase: GetDevelopersUseCase,
) : BasePresenter<MainView>() {

    fun loadEmployees() {
        val onSuccess: Consumer<List<Employee>> =
            Consumer { list ->
                view?.showEmployees(list)
            }

        getDevelopersUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(onSuccess)
            .addToDisposables()
    }
}