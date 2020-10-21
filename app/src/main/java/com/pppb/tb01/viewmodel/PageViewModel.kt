package com.pppb.tb01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel() : ViewModel() {
    private val page: MutableLiveData<Int> = MutableLiveData()
    private val leftDrawerState: MutableLiveData<Boolean> = MutableLiveData()
    private val selectedFoodId: MutableLiveData<Int> = MutableLiveData()

    init {
        changePage(1)
    }

    fun getPage() = this.page as LiveData<Int>

    fun getLeftDrawerState() = this.leftDrawerState as LiveData<Boolean>

    fun getSelectedFoodId() = this.selectedFoodId as LiveData<Int>

    fun getTittle() = this.page as MutableLiveData<String>

    fun changePage(pageNumber: Int) {
        this.page.value = pageNumber
    }

    fun closeLeftDrawer() {
        this.leftDrawerState.value = false
    }

    fun setSelectedFoodId(id: Int) {
        this.selectedFoodId.value = id
    }
}