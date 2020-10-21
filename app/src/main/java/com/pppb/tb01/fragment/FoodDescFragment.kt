package com.pppb.tb01.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentFoodDescBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel

class FoodDescFragment() : Fragment(R.layout.fragment_food_desc) {
    private lateinit var binding: FragmentFoodDescBinding
    private lateinit var foodListViewModel: FoodListViewModel
    private lateinit var pageViewModel: PageViewModel

    companion object {
        fun newInstance(): FoodDescFragment {
            return FoodDescFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentFoodDescBinding.inflate(inflater, container, false)

        foodListViewModel = activity?.run {
            ViewModelProvider(this).get(FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        pageViewModel = activity?.run {
            ViewModelProvider(this).get(PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        pageViewModel.getSelectedFoodId().observe(viewLifecycleOwner, {
            val foods = foodListViewModel.getFoods().value
            val food = foods?.get(it)

            if(food != null) {
                updateUI(food)
            }
            else {
                pageViewModel.changePage(2, true)
            }
        })

        foodListViewModel.getFoods().observe(viewLifecycleOwner, {
            val foods = it
            val food = foods?.get(pageViewModel.getSelectedFoodId().value!!)

            if(food != null) {
                updateUI(food)
            }
            else {
                pageViewModel.changePage(2, true)
            }
        })

        pageViewModel.changeTitle("Menu")

        this.binding.btnEditFood.setOnClickListener{
            pageViewModel.changePage(5)
        }

        return this.binding.root
    }

    private fun updateUI(food: Food) {
        this.binding.tvMenuTitle.text = food.getName()
        this.binding.tvDesc.text = food.getDescriptions()
        this.binding.tvTags.text = processArrayToLine(food.getTags())
        this.binding.tvBahan.text = processArrayToLines(food.getIngredients())
        this.binding.tvLangkah.text = processArrayToLines(food.getSteps())
        this.binding.tvResto.text = processArrayToLines(food.getRestaurants())
    }

    private fun processArrayToLine(arr: List<String>): String {
        var str = ""
        for((i, item) in arr.withIndex()) {
            str += if(i < arr.size - 1) {
                "$item, "
            } else {
                item
            }
        }
        return str
    }

    private fun processArrayToLines(arr: List<String>): String {
        var str = ""
        for((i, item) in arr.withIndex()) {
            str += if(i < arr.size - 1) {
                "$item\n"
            } else {
                item
            }
        }
        return str
    }

}