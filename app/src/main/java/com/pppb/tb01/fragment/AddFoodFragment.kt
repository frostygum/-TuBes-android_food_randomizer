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

        this.binding.btnAdd.setOnClickListener{
            val foodListViewModel = ViewModelProvider(this).get(FoodListViewModel::class.java)
            foodListViewModel.addFood(Food("food from other fragment", ""))
            Log.d("Debug", "click")
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