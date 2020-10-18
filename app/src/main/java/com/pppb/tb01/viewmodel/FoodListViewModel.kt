package com.pppb.tb01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pppb.tb01.model.Food

class FoodListViewModel(): ViewModel() {
    private val foodList: MutableList<Food> = mutableListOf()
    private val foods: MutableLiveData<List<Food>> = MutableLiveData<List<Food>>()

    init {
        for(i in 1 .. 10) {
            val food = Food("nama food ke $i", "ini description untuk food ke $i")
            addFood(food)
        }
        this.update()
    }

    fun getFoods() = foods as LiveData<List<Food>>

    fun addFood(food: Food) {
        this.foodList.add(food)
        this.update()
    }

    private fun update() { this.foods.value = foodList }
}