package com.rovermars

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rovermars.exceptions.RoverWrongOrientationException
import com.rovermars.models.PlateauData
import com.rovermars.models.RoverData
import com.rovermars.models.RoverInputData
import com.rovermars.movement.RoverMovement
import com.rovermars.utils.RoverUrils.Companion.stringToOrientacion
import kotlinx.serialization.json.Json
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestsCanMoveRover {

    @Test
    fun testcanMoveRover1() {

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
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)

        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertFalse(canMove)
    }

    @Test
    fun testcanMoveRover2() {

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

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertTrue(canMove)
    }

    @Test
    fun testcanMoveRover3() {

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
                "roverDirection": "S",
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertFalse(canMove)
    }

    @Test
    fun testcanMoveRover4() {

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
                "roverDirection": "S",
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertTrue(canMove)
    }

    @Test
    fun testcanMoveRover5() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 5,
                  "y": 5
                },
                "roverDirection": "N",
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertFalse(canMove)
    }

    @Test
    fun testcanMoveRover6() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 4,
                  "y": 4
                },
                "roverDirection": "N",
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertTrue(canMove)
    }

    @Test
    fun testcanMoveRover7() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 5,
                  "y": 5
                },
                "roverDirection": "E",
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertFalse(canMove)
    }

    @Test
    fun testcanMoveRover8() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 4,
                  "y": 4
                },
                "roverDirection": "E",
                "movements": "MMMMLMMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val canMove = RoverMovement().canMoveRover(rover,plateu)
        assertTrue(canMove)
    }
}