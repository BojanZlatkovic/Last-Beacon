package com.lastbeacon.defense

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var gameView: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameView = GameView(this)
        setContentView(gameView)
    }

    override fun onPause() {
        super.onPause()
        gameView.surfaceDestroyed(gameView.holder)
    }

    override fun onResume() {
        super.onResume()
        if (!gameView.running) {
            gameView.surfaceCreated(gameView.holder)
        }
    }
}
