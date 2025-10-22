package com.ruben.daigualapps.IMCApp

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider
import com.ruben.daigualapps.R

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHeight: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left+32, systemBars.top+32, systemBars.right+32, systemBars.bottom+32)
            insets
        }

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        viewMale = findViewById<CardView>(R.id.viewMale)
        viewFemale = findViewById<CardView>(R.id.viewFemale)
        rsHeight = findViewById<RangeSlider>(R.id.rsHeight)
        tvHeight = findViewById<TextView>(R.id.tvHeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setComponentColorMale() }
        viewFemale.setOnClickListener { setComponentColorFemale() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
    }

    private fun setComponentColorMale() {
        if(!isMaleSelected) {
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun setComponentColorFemale() {
        if(!isFemaleSelected) {
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            isFemaleSelected = true
            isMaleSelected = false
        }
    }
}