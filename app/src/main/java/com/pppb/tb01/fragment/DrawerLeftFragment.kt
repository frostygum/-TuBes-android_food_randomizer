package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.adapter.MenuListAdapter
import com.pppb.tb01.databinding.FragmentDrawerLeftBinding
import com.pppb.tb01.model.Menu
import com.pppb.tb01.viewmodel.PageViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException

class DrawerLeftFragment(): Fragment() {
    private lateinit var binding: FragmentDrawerLeftBinding
    private lateinit var pageViewModel: PageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentDrawerLeftBinding.inflate(inflater, container, false)
        this.pageViewModel = activity?.run {
            ViewModelProvider(this).get(PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val menuList: ListView = binding.lvListMenu
        val menus = listOf<Menu>(
            Menu("Home", 1),
            Menu("Page2", 2),
            Menu("Exit", 3)
        )
        val adapter = MenuListAdapter(activity!!, menus, this.pageViewModel)
        menuList.adapter = adapter

        return binding.root
    }

    fun closeDrawer() {
        drawer_layout.closeDrawers()
    }
}