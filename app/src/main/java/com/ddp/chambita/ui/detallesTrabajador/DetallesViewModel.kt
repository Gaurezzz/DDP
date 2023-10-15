package com.ddp.chambita.ui.detallesTrabajador

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetallesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is detalles Fragment"
    }
    val text: LiveData<String> = _text
}