package com.pppb.tb01.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PageViewModel() : ViewModel() {
    private val page: MutableLiveData<Int> = MutableLiveData()

    init {
        changePage(1)
    }

    fun getPage() = page as LiveData<Int>

    fun changePage(pageNumber: Int) {
        this.page.value = pageNumber
    }
}