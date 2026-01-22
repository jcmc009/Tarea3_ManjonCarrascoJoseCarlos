package com.example.tarea3_manjoncarrascojosecarlos.data.api

import com.example.tarea3_manjoncarrascojosecarlos.data.model.CharactersApiResponse
import com.example.tarea3_manjoncarrascojosecarlos.data.model.EpisodesApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("episode")
    suspend fun getEpisodes(): EpisodesApiResponse

    @GET("character")
    suspend fun getCharacters(): CharactersApiResponse
}