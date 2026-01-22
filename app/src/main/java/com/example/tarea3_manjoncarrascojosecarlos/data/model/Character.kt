package com.example.tarea3_manjoncarrascojosecarlos.data.model

data class Character(
    val name: String,
    val image: String
)

data class CharactersApiResponse(
    val results: List<Episode>
)