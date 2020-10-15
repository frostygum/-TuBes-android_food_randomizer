package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.pppb.tb01.R
import com.pppb.tb01.adapter.FoodListAdapter
import com.pppb.tb01.adapter.MenuListAdapter
import com.pppb.tb01.databinding.FragmentDrawerLeftBinding
import com.pppb.tb01.databinding.FragmentFoodListBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.model.Menu
import java.lang.ClassCastException

class FoodListFragment() : Fragment(R.layout.fragment_food_list) {
    private lateinit var binding: FragmentFoodListBinding
    private lateinit var listener: FragmentListener

    companion object {
        fun newInstance(): FoodListFragment {
            return FoodListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentFoodListBinding.inflate(inflater, container, false)
        val foodList: ListView = binding.lvListFood
        val foods = listOf<Food>(
            Food("Menu 1", "menu 1"),
            Food("Menu 2", "Menu 2"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3"),
            Food("Menu 3", "Menu 3")
        )
        val adapter = FoodListAdapter(activity!!, foods, this.listener)
        foodList.adapter = adapter

        return this.binding.root
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