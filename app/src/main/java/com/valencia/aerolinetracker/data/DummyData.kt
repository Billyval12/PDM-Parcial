package com.valencia.aerolinetracker.data

val name = "Avianca"
val country = "Colombia"

val name2 = "LATAM"
val country2 = "Chile"

var aerolines = mutableListOf<AerolineModel>(
    AerolineModel(name, country),
    AerolineModel(name2, country2)
)