package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentSettingBinding
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import com.pppb.tb01.viewmodel.ViewModelFactory

class SettingFragment: Fragment(R.layout.fragment_setting) {
    private lateinit var binding: FragmentSettingBinding
    private lateinit var pageViewModel: PageViewModel
    private lateinit var foodListViewModel: FoodListViewModel

    companion object {
        fun newInstance(): SettingFragment {
            return SettingFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Instantiate ViewBinding
        this.binding = FragmentSettingBinding.inflate(inflater, container, false)

        this.foodListViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        this.pageViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        this.pageViewModel.changeTitle("Setting")

        activity?.onBackPressedDispatcher?.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                pageViewModel.changePage("HOME")
            }
        })

        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.pageViewModel.getPreferredTheme().observe(viewLifecycleOwner, {
            this.binding.btnToggleTheme.setOnCheckedChangeListener(null)
            this.binding.btnToggleTheme.isChecked = it

            this.binding.btnToggleTheme.setOnCheckedChangeListener { _, isChecked ->
                this.pageViewModel.changePreferredTheme(isChecked)
                Toast.makeText(activity, "App Restart Required to make changes", Toast.LENGTH_SHORT).show()
            }

            this.binding.btnReimportFood.setOnClickListener{
                this.foodListViewModel.reImportFoodList()
                Toast.makeText(activity, "Success Re-Import Default Food Menu List", Toast.LENGTH_SHORT).show()
                this.pageViewModel.changePage("LIST_FOOD")
            }

            this.binding.btnClearFood.setOnClickListener{
                this.foodListViewModel.clearFood()
                Toast.makeText(activity, "Success Clear Food Menu List", Toast.LENGTH_SHORT).show()
            }
        })
    }
}