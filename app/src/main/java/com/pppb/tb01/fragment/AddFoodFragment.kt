package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentAddFoodBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.utils.Utils
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import com.pppb.tb01.viewmodel.ViewModelFactory

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
        //Instantiate View Binding
        this.binding = FragmentAddFoodBinding.inflate(inflater, container, false)
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
        //Set Toolbar title for current Fragment
        pageViewModel.changeTitle("Add Makanan")
        //Button "ADD" method listener
        this.binding.btnAdd.setOnClickListener{
            //Create tmp Food
            val newFood = Food(this.binding.etAddFoodName.text.toString().trim(), this.binding.etAddFoodDesc.text.toString().trim())
                newFood.setIngredients(this.binding.etAddFoodIngredients.text.toString().trim().split("\n"))
                newFood.setTags(this.binding.etAddFoodTags.text.toString().trim().split("\n"))
                newFood.setSteps(this.binding.etAddFoodSteps.text.toString().trim().split("\n"))
                newFood.setRestaurants(this.binding.etAddFoodRestaurants.text.toString().trim().split("\n"))
            //Add tmp Food to ViewModel
            this.foodListViewModel.addFood(newFood)
            //Clear EditText input
            this.resetForm()
            //Close Keyboard
            Utils.hideSoftKeyBoard(context!!, view)
            //Change Fragment
            this.pageViewModel.changePage("LIST_FOOD")
        }
    }

    //Method to clear EditText input
    private fun resetForm() {
        this.binding.etAddFoodDesc.setText("")
        this.binding.etAddFoodName.setText("")
        this.binding.etAddFoodIngredients.setText("")
        this.binding.etAddFoodRestaurants.setText("")
        this.binding.etAddFoodSteps.setText("")
        this.binding.etAddFoodTags.setText("")
    }
}