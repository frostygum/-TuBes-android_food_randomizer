package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentAddFoodBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.viewmodel.FoodListViewModel
import java.lang.ClassCastException

class AddFoodFragment : Fragment(R.layout.fragment_add_food) {
    private lateinit var binding: FragmentAddFoodBinding
    private lateinit var listener: FragmentListener
    private lateinit var foodListViewModel: FoodListViewModel

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

        this.binding.btnAdd.setOnClickListener{
            val newFood = Food(this.binding.etAddFoodName.text.toString(), this.binding.etAddFoodDesc.text.toString())
            newFood.setIngredients(this.binding.etAddFoodIngredients.text.toString().split("\n"))
            newFood.setTags(this.binding.etAddFoodTags.text.toString().split("\n"))
            newFood.setSteps(this.binding.etAddFoodSteps.text.toString().split("\n"))
            newFood.setRestaurants(this.binding.etAddFoodRestaurants.text.toString().split("\n"))

            foodListViewModel.addFood(newFood)
            resetForm(this.binding)
            listener.changePage(2)
        }

        return this.binding.root
    }

    private fun resetForm(binding: FragmentAddFoodBinding) {
        binding.etAddFoodDesc.setText("")
        binding.etAddFoodName.setText("")
        binding.etAddFoodIngredients.setText("")
        binding.etAddFoodRestaurants.setText("")
        binding.etAddFoodSteps.setText("")
        binding.etAddFoodTags.setText("")
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