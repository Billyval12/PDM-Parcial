package com.valencia.aerolinetracker.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.valencia.aerolinetracker.AerolineApplication
import com.valencia.aerolinetracker.data.AerolineModel
import com.valencia.aerolinetracker.repositories.AerolineRepository

class AerolineViewModel(private val repository: AerolineRepository): ViewModel(){

    var name = MutableLiveData("")
    var country = MutableLiveData("")
    var status = MutableLiveData("")

    fun getAerolines() = repository.getAerolines()

    fun addAeroline(aeroline: AerolineModel) = repository.addAeroline(aeroline)

    fun createAeroline() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val aeroline = AerolineModel(
            name.value!!,
            country.value!!
        )

        addAeroline(aeroline)
        clearData()

        status.value = AEROLINE_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            country.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        country.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedAeroline(aeroline: AerolineModel) {
        name.value = aeroline.name
        country.value = aeroline.country
    }

    companion object {

        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AerolineApplication
                AerolineViewModel(app.aerolineRepository)
            }
        }

        const val AEROLINE_CREATED = "Aeroline created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}