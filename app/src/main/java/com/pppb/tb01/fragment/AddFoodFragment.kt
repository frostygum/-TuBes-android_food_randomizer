package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentAddFoodBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel

class AddFoodFragment : Fragment(R.layout.fragment_add_food) {
    private lateinit var binding: FragmentAddFoodBinding
    private lateinit var foodListViewModel: FoodListViewModel
    private lateinit var pageViewModel: PageViewModel

    companion object {
        fun newInstance(): AddFoodFragment {
            return AddFoodFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentAddFoodBinding.inflate(inflater, container, false)

        foodListViewModel = activity?.run {
            ViewModelProvider(this).get(FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        pageViewModel = activity?.run {
            ViewModelProvider(this).get(PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        pageViewModel.changeTitle("Add Food")
        this.binding.btnAdd.setOnClickListener{
            val newFood = Food(this.binding.etAddFoodName.text.toString().trim(), this.binding.etAddFoodDesc.text.toString().trim())
            newFood.setIngredients(this.binding.etAddFoodIngredients.text.toString().trim().split("\n"))
            newFood.setTags(this.binding.etAddFoodTags.text.toString().trim().split("\n"))
            newFood.setSteps(this.binding.etAddFoodSteps.text.toString().trim().split("\n"))
            newFood.setRestaurants(this.binding.etAddFoodRestaurants.text.toString().trim().split("\n"))

            foodListViewModel.addFood(newFood)
            resetForm()
            pageViewModel.changePage(2, true)
        }

        return this.binding.root
    }

    private fun resetForm() {
        this.binding.etAddFoodDesc.setText("")
        this.binding.etAddFoodName.setText("")
        this.binding.etAddFoodIngredients.setText("")
        this.binding.etAddFoodRestaurants.setText("")
        this.binding.etAddFoodSteps.setText("")
        this.binding.etAddFoodTags.setText("")
    }
}