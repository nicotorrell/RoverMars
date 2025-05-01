package com.rovermars.models

import kotlinx.serialization.Serializable

@Serializable
data class RoverInputData(
    val topRightCorner: Coordenadas,
    val roverPosition: Coordenadas,
    val roverDirection: String,
    val movements: String,
){
    fun getMovementList(): List<Char> = movements.toList()

}