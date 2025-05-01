package com.rovermars

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rovermars.exceptions.RoverWrongOrientationException
import com.rovermars.models.RoverData
import com.rovermars.models.RoverInputData
import com.rovermars.movement.RoverMovement
import com.rovermars.utils.RoverUrils.Companion.stringToOrientacion
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestMove {

    @Test
    fun testMove1() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 1,
                  "y": 2
                },
                "roverDirection": "N",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        RoverMovement().move(rover)
        assertEquals(rover.coordenadas.y,3)
    }

    @Test
    fun testMove2() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 1,
                  "y": 2
                },
                "roverDirection": "S",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        RoverMovement().move(rover)
        assertEquals(rover.coordenadas.y,1)
    }

    @Test
    fun testMove3() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 1,
                  "y": 2
                },
                "roverDirection": "E",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        RoverMovement().move(rover)
        assertEquals(rover.coordenadas.x,2)
    }

    @Test
    fun testMove4() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 1,
                  "y": 2
                },
                "roverDirection": "W",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        RoverMovement().move(rover)
        assertEquals(rover.coordenadas.x,0)
    }
}