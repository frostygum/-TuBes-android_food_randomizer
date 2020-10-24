package com.pppb.tb01.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.pppb.tb01.model.Food
import java.lang.Exception

object Utils {
    fun hideSoftKeyBoard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun getRandomNumberFromFoodList(list: List<Food>): Int {
        return if(list.isNotEmpty()) {
            (list.indices).random()
        } else {
            -1
        }
    }
}