package com.pppb.tb01.fragment

import com.pppb.tb01.model.Food

interface FragmentListener {
    fun changePage(pageNumber: Int)
    fun closeDrawer()
}