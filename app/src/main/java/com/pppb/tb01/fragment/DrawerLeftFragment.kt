package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.pppb.tb01.adapter.MenuListAdapter
import com.pppb.tb01.databinding.FragmentDrawerLeftBinding
import com.pppb.tb01.model.Menu
import com.pppb.tb01.viewmodel.PageViewModel
import com.pppb.tb01.viewmodel.ViewModelFactory

class DrawerLeftFragment(): Fragment() {
    private lateinit var binding: FragmentDrawerLeftBinding
    private lateinit var pageViewModel: PageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Instantiate ViewBinding
        this.binding = FragmentDrawerLeftBinding.inflate(inflater, container, false)
        //Instantiate Page ViewModel
        this.pageViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        //Create List of Menu for Drawer
        val menus = listOf<Menu>(
            Menu("Home", 1),
            Menu("Cari", 2),
            Menu("Menu", 3),
            Menu("Setting", 4),
            Menu("Exit", 5)
        )
        //Create Adapter
        val adapter = MenuListAdapter(activity!!, menus, this.pageViewModel)
        //Set Adapter to ListView
        this.binding.lvListMenu.adapter = adapter
        //Return current Fragment View
        return binding.root
    }
}