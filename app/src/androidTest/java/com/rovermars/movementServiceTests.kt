package com.rovermars

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rovermars.models.Coordenadas
import com.rovermars.models.Orientacion
import com.rovermars.models.RoverData
import com.rovermars.models.RoverInputData
import com.rovermars.movement.RoverMovement
import kotlinx.serialization.json.Json

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class movementServiceTests {

    @Test
    fun testMoveRover1() {

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

        val roverFinalPosition = RoverMovement().moveRover(roverData)
        assertEquals(RoverData(Coordenadas(1,3),Orientacion.NORTE), roverFinalPosition)
    }

    @Test
    fun testMoveRover2() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 0,
                  "y": 0
                },
                "roverDirection": "N",
                "movements": "MMMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverFinalPosition = RoverMovement().moveRover(roverData)
        assertEquals(RoverData(Coordenadas(0,5),Orientacion.NORTE), roverFinalPosition)
    }

    @Test
    fun testMoveRover3() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 3,
                  "y": 2
                },
                "roverDirection": "E",
                "movements": "MRMMRM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverFinalPosition = RoverMovement().moveRover(roverData)
        assertEquals(RoverData(Coordenadas(3,0),Orientacion.OESTE), roverFinalPosition)
    }

    @Test
    fun testMoveRover4() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 0,
                  "y": 0
                },
                "roverDirection": "W",
                "movements": "RMMRMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverFinalPosition = RoverMovement().moveRover(roverData)
        assertEquals(RoverData(Coordenadas(3,2),Orientacion.ESTE), roverFinalPosition)
    }

    @Test
    fun testMoveRover5() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 1,
                  "y": 1
                },
                "roverDirection": "W",
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val roverFinalPosition = RoverMovement().moveRover(roverData)
        assertEquals(RoverData(Coordenadas(0,0),Orientacion.SUR), roverFinalPosition)
    }

}