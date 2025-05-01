package com.rovermars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rovermars.exceptions.RoverInvalidCoordinatesException
import com.rovermars.exceptions.RoverOutOfBoundsException
import com.rovermars.exceptions.RoverWrongCommandException
import com.rovermars.exceptions.RoverWrongOrientationException
import com.rovermars.models.RoverInputData
import com.rovermars.movement.RoverMovement
import com.rovermars.ui.theme.RoverMarsTheme
import com.rovermars.utils.RoverUrils.Companion.orientacionToString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Obtains data from json file
        val jsonInput = assets.open("rover_input.json").bufferedReader().use { it.readText() }
        val roverData = Json.decodeFromString<RoverInputData>(jsonInput)

        setContent {
            RoverMarsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    executeRover(roverData)
                }
            }
        }
    }
}

@Composable
fun executeRover(roverData: RoverInputData) {

    //Copy data to show originals in text
    val inicialRover = RoverInputData(roverData.topRightCorner.copy(), roverData.roverPosition.copy(),roverData.roverDirection,roverData.movements)

    var finalText = ""
    //call function to execute commands from json and move the rover
    try {
        val roverFinalPosition = RoverMovement().moveRover(roverData)
        finalText = "Result: ${roverFinalPosition.coordenadas.x} ${roverFinalPosition.coordenadas.y} ${orientacionToString(roverFinalPosition.orientacion)}"
    }catch(e:RuntimeException){
        if(e is RoverOutOfBoundsException){
            finalText = "Result: ROVER IS OUT OF BOUNDS"
        }
        if(e is RoverWrongCommandException){
            finalText = "Result: INVALID COMMAND"
        }
        if(e is RoverWrongOrientationException){
            finalText = "Result: INVALID ROVER ORIENTATION"
        }
        if(e is RoverInvalidCoordinatesException){
            finalText = "Result: INVALID COORDENATES"
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        //Show original information and result from commands
        Text(text = "Plateu Size: ${inicialRover.topRightCorner.x} ${inicialRover.topRightCorner.y}")
        Text(text = "Rover initial position: ${inicialRover.roverPosition.x} ${inicialRover.roverPosition.y} ${inicialRover.roverDirection}", modifier = Modifier.offset(x = 0.dp, y = 20.dp))
        Text(text = "Commands: ${inicialRover.movements}", modifier = Modifier.offset(x = 0.dp, y = 40.dp))
        Text(text = finalText, modifier = Modifier.offset(x = 0.dp, y = 60.dp))
        System.out.println(finalText)
    }
}
