package com.example.patterns.dagger

import android.app.Application

class App : Application() {

    val appComponent = DaggerApplicationComponents.create()
}