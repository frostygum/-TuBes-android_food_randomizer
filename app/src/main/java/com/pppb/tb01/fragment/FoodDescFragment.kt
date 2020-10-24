package com.pppb.tb01.fragment

import android.os.Bundle
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
import com.pppb.tb01.viewmodel.ViewModelFactory

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

        //Instantiate View Binding
        this.binding = FragmentFoodDescBinding.inflate(inflater, container, false)
        //Instantiate Food ViewModel
        this.foodListViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //Instantiate Page ViewModel
        this.pageViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //Return current Fragment View
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Change toolbar title for current fragment
        this.pageViewModel.changeTitle("Makanan")
        //Observe changes SelectedFoodId
        this.pageViewModel.getSelectedFoodId().observe(viewLifecycleOwner, {
            //Get Food at current SelectedFoodId from ViewModel
            val food = this.foodListViewModel.getFoods().value?.get(it)
            //When Food found, create UI, if not change to prev page
            if(food != null) {
                this.updateUI(food)
            }
            else {
                pageViewModel.changePage("LIST_FOOD")
            }
        })
        //Button "Pencil" method listener
        this.binding.btnEditFood.setOnClickListener{
            this.pageViewModel.changePage("EDIT_FOOD")
        }
    }

    //Method to change UI
    private fun updateUI(food: Food) {
        this.binding.tvMenuTitle.text = food.getName()
        this.binding.tvDesc.text = food.getDescriptions()
        this.binding.tvTags.text = processArrayToLine(food.getTags())
        this.binding.tvBahan.text = processArrayToLines(food.getIngredients())
        this.binding.tvLangkah.text = processArrayToLines(food.getSteps(), true)
        this.binding.tvResto.text = processArrayToLine(food.getRestaurants())
    }

    //Method to process Array od String to Coma Separated String
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

    //Method to process Array od String to Multiline String
    private fun processArrayToLines(arr: List<String>, withNumber: Boolean = false): String {
        var str = ""
        for((i, item) in arr.withIndex()) {
            str += if(i < arr.size - 1) {
                if(withNumber) {
                    "${i+1}. $item\n"
                }
                else {
                    "$item\n"
                }
            } else {
                if(withNumber) {
                    "${i+1}. $item"
                }
                else {
                    item
                }
            }
        }
        return str
    }
}