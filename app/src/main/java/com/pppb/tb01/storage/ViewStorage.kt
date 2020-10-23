package com.pppb.tb01.storage

import android.content.Context
import android.content.SharedPreferences

class ViewStorage(ctx: Context) {
    private var sp: SharedPreferences
    private val spName: String = "sp_display"
    private var keyTheme: String = "PREFERRED_THEME"

    init {
        this.sp = ctx.getSharedPreferences(spName, 0)
    }

    fun savePreferredTheme(isThemeDark: Boolean) {
        val editor = this.sp.edit()
        editor.putBoolean(keyTheme, isThemeDark)
        editor.commit()
    }

    fun getPreferredTheme(): Boolean {
        return this.sp.getBoolean(keyTheme, false)
    }
}