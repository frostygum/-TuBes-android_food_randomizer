package com.pppb.tb01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel() : ViewModel() {
    private val page: MutableLiveData<String> = MutableLiveData()
    private val leftDrawerState: MutableLiveData<Boolean> = MutableLiveData()
    private val selectedFoodId: MutableLiveData<Int> = MutableLiveData()
    private val title: MutableLiveData<String> = MutableLiveData()

    init {
        changePage("HOME")
    }

    fun getPage() = this.page as LiveData<String>

    fun getLeftDrawerState() = this.leftDrawerState as LiveData<Boolean>

    fun getSelectedFoodId() = this.selectedFoodId as LiveData<Int>

    fun getTitle() = this.title as LiveData<String>

    fun changePage(pageName: String) {
        this.page.value = pageName
    }

    fun closeLeftDrawer() {
        this.leftDrawerState.value = false
    }

    fun setSelectedFoodId(id: Int) {
        this.selectedFoodId.value = id
    }

    fun changeTitle(title: String){
        this.title.value = title
    }
}