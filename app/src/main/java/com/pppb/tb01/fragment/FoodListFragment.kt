package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.R
import com.pppb.tb01.adapter.FoodListAdapter
import com.pppb.tb01.databinding.FragmentFoodListBinding
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import java.lang.ClassCastException

class FoodListFragment() : Fragment(R.layout.fragment_food_list) {
    private lateinit var binding: FragmentFoodListBinding
    private lateinit var listener: FragmentListener
    private lateinit var foodListViewModel: FoodListViewModel
    private lateinit var pageViewModel: PageViewModel

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

        foodListViewModel = activity?.run {
            ViewModelProvider(this).get(FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        pageViewModel = activity?.run {
            ViewModelProvider(this).get(PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        val foods = foodListViewModel.getFoods().value
        val adapter: FoodListAdapter

        adapter = if(foods != null) {
            FoodListAdapter(activity!!, foods, this.listener)
        } else {
            FoodListAdapter(activity!!, listOf(), this.listener)
        }

        foodListViewModel.getFoods().observe(viewLifecycleOwner, {
            if(it != null) {
                adapter.update(it)
            }
            else {
                adapter.update(listOf())
            }
        })

        this.binding.lvListFood.adapter = adapter

        this.binding.fbAddFood.setOnClickListener{
            pageViewModel.changePage(3)
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