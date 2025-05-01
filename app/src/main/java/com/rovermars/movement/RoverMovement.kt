package com.rovermars.movement

import com.rovermars.exceptions.RoverInvalidCoordinatesException
import com.rovermars.exceptions.RoverOutOfBoundsException
import com.rovermars.exceptions.RoverWrongCommandException
import com.rovermars.exceptions.RoverWrongOrientationException
import com.rovermars.models.Orientacion
import com.rovermars.models.Orientacion.ESTE
import com.rovermars.models.Orientacion.NORTE
import com.rovermars.models.Orientacion.OESTE
import com.rovermars.models.Orientacion.SUR
import com.rovermars.models.PlateauData
import com.rovermars.models.RoverData
import com.rovermars.models.RoverInputData
import com.rovermars.utils.RoverUrils.Companion.stringToOrientacion
import org.jetbrains.annotations.VisibleForTesting

class RoverMovement {

    //Mian function to interpret commands
    fun moveRover(input: RoverInputData): RoverData{

        val plateu = PlateauData(input.topRightCorner)

        val roverOrientacion = stringToOrientacion(input.roverDirection)
        if(roverOrientacion == null) {
            throw RoverWrongOrientationException()
        }
        val rover = RoverData(input.roverPosition, roverOrientacion)

        if(checkPlateauIsCorrect(plateu)) {
            if (checkRoverIsOnBounds(rover, plateu)) {
                for (command in input.getMovementList()) {
                    if (command.uppercase().equals("M")) {
                        if (canMoveRover(rover, plateu)) {
                            move(rover)
                        }
                    } else if (command.uppercase().equals("L")) {
                        rover.orientacion = rotarIzquierda(rover.orientacion)
                    } else if (command.uppercase().equals("R")) {
                        rover.orientacion = rotarDerecha(rover.orientacion)
                    } else {
                        throw RoverWrongCommandException()
                    }
                }
                return rover
            } else {
                throw RoverOutOfBoundsException()
            }
        }else{
            throw RoverInvalidCoordinatesException()
        }
    }

    //Check if plateau has a valid size
    @VisibleForTesting
    internal fun checkPlateauIsCorrect(plateauData: PlateauData):Boolean {
        if (plateauData.tamaño.x <= 0 ) {
            return false
        }
        if (plateauData.tamaño.y <= 0) {
            return false
        }
        return true
    }

    //Check Rover initial position is inside plateau
    @VisibleForTesting
    internal fun checkRoverIsOnBounds(rover: RoverData, plateauData: PlateauData):Boolean {
        if (rover.coordenadas.x < 0 || rover.coordenadas.x > plateauData.tamaño.x) {
            return false
        }
        if (rover.coordenadas.y < 0 || rover.coordenadas.y > plateauData.tamaño.y) {
            return false
        }
        return true
    }

    //Check Rover will not go out of bounds after moving
    @VisibleForTesting
    internal fun canMoveRover(rover: RoverData, plateauData: PlateauData):Boolean{
        if(rover.orientacion == NORTE){
            return rover.coordenadas.y + 1 <= plateauData.tamaño.y
        }
        if(rover.orientacion == SUR){
            return rover.coordenadas.y - 1 >= 0
        }
        if(rover.orientacion == ESTE){
            return rover.coordenadas.x + 1 <= plateauData.tamaño.x
        }
        if(rover.orientacion == OESTE){
            return rover.coordenadas.x - 1 >= 0
        }
        return false
    }

    //Move rover depending on orientation
    @VisibleForTesting
    internal fun move(rover: RoverData){
        if(rover.orientacion == NORTE){
            rover.coordenadas.y += 1
        }
        if(rover.orientacion == SUR){
            rover.coordenadas.y -= 1
        }
        if(rover.orientacion == ESTE){
            rover.coordenadas.x += 1
        }
        if(rover.orientacion == OESTE){
            rover.coordenadas.x -= 1
        }
    }

    //Move Rover Left
    @VisibleForTesting
    internal fun rotarIzquierda(orientacion: Orientacion): Orientacion{
        var orientacionFinal: Orientacion = orientacion
        when (orientacion){
            NORTE -> orientacionFinal = OESTE
            SUR -> orientacionFinal = ESTE
            ESTE -> orientacionFinal = NORTE
            OESTE -> orientacionFinal = SUR
        }
        return orientacionFinal
    }

    //Move Rover Right
    @VisibleForTesting
    internal fun rotarDerecha(orientacion: Orientacion): Orientacion{
        var orientacionFinal: Orientacion = orientacion
        when (orientacion){
            NORTE -> orientacionFinal = ESTE
            SUR -> orientacionFinal = OESTE
            ESTE -> orientacionFinal = SUR
            OESTE -> orientacionFinal = NORTE
        }
        return orientacionFinal
    }
}
