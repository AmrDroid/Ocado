package com.amrmustafa.ocado
import android.app.Application

import com.amrmustafa.ocado.di.networkModule
import com.amrmustafa.ocado.di.viewModelsModule
import com.amrmustafa.ocado.di.remoteDataSourceModule
import com.amrmustafa.ocado.di.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                networkModule,
                viewModelsModule,
                remoteDataSourceModule,
                useCasesModule
            )
        }

    }

}