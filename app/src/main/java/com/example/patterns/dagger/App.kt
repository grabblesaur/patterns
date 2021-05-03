package com.example.patterns.dagger

import android.app.Application
import com.example.patterns.DaggerApplicationComponents


class App : Application() {

    val appComponent = DaggerApplicationComponents.create()
}