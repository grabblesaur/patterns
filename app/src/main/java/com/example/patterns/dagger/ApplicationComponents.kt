package com.example.patterns.dagger

import com.example.patterns.ui.MainActivity
import dagger.Component
import dagger.android.ContributesAndroidInjector

@Component
interface ApplicationComponents {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun inject(activity: MainActivity)
}