package com.rovermars

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rovermars.models.PlateauData
import com.rovermars.models.RoverInputData
import com.rovermars.movement.RoverMovement
import kotlinx.serialization.json.Json
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CorrectPlateauTests {

    @Test
    fun testCorrectCoordenates1() {

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

        val onBounds =  RoverMovement().checkPlateauIsCorrect( plateu)
        assertTrue(onBounds)
    }

    @Test
    fun testCorrectCoordenates2() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": -1,
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

        val onBounds =  RoverMovement().checkPlateauIsCorrect( plateu)
        assertFalse(onBounds)
    }

    @Test
    fun testCorrectCoordenates3() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": -1
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

        val onBounds =  RoverMovement().checkPlateauIsCorrect(plateu)
        assertFalse(onBounds)
    }


    @Test
    fun testCorrectCoordenates8() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 5,
                  "y": 0
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

        val onBounds =  RoverMovement().checkPlateauIsCorrect( plateu)
        assertFalse(onBounds)
    }

    @Test
    fun testCorrectCoordenates9() {

        val testJsonInput = """
            {
                "topRightCorner": {
                  "x": 0,
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

        val onBounds =  RoverMovement().checkPlateauIsCorrect(plateu)
        assertFalse(onBounds)
    }
}