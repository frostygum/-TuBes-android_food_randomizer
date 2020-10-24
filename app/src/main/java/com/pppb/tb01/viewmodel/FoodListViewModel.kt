package com.pppb.tb01.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pppb.tb01.model.Food
import com.pppb.tb01.storage.FoodListData
import com.pppb.tb01.storage.ViewStorage
import com.pppb.tb01.utils.Utils

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
        this.foodList.add(food)
        this.update()
        this.updateStorage()
    }

    fun deleteFoodAt(indexToBeDeleted: Int) {
        this.foodList.removeAt(indexToBeDeleted)
        this.update()
        this.updateStorage()
    }

    fun setFoodById(food: Food, id: Int) {
        this.foodList[id] = food
        this.update()
        this.updateStorage()
    }

    fun reImportFoodList() {
        this.foodList.addAll(FoodListData.getInitialFoodList())
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