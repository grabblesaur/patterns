package com.example.patterns.base

import android.app.Activity
import android.os.Bundle

abstract class BaseActivity : Activity() {

    private var presenters: MutableList<BasePresenter<out BaseView>> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this is BaseView) {
            javaClass.fields.forEach { field ->
                val presenter = field.get(this) as? BasePresenter<out BaseView>

                if (presenter != null) {
                    presenter.attachView(this)
                    presenters.add(presenter)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenters.forEach { it.detachView() }
        presenters.clear()
    }
}