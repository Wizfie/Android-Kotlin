package com.example.game_suit

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private lateinit var computerImageView: ImageView
    private lateinit var batuImageButton : ImageButton
    private lateinit var guntingImageButton : ImageButton
    private lateinit var kertasImageButton: ImageButton
    private lateinit var resultImageView : ImageView

    private fun initComponents() {

        computerImageView = findViewById(R.id.computerImageView)
        batuImageButton = findViewById(R.id.batuImageButton)
        guntingImageButton = findViewById(R.id.guntingImageButton)
        kertasImageButton = findViewById(R.id.kertasImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListener(){
        batuImageButton.setOnClickListener { startGame("BATU") }
        kertasImageButton.setOnClickListener {  startGame("KERTAS")}
        guntingImageButton.setOnClickListener {  startGame("GUNTING")}
    }

    private fun startGame(option: String){
        val computerOptions = Game.pickRandomOption()
        Game.pickDrawable(computerOptions)?.let { computerImageView.setImageResource(it) }

        when {
            Game.isDraw(option,computerOptions)!! -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option,computerOptions)!! -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)


        initComponents()
        initListener()



    }
}