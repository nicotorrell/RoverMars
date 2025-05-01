package com.rovermars

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rovermars.models.Orientacion
import com.rovermars.movement.RoverMovement
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RotationTests {

    @Test
    fun testRotarIzquierda1() {
        val orientacion =  RoverMovement().rotarIzquierda(Orientacion.NORTE)
        assertEquals(orientacion, Orientacion.OESTE)
    }

    @Test
    fun testRotarIzquierda2() {
        val orientacion =  RoverMovement().rotarIzquierda(Orientacion.OESTE)
        assertEquals(orientacion, Orientacion.SUR)
    }

    @Test
    fun testRotarIzquierda3() {
        val orientacion =  RoverMovement().rotarIzquierda(Orientacion.SUR)
        assertEquals(orientacion, Orientacion.ESTE)
    }

    @Test
    fun testRotarIzquierda4() {
        val orientacion =  RoverMovement().rotarIzquierda(Orientacion.ESTE)
        assertEquals(orientacion, Orientacion.NORTE)
    }

    @Test
    fun testRotarDerecha1() {
        val orientacion =  RoverMovement().rotarDerecha(Orientacion.NORTE)
        assertEquals(orientacion, Orientacion.ESTE)
    }

    @Test
    fun testRotarDerecha2() {
        val orientacion =  RoverMovement().rotarDerecha(Orientacion.ESTE)
        assertEquals(orientacion, Orientacion.SUR)
    }

    @Test
    fun testRotarDerecha3() {
        val orientacion =  RoverMovement().rotarDerecha(Orientacion.SUR)
        assertEquals(orientacion, Orientacion.OESTE)
    }

    @Test
    fun testRotarDerecha4() {
        val orientacion =  RoverMovement().rotarDerecha(Orientacion.OESTE)
        assertEquals(orientacion, Orientacion.NORTE)
    }
}