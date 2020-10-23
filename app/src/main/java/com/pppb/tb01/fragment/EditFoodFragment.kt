package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentEditFoodBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.utils.Utils
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import com.pppb.tb01.viewmodel.ViewModelFactory

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
        //Instantiate View Binding
        this.binding = FragmentEditFoodBinding.inflate(inflater, container, false)
        //Instantiate Food list ViewModel
        this.foodListViewModel = activity?.run {
            ViewModelProvider(this).get(FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //Instantiate Page list ViewModel
        this.pageViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //Return current Fragment View
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Set Toolbar title for current Fragment
        this.pageViewModel.changeTitle("Edit Makanan")
        //Observe SelectedFoodId changes
        this.pageViewModel.getSelectedFoodId().observe(viewLifecycleOwner, {
            //Get list of foods
            val foods = this.foodListViewModel.getFoods().value
            //Get current selected food
            val food = foods?.get(this.pageViewModel.getSelectedFoodId().value!!)
            //When Food Found, update UI, if not back to prev page
            if(food != null) {
                this.updateUI(food)
            }
            else {
                this.pageViewModel.changePage("LIST_FOOD")
            }
        })

        //Button "SAVE" method listener
        this.binding.btnSave.setOnClickListener{
            //Get selected item id
            val id = this.pageViewModel.getSelectedFoodId().value
            //Create tmp Food based on current selected item id
            val newFood = Food(this.binding.etEditFoodName.text.toString().trim(), this.binding.etEditFoodDesc.text.toString().trim())
                newFood.setIngredients(this.binding.etEditFoodIngredients.text.toString().trim().split("\n"))
                newFood.setTags(this.binding.etEditFoodTags.text.toString().trim().split("\n"))
                newFood.setSteps(this.binding.etEditFoodSteps.text.toString().trim().split("\n"))
                newFood.setRestaurants(this.binding.etEditFoodRestaurants.text.toString().trim().split("\n"))
            //Update Array of Food in ViewModel with newly edited Food
            this.foodListViewModel.setFoodById(newFood, id!!)
            //Reset text input
            this.resetForm()
            //Close Keyboard
            Utils.hideSoftKeyBoard(context!!, view)
            //Change Fragment
            this.pageViewModel.changePage("DESC_FOOD")
        }
    }

    //Method to create UI
    private fun updateUI(food: Food) {
        this.binding.etEditFoodName.setText(food.getName())
        this.binding.etEditFoodDesc.setText(food.getDescriptions())
        this.binding.etEditFoodTags.setText(processArrayToLines(food.getTags()))
        this.binding.etEditFoodIngredients.setText(processArrayToLines(food.getIngredients()))
        this.binding.etEditFoodSteps.setText(processArrayToLines(food.getSteps()))
        this.binding.etEditFoodRestaurants.setText(processArrayToLines(food.getRestaurants()))
    }

    //Method to process Array od String to Multiline String
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

    //Method to reset EditText text input
    private fun resetForm() {
        this.binding.etEditFoodDesc.setText("")
        this.binding.etEditFoodName.setText("")
        this.binding.etEditFoodIngredients.setText("")
        this.binding.etEditFoodRestaurants.setText("")
        this.binding.etEditFoodSteps.setText("")
        this.binding.etEditFoodTags.setText("")
    }
}