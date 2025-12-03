package com.ruben.daigualapps.RepasoApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.daigualapps.BoardgamesApp.Game
import com.ruben.daigualapps.BoardgamesApp.GameCategory
import com.ruben.daigualapps.BoardgamesApp.GameCategory.Cooperative
import com.ruben.daigualapps.BoardgamesApp.GameCategory.Deckbuilding
import com.ruben.daigualapps.BoardgamesApp.GameCategory.Euro
import com.ruben.daigualapps.BoardgamesApp.GameCategory.LCG
import com.ruben.daigualapps.BoardgamesApp.GameCategory.Legacy
import com.ruben.daigualapps.R

class RepasoActivity : AppCompatActivity() {

    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView
    private lateinit var tv4: TextView
    private lateinit var tv5: TextView
    private lateinit var tv6: TextView
    private lateinit var tv7: TextView
    private lateinit var tv8: TextView
    private lateinit var tv9: TextView
    private lateinit var tv10: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_repaso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
    }

    private fun initListeners() {
        tv1.setOnClickListener { showDialog(tv1) }
        tv2.setOnClickListener { showDialog(tv2) }
        tv3.setOnClickListener { showDialog(tv3) }
        tv4.setOnClickListener { showDialog(tv4) }
        tv5.setOnClickListener { showDialog(tv5) }
        tv6.setOnClickListener { showDialog(tv6) }
        tv7.setOnClickListener { showDialog(tv7) }
        tv8.setOnClickListener { showDialog(tv8) }
        tv9.setOnClickListener { showDialog(tv9) }
        tv10.setOnClickListener { showDialog(tv10) }
    }

    private fun initComponents() {
        tv1 = findViewById (R.id.tv1)
        tv2 = findViewById (R.id.tv2)
        tv3 = findViewById (R.id.tv3)
        tv4 = findViewById (R.id.tv4)
        tv5 = findViewById (R.id.tv5)
        tv6 = findViewById (R.id.tv6)
        tv7 = findViewById (R.id.tv7)
        tv8 = findViewById (R.id.tv8)
        tv9 = findViewById (R.id.tv9)
        tv10 = findViewById(R.id.tv10)
    }

    private fun showDialog(tv: TextView) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_repaso)

        var btnApplyColor: CardView = dialog.findViewById(R.id.cvApplyColor)
        var rgColors = dialog.findViewById<RadioGroup>(R.id.rgColors)

        btnApplyColor.setOnClickListener {
            val selectedRadioButton: RadioButton = rgColors.findViewById(rgColors.checkedRadioButtonId)
            when(selectedRadioButton.text) {
                getString(R.string.blanco) -> {
                    tv.setBackgroundColor(getColor(R.color.white))
                    tv.setTextColor(getColor(R.color.negro))
                    tv.text = getString(R.string.blanco)
                }
                getString(R.string.negro) -> {
                    tv.setBackgroundColor(getColor(R.color.negro))
                    tv.setTextColor(getColor(R.color.white))
                    tv.text = getString(R.string.negro)
                }
                getString(R.string.rojo) -> {
                    tv.setBackgroundColor(getColor(R.color.rojo))
                    tv.setTextColor(getColor(R.color.white))
                    tv.text = getString(R.string.rojo)
                }
                getString(R.string.naranja) -> {
                    tv.setBackgroundColor(getColor(R.color.naranja))
                    tv.setTextColor(getColor(R.color.negro))
                    tv.text = getString(R.string.naranja)
                }
                getString(R.string.amarillo) -> {
                    tv.setBackgroundColor(getColor(R.color.amarillo))
                    tv.setTextColor(getColor(R.color.negro))
                    tv.text = getString(R.string.amarillo)
                }
                getString(R.string.verde) -> {
                    tv.setBackgroundColor(getColor(R.color.verde))
                    tv.setTextColor(getColor(R.color.negro))
                    tv.text = getString(R.string.verde)
                }
                getString(R.string.cian) -> {
                    tv.setBackgroundColor(getColor(R.color.cian))
                    tv.setTextColor(getColor(R.color.negro))
                    tv.text = getString(R.string.cian)
                }
                getString(R.string.azul) -> {
                    tv.setBackgroundColor(getColor(R.color.azul))
                    tv.setTextColor(getColor(R.color.white))
                    tv.text = getString(R.string.azul)
                }
                getString(R.string.violeta) -> {
                    tv.setBackgroundColor(getColor(R.color.violeta))
                    tv.setTextColor(getColor(R.color.white))
                    tv.text = getString(R.string.violeta)
                }
                getString(R.string.gris) -> {
                    tv.setBackgroundColor(getColor(R.color.gris))
                    tv.setTextColor(getColor(R.color.white))
                    tv.text = getString(R.string.gris)
                }
            }

            dialog.hide()
        }

        dialog.show()
    }
}