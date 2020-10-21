package com.pppb.tb01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel() : ViewModel() {
    private val page: MutableLiveData<Pair<Int, Boolean>> = MutableLiveData()
    private val leftDrawerState: MutableLiveData<Boolean> = MutableLiveData()
    private val selectedFoodId: MutableLiveData<Int> = MutableLiveData()

    init {
        changePage(1)
    }

    fun getPage() = this.page as LiveData<Pair<Int, Boolean>>

    fun getLeftDrawerState() = this.leftDrawerState as LiveData<Boolean>

    fun getSelectedFoodId() = this.selectedFoodId as LiveData<Int>

    fun getTittle() = this.page as MutableLiveData<String>

    fun changePage(pageNumber: Int) {
        this.page.value = pageNumber
    fun changePage(pageNumber: Int, popBackStack: Boolean = false) {
        this.page.value = Pair(pageNumber, popBackStack)
    }

    fun closeLeftDrawer() {
        this.leftDrawerState.value = false
    }

    fun setSelectedFoodId(id: Int) {
        this.selectedFoodId.value = id
    }
}