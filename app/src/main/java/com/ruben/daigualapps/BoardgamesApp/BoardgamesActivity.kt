package com.ruben.daigualapps.BoardgamesApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ruben.daigualapps.BoardgamesApp.GameCategory.*
import com.ruben.daigualapps.R

class BoardgamesActivity : AppCompatActivity() {

    private val categories = listOf(
        LCG,
        Cooperative,
        Deckbuilding,
        Euro,
        Legacy
    )

    private val games = mutableListOf(
        Game("Frostpunk", Cooperative),
        Game("Hero Realm", Deckbuilding),
        Game("Agricola", Euro),
        Game("Arkham Horror", LCG),
        Game("Gloomhaven", Legacy)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var fabAddGame: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boardgames)
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
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        gamesAdapter = GamesAdapter(games)
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvGames.adapter = gamesAdapter
    }

    private fun initComponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }

    private fun initListeners() {
        fabAddGame.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        var btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)
        var etGame: EditText = dialog.findViewById(R.id.etGame)
        var rgCategories = dialog.findViewById<RadioGroup>(R.id.rgCategories)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if(currentGame.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById<RadioButton>(selectedId)
                val currentCategory: GameCategory = when(selectedRadioButton.text) {
                    getString(R.string.dialog_cooperative_category) -> Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> Deckbuilding
                    getString(R.string.dialog_lcg_category) -> LCG
                    getString(R.string.dialog_legacy_category) -> Legacy
                    else -> Euro
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun updateGames() {
        gamesAdapter.notifyDataSetChanged()
    }
}