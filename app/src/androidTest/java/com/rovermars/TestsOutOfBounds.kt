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
class TestsOutOfBounds {

    @Test
    fun testOutofBounds1() {

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

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val onBounds =  RoverMovement().checkRoverIsOnBounds(rover, plateu)
        assertTrue(onBounds)
    }

    @Test
    fun testOutofBounds2() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 9,
                  "y": 2
                },
                "roverDirection": "N",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val onBounds =  RoverMovement().checkRoverIsOnBounds(rover, plateu)
        assertFalse(onBounds)
    }

    @Test
    fun testOutofBounds3() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 1,
                  "y": 9
                },
                "roverDirection": "N",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val onBounds =  RoverMovement().checkRoverIsOnBounds(rover, plateu)
        assertFalse(onBounds)
    }

    @Test
    fun testOutofBounds4() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": -1,
                  "y": 2
                },
                "roverDirection": "N",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val onBounds =  RoverMovement().checkRoverIsOnBounds(rover, plateu)
        assertFalse(onBounds)
    }

    @Test
    fun testOutofBounds5() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 5
                },
                "roverPosition": {
                  "x": 1,
                  "y": -1
                },
                "roverDirection": "N",
                "movements": "LMLMLMLMM"
            }
        """.trimIndent()
        val roverData = Json.decodeFromString<RoverInputData>(testJsonInput)

        val plateu = PlateauData(roverData.topRightCorner)
        val roverOrientacion = stringToOrientacion(roverData.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(roverData.roverPosition, roverOrientacion)

        val onBounds =  RoverMovement().checkRoverIsOnBounds(rover, plateu)
        assertFalse(onBounds)
    }
}