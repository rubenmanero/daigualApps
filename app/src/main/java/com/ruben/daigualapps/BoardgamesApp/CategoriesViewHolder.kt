package com.ruben.daigualapps.BoardgamesApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.ruben.daigualapps.R

class CategoriesViewHolder (val view: View): RecyclerView.ViewHolder(view) {
    private val tvCategory = view.findViewById<TextView>(R.id.tvCategoryName)
    private val divider = view.findViewById<View>(R.id.divider)
    private val viewContainer = view.findViewById<CardView>(R.id.viewContainer)

    fun render (gameCategory: GameCategory, onItemSelected: (Int) -> Unit) {
        val color = if (gameCategory.isSelected) {
            R.color.bgapp_background_card
        } else {
            R.color.bgapp_background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when(gameCategory) {
            GameCategory.LCG -> {
                tvCategory.text = "LCG"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_lcg_category))
            }

            GameCategory.Cooperative -> {
                tvCategory.text = "Cooperativos"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }

            GameCategory.Deckbuilding -> {
                tvCategory.text = "Deckbuilding"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_deckbuilding_category))
            }

            GameCategory.Euro -> {
                tvCategory.text = "Eurogames"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_euro_category))
            }

            GameCategory.Legacy -> {
                tvCategory.text = "Legacy"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_legacy_category))
            }
        }
    }
}