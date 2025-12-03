package com.ruben.daigualapps.Examen24App

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.ruben.daigualapps.R

class Examen24Activity : AppCompatActivity() {

    private lateinit var tvPlayer: TextView
    private lateinit var iv1: ImageView
    private lateinit var iv2: ImageView
    private lateinit var iv3: ImageView
    private lateinit var iv4: ImageView
    private lateinit var iv5: ImageView
    private lateinit var iv6: ImageView
    private lateinit var iv7: ImageView
    private lateinit var iv8: ImageView
    private lateinit var iv9: ImageView

    private lateinit var ivList: MutableList<ImageView>

    private var turno = 1

    private var tiles = mutableListOf(0,0,0,0,0,0,0,0,0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_examen24)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        ivList.forEachIndexed { index, iv ->
            iv.setBackgroundColor(getColor(R.color.tres_en_raya))
            iv.setImageResource(0)
        }
        turno=1
        tiles.forEach { tiles[it] = 0 }
    }

    private fun initComponents() {
        tvPlayer = findViewById(R.id.tvPlayer)

        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)
        iv4 = findViewById(R.id.iv4)
        iv5 = findViewById(R.id.iv5)
        iv6 = findViewById(R.id.iv6)
        iv7 = findViewById(R.id.iv7)
        iv8 = findViewById(R.id.iv8)
        iv9 = findViewById(R.id.iv9)

        ivList= mutableListOf(iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9)
    }

    private fun initListeners() {
        ivList.forEachIndexed { index, iv ->
            iv.setOnClickListener { play(iv, index) }
        }
    }

    private fun play(iv: ImageView, index: Int) {
        if (turno%2 == 1) {
            iv.setBackgroundColor(getColor(R.color.player1))
            iv.setImageResource(R.drawable.ic_launcher_foreground)
            iv.isClickable = false
            iv.setPadding(0)
            tiles[index] = 1
            turno += 1
            tvPlayer.text = "Player 2"
            tvPlayer.setTextColor(getColor(R.color.player2))
            winCondition()
            if(turno>9) tie()
        } else {
            iv.setBackgroundColor(getColor(R.color.player2))
            iv.setImageResource(R.drawable.outline_accessible_forward_24)
            iv.isClickable = false
            iv.setPadding(18)
            tiles[index] = 2
            turno += 1
            tvPlayer.text = "Player 1"
            tvPlayer.setTextColor(getColor(R.color.player1))
            winCondition()
            if(turno>9) tie()
        }
    }

    private fun winCondition() {
        if(tiles[0]==tiles[1] && tiles[1]==tiles[2] && tiles[0]!=0) winner(tiles[0])
        if(tiles[3]==tiles[4] && tiles[4]==tiles[5] && tiles[3]!=0) winner(tiles[3])
        if(tiles[6]==tiles[7] && tiles[7]==tiles[8] && tiles[6]!=0) winner(tiles[6])
        if(tiles[0]==tiles[3] && tiles[3]==tiles[6] && tiles[0]!=0) winner(tiles[0])
        if(tiles[1]==tiles[4] && tiles[4]==tiles[7] && tiles[1]!=0) winner(tiles[1])
        if(tiles[2]==tiles[5] && tiles[5]==tiles[8] && tiles[2]!=0) winner(tiles[2])
        if(tiles[0]==tiles[4] && tiles[4]==tiles[8] && tiles[0]!=0) winner(tiles[0])
        if(tiles[2]==tiles[4] && tiles[4]==tiles[6] && tiles[2]!=0) winner(tiles[2])
    }

    private fun winner(i: Int) {
        if(i == 1) {
            tvPlayer.text = "Player 1 win!"
            tvPlayer.setTextColor(getColor(R.color.player1))
            Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 2000)
        } else {
            tvPlayer.text = "Player 2 win!"
            tvPlayer.setTextColor(getColor(R.color.player2))
            Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 2000)
        }
    }

    private fun tie() {
            tvPlayer.text = "It's a tie!"
            tvPlayer.setTextColor(getColor(R.color.black))
            Handler(Looper.getMainLooper()).postDelayed({ initUI() }, 2000)
    }
}