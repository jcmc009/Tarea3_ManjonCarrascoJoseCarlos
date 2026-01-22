package com.example.tarea3_manjoncarrascojosecarlos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea3_manjoncarrascojosecarlos.data.api.RetroFitInstance
import com.example.tarea3_manjoncarrascojosecarlos.data.model.Episode
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {
    private val _episodes = MutableLiveData<List<Episode>>()

    val episodes: LiveData<List<Episode>> = _episodes
    fun loadEPisodes() {
        viewModelScope.launch {
            try {
                _episodes.value = RetroFitInstance.api.getEpisodes().results
            } catch (
                e: Exception
            ) {
                _episodes.value = emptyList<Episode>()
            }
        }
    }
}