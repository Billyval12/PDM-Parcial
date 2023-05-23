package com.valencia.aerolinetracker

import android.app.Application
import com.valencia.aerolinetracker.data.aerolines
import com.valencia.aerolinetracker.repositories.AerolineRepository

class AerolineApplication : Application(){
    val aerolineRepository: AerolineRepository by lazy {
        AerolineRepository(aerolines)
    }
}