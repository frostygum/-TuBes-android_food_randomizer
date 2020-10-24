package com.pppb.tb01.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pppb.tb01.storage.ViewStorage

class PageViewModel(application: Application) : AndroidViewModel(application) {
    private val page: MutableLiveData<String> = MutableLiveData()
    private val leftDrawerState: MutableLiveData<Boolean> = MutableLiveData()
    private val selectedFoodId: MutableLiveData<Int> = MutableLiveData()
    private val title: MutableLiveData<String> = MutableLiveData()
    private val themeIsDark: MutableLiveData<Boolean> = MutableLiveData()
    private val randomizerState: MutableLiveData<Boolean> = MutableLiveData()
    private val exitState: MutableLiveData<Boolean> = MutableLiveData()
    private val storage: ViewStorage = ViewStorage(application)

    init {
        this.leftDrawerState.value = false
        this.themeIsDark.value = this.storage.getPreferredTheme()
        this.randomizerState.value = false
        changePage("HOME")
    }

    fun getPage() = this.page as LiveData<String>

    fun getLeftDrawerState() = this.leftDrawerState as LiveData<Boolean>

    fun getSelectedFoodId() = this.selectedFoodId as LiveData<Int>

    fun getTitle() = this.title as LiveData<String>

    fun getPreferredTheme() = this.themeIsDark as LiveData<Boolean>

    fun getRandomizerState() = this.randomizerState as LiveData<Boolean>

    fun getExitState() = this.exitState as LiveData<Boolean>
  
    fun changePage(pageName: String) {
        this.page.value = pageName
    }

    fun closeLeftDrawer() {
        this.leftDrawerState.value = !this.leftDrawerState.value!!
    }

    fun setSelectedFoodId(id: Int) {
        this.selectedFoodId.value = id
    }

    fun changeTitle(title: String) {
        this.title.value = title
    }

    fun changePreferredTheme(isThemeDark: Boolean) {
        this.storage.savePreferredTheme(isThemeDark)
        this.themeIsDark.value = isThemeDark
    }

    fun startRandomizer() {
        this.randomizerState.value = true
    }

    fun exitApplication() {
        this.exitState.value = true
    }
}