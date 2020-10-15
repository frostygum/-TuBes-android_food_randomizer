package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.adapter.FoodListAdapter
import com.pppb.tb01.adapter.MenuListAdapter
import com.pppb.tb01.databinding.FragmentDrawerLeftBinding
import com.pppb.tb01.databinding.FragmentFoodListBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.model.Menu
import com.pppb.tb01.viewmodel.FoodListViewModel
import java.lang.ClassCastException

class FoodListFragment() : Fragment(R.layout.fragment_food_list) {
    private lateinit var binding: FragmentFoodListBinding
    private lateinit var listener: FragmentListener
    private lateinit var foodListViewModel: FoodListViewModel

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
        this.foodListViewModel = ViewModelProvider(this).get(FoodListViewModel::class.java)

        this.foodListViewModel.getFoods().observe(viewLifecycleOwner, Observer { foods ->
            var foodList: List<Food> = listOf()

            foods.forEach { food ->
                foodList += food
            }

            val adapter = FoodListAdapter(activity!!, foodList, this.listener)
            this.binding.lvListFood.adapter = adapter
        })

        this.binding.fbAddFood.setOnClickListener{
            this.foodListViewModel.addFood(Food("Custom Add Food", "This is Custom added food desc"))
        }

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