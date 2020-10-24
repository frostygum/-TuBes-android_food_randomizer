package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentHomeBinding
import com.pppb.tb01.utils.Utils
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import com.pppb.tb01.viewmodel.ViewModelFactory

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var pageViewModel: PageViewModel
    private lateinit var foodListViewModel: FoodListViewModel

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Instantiate ViewBinding
        this.binding = FragmentHomeBinding.inflate(inflater, container, false)
        //Instantiate viewModel
        this.foodListViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //Instantiate Page ViewModel
        this.pageViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //Return current Fragment
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Change toolbar title for current fragment
        this.pageViewModel.changeTitle("Home")
        //Button Search method listener
        this.binding.btnHomeCari.setOnClickListener {
            this.pageViewModel.startRandomizer()
        }
    }
}