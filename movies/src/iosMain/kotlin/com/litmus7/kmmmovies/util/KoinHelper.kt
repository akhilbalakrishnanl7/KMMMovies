package com.litmus7.kmmmovies.util

import com.litmus7.kmmmovies.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin{
        modules(getSharedModules())
    }
}