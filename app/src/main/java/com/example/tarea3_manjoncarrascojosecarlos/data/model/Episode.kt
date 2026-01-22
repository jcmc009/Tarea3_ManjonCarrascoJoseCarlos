package com.example.tarea3_manjoncarrascojosecarlos.data.model

data class Episode(
    val name: String,
    val episode: String,
    val air_date: String
)

data class EpisodesApiResponse(
    val results: List<Episode>
)