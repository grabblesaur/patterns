package com.example.patterns.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BasePresenter<T : BaseView> protected constructor() {

    private val compositeDisposable = CompositeDisposable()

    protected var view: T? = null

    fun attachView(view: BaseView) {
        view as? T
            ?: throw IllegalArgumentException("Argument `view` does not suite for this presenter")
        this.view = view
        onViewAttach()
    }

    protected open fun onViewAttach() = Unit

    fun detachView() {
        onViewDetach()
        compositeDisposable.clear()
        view = null
    }

    protected open fun onViewDetach() = Unit

    fun Disposable.addToDisposables() =
        this.addTo(compositeDisposable)
}