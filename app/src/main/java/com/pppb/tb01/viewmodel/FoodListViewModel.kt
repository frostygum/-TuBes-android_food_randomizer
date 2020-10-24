package com.pppb.tb01.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pppb.tb01.model.Food
import com.pppb.tb01.storage.FoodListData
import com.pppb.tb01.storage.ViewStorage

class FoodListViewModel(application: Application): AndroidViewModel(application) {
    private val foodList: MutableList<Food> = mutableListOf()
    private val foods: MutableLiveData<List<Food>> = MutableLiveData<List<Food>>()
    private val storage: ViewStorage = ViewStorage(application)

    init {
        this.foodList.addAll(storage.getFoodList())
        this.importFoodList()
        this.update()
    }

    fun getFoods() = this.foods as LiveData<List<Food>>

    fun getFoodAt(index: Int) = this.foods.value?.get(index)

    fun addFood(food: Food) {
        val newFood: Food = food
        newFood.setId(this.foodList.size + 1)
        this.foodList.add(newFood)
        this.update()
        this.updateStorage()
    }

    fun deleteFoodAt(indexToBeDeleted: Int) {
        this.foodList.removeAt(indexToBeDeleted)
        this.update()
        this.updateStorage()
    }

    fun setFoodById(food: Food, id: Int) {
        var location = 0
        //get index location for current id
        for((i, it) in this.foodList.withIndex()){
            if(it.getId() == id) {
                location = i
                break
            }
        }
        this.foodList[location] = food
        this.update()
        this.updateStorage()
    }

    fun reImportFoodList() {
        FoodListData.getInitialFoodList().forEach { food ->
            val newFood: Food = food
            newFood.setId(this.foodList.size)
            this.foodList.add(newFood)
        }
        this.update()
        this.updateStorage()
    }

    fun clearFood() {
        this.foodList.clear()
        this.storage.clearFoodList()
    }

    private fun update() {
        this.foods.value = this.foodList
    }

    private fun updateStorage() {
        this.storage.saveFoodList(this.foods.value!!)
    }

    private fun importFoodList() {
        if(!this.storage.hasImportedFoodList()) {
            this.reImportFoodList()
            this.storage.setHasImportFoodList()
        }
    }
}