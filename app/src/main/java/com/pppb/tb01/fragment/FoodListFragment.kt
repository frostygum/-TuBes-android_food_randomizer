package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.adapter.FoodListAdapter
import com.pppb.tb01.databinding.FragmentFoodListBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.viewmodel.FoodListViewModel
import java.lang.ClassCastException

class FoodListFragment() : Fragment(R.layout.fragment_food_list) {
    private lateinit var binding: FragmentFoodListBinding
    private lateinit var listener: FragmentListener
    private lateinit var viewModel: FoodListViewModel

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

        viewModel = activity?.run {
            ViewModelProvider(this).get(FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val foods = viewModel.getFoods().value
        val adapter: FoodListAdapter

        adapter = if(foods != null) {
            FoodListAdapter(activity!!, foods, this.listener)
        } else {
            FoodListAdapter(activity!!, listOf(), this.listener)
        }

        viewModel.getFoods().observe(viewLifecycleOwner, {
            if(it != null) {
                adapter.update(it)
            }
            else {
                adapter.update(listOf())
            }
        })

        this.binding.lvListFood.adapter = adapter

        this.binding.fbAddFood.setOnClickListener{
            viewModel.addFood(Food("food fb", ""))
            this.listener.changePage(3)
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