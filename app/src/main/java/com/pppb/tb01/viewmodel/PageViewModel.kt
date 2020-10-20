package com.pppb.tb01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel() : ViewModel() {
    private val page: MutableLiveData<Int> = MutableLiveData()
    private val leftDrawerState: MutableLiveData<Boolean> = MutableLiveData()

    init {
        changePage(1)
    }

    fun getPage() = this.page as LiveData<Int>

    fun getLeftDrawerState() = this.leftDrawerState as LiveData<Boolean>

    fun changePage(pageNumber: Int) {
        this.page.value = pageNumber
    }

    fun closeLeftDrawer() {
        this.leftDrawerState.value = false
    }
}