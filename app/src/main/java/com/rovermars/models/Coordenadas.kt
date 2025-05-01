package com.rovermars.models

import kotlinx.serialization.Serializable

@Serializable
data class Coordenadas(
    var x: Int,
    var y: Int
)