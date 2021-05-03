package com.example.patterns.dagger

import com.example.patterns.ui.MainActivity
import dagger.Component

@Component
interface ApplicationComponents {

    fun inject(activity: MainActivity)
}