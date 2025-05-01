package com.rovermars.utils

import com.rovermars.models.Orientacion
import com.rovermars.models.Orientacion.ESTE
import com.rovermars.models.Orientacion.NORTE
import com.rovermars.models.Orientacion.OESTE
import com.rovermars.models.Orientacion.SUR

class RoverUrils {
    companion object{
        fun stringToOrientacion(s: String): Orientacion?{
            if(s.uppercase().equals("N")) {
                return NORTE
            }
            if(s.uppercase().equals("S")) {
                return SUR
            }
            if(s.uppercase().equals("E")) {
                return ESTE
            }
            if(s.uppercase().equals("W")) {
                return OESTE
            }
            return null
        }

        fun orientacionToString(s: Orientacion): String{
            if(s == NORTE) {
                return "N"
            }
            if(s == SUR) {
                return "S"
            }
            if(s == ESTE) {
                return "E"
            }
            if(s == OESTE) {
                return "W"
            }
            return ""
        }
    }
}