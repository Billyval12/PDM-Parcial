package com.valencia.aerolinetracker.repositories

import com.valencia.aerolinetracker.data.AerolineModel

class AerolineRepository (private val aerolines: MutableList<AerolineModel>){

    fun getAerolines() = aerolines.reversed()

    fun addAeroline(aeroline: AerolineModel) = aerolines.add(aeroline)
}