package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentAddFoodBinding
import com.pppb.tb01.databinding.FragmentEditFoodBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel

class EditFoodFragment: Fragment(R.layout.fragment_edit_food) {
    private lateinit var binding: FragmentEditFoodBinding
    private lateinit var foodListViewModel: FoodListViewModel
    private lateinit var pageViewModel: PageViewModel

    companion object {
        fun newInstance(): EditFoodFragment {
            return EditFoodFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentEditFoodBinding.inflate(inflater, container, false)

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
        pageViewModel.changeTitle("Edit")
        this.binding.btnAdd.setOnClickListener{
            val id = pageViewModel.getSelectedFoodId().value
            val newFood = Food(this.binding.etEditFoodName.text.toString().trim(), this.binding.etEditFoodDesc.text.toString().trim())
            newFood.setIngredients(this.binding.etEditFoodIngredients.text.toString().trim().split("\n"))
            newFood.setTags(this.binding.etEditFoodTags.text.toString().trim().split("\n"))
            newFood.setSteps(this.binding.etEditFoodSteps.text.toString().trim().split("\n"))
            newFood.setRestaurants(this.binding.etEditFoodRestaurants.text.toString().trim().split("\n"))

            foodListViewModel.setFoodById(newFood, id!!)
            resetForm()
            pageViewModel.changePage(4, true)
        }

        return this.binding.root
    }

    private fun updateUI(food: Food) {
        this.binding.etEditFoodName.setText(food.getName())
        this.binding.etEditFoodDesc.setText(food.getDescriptions())
        this.binding.etEditFoodTags.setText(processArrayToLines(food.getTags()))
        this.binding.etEditFoodIngredients.setText(processArrayToLines(food.getIngredients()))
        this.binding.etEditFoodSteps.setText(processArrayToLines(food.getSteps()))
        this.binding.etEditFoodRestaurants.setText(processArrayToLines(food.getRestaurants()))
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

    private fun resetForm() {
        this.binding.etEditFoodDesc.setText("")
        this.binding.etEditFoodName.setText("")
        this.binding.etEditFoodIngredients.setText("")
        this.binding.etEditFoodRestaurants.setText("")
        this.binding.etEditFoodSteps.setText("")
        this.binding.etEditFoodTags.setText("")
    }
}