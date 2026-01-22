package com.example.tarea3_manjoncarrascojosecarlos.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea3_manjoncarrascojosecarlos.data.api.RetroFitInstance
import com.example.tarea3_manjoncarrascojosecarlos.data.model.Character
import com.example.tarea3_manjoncarrascojosecarlos.data.model.Episode
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters
    fun loadCharacters() {
        viewModelScope.launch {
            try {
                _characters.value = RetroFitInstance.api.getCharacters().results
            } catch (
                e: Exception
            ) {
                _characters.value = emptyList<Character>()
            }
        }
    }
}