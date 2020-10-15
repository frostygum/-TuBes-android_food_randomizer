package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.pppb.tb01.adapter.MenuListAdapter
import com.pppb.tb01.databinding.FragmentDrawerLeftBinding
import com.pppb.tb01.model.Menu
import java.lang.ClassCastException

class DrawerLeftFragment(): Fragment() {
    private lateinit var listener: FragmentListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDrawerLeftBinding.inflate(inflater, container, false)
        val menuList: ListView = binding.lvListMenu
        val menus = listOf<Menu>(
            Menu("Home", 1),
            Menu("Page2", 2),
            Menu("Exit", 3)
        )
        val adapter = MenuListAdapter(activity!!, menus, this.listener)
        menuList.adapter = adapter

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is FragmentListener) {
            this.listener = context
        }
        else {
            throw ClassCastException("$context must implement FragmentListener")
        }
    }
}