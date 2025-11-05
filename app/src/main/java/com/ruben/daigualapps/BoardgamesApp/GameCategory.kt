package com.ruben.daigualapps.BoardgamesApp

sealed class GameCategory (var isSelected: Boolean = true) {
    object Euro: GameCategory()
    object Deckbuilding: GameCategory()
    object LCG: GameCategory()
    object Legacy: GameCategory()
    object Cooperative: GameCategory()
}