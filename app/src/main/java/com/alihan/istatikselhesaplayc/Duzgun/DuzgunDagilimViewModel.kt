package com.alihan.istatikselhesaplayc.Duzgun

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DuzgunDagilimViewModel :ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun calculateBernoilli(b: Double, a: Double) {
        try {
            val poissonResult = (1/(b-a))
            _result.value = String.format("%.5f", poissonResult)
        } catch (e: Exception) {
            _result.value = "Hata!"
        }
    }
}