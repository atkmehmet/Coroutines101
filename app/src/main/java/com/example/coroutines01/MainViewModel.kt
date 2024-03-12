package com.example.coroutines01

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val adder: NumberAdder = NumberAdder()):ViewModel() {

    var resultState by  mutableStateOf("")
        private set

    fun add(a:String,b:String){
        viewModelScope.launch {

         adder.add(a.toInt(),b.toInt()).collect {
             resultState = it.toString()
         }


        }

    }


}