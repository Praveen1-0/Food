package com.example.food.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.food.utils.Constants.Companion.FAVORITE_RECIPES_TABLE
import com.example.food.models.Result

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)
