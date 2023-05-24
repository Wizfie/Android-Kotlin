package com.example.game_suit

import org.junit.Assert
import org.junit.Test

class GameTest {
    @Test
    fun tesPickRandomOptions(){
        val option = listOf("BATU","GUNTING","KERTAS")

        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
        Assert.assertTrue(option.contains(Game.pickRandomOption()))
    }

    @Test
    fun tesPickDrawable() {
        Assert.assertEquals(R.drawable.kertas,Game.pickDrawable("KERTAS"))
        Assert.assertEquals(R.drawable.batu,Game.pickDrawable("BATU"))
        Assert.assertEquals(R.drawable.gunting,Game.pickDrawable("GUNTING"))
    }

    @Test
    fun tesIsDraw() {
        Assert.assertTrue(Game.isDraw("BATU","BATU"))
        Assert.assertTrue(Game.isDraw("GUNTING","GUNTING"))
        Assert.assertTrue(Game.isDraw("KERTAS","KERTAS"))

        Assert.assertFalse(Game.isDraw("BATU","KERTAS"))
        Assert.assertFalse(Game.isDraw("GUNTING","KERTAS"))
        Assert.assertFalse(Game.isDraw("BATU","GUNTING"))

    }

    @Test
    fun tesIsWin() {
        Game.isWin("BATU","GUNTING")?.let { Assert.assertTrue(it) }
        Game.isWin("KERTAS","BATU")?.let { Assert.assertTrue(it) }
        Game.isWin("GUNTING","KERTAS")?.let { Assert.assertTrue(it) }


        Game.isWin("KERTAS","GUNTING")?.let { Assert.assertFalse(it) }
        Game.isWin("GUNTING","BATU")?.let { Assert.assertFalse(it) }
        Game.isWin("BATU","KERTAS")?.let { Assert.assertFalse(it) }
    }
}