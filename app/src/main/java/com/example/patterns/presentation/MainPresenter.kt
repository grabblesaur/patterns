package com.example.patterns.presentation

import android.util.Log
import javax.inject.Inject

class MainPresenter @Inject constructor() {

    fun poof() {
        Log.i("TAG", "MainPresenter: poof")
    }
}