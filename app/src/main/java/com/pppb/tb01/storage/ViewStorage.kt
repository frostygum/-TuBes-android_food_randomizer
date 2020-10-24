package com.pppb.tb01.storage

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pppb.tb01.model.Food

class ViewStorage(ctx: Context) {
    private var sp: SharedPreferences
    private val spName: String = "sp_display"
    private var keyTheme: String = "PREFERRED_THEME"
    private var keyFood: String = "FOOD_LIST"

    init {
        this.sp = ctx.getSharedPreferences(spName, 0)
    }

    fun savePreferredTheme(isThemeDark: Boolean) {
        this.sp.edit().putBoolean(keyTheme, isThemeDark).commit()
    }

    fun saveFoodList(foodList: List<Food>) {
        val foodStr = Gson().toJson(foodList)
        this.sp.edit().putString(keyFood, foodStr).commit()
    }

    fun getPreferredTheme(): Boolean {
        return this.sp.getBoolean(keyTheme, false)
    }

    fun getFoodList(): List<Food> {
        val foodStr = this.sp.getString(keyFood, "")
        val sType = object : TypeToken<List<Food>>() { }.type
        return Gson().fromJson(foodStr, sType)
    }
}