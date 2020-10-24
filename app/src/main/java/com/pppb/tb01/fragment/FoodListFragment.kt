package com.pppb.tb01.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.pppb.tb01.R
import com.pppb.tb01.adapter.FoodListAdapter
import com.pppb.tb01.databinding.FragmentFoodListBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.utils.Utils
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import com.pppb.tb01.viewmodel.ViewModelFactory

class FoodListFragment() : Fragment(R.layout.fragment_food_list) {
    private lateinit var binding: FragmentFoodListBinding
    private lateinit var foodListViewModel: FoodListViewModel
    private lateinit var pageViewModel: PageViewModel
    private lateinit var foods: List<Food>
    private lateinit var adapter: FoodListAdapter
    private lateinit var listViewFooter: View

    companion object {
        //Singleton to instantiate current fragment
        fun newInstance(): FoodListFragment {
            return FoodListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Instantiate viewBinding
        this.binding = FragmentFoodListBinding.inflate(inflater, container, false)
        //Instantiate viewModel
        this.foodListViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, FoodListViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        this.pageViewModel = activity?.run {
            ViewModelFactory().createViewModel(this, application, PageViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        //Instantiate array of Food
        this.foods = this.foodListViewModel.getFoods().value!!
        //Instantiate ListView Adapter
        this.adapter = FoodListAdapter(
            activity!!,
            this.foods,
            this.pageViewModel,
            this.foodListViewModel
        )
        //Create ListView Footer
        this.listViewFooter = View(this.context);
        this.listViewFooter.layoutParams = AbsListView.LayoutParams(
            AbsListView.LayoutParams.WRAP_CONTENT,
            370
        )

        //Return fragment view
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Change toolbar title for current fragment
        pageViewModel.changeTitle("Menu")

        //When viewModel array of Food changes will automatically update list trough adapter
        this.foodListViewModel.getFoods().observe(viewLifecycleOwner, { foods ->
            this.adapter.update(foods)

            if (foods.isEmpty() || foods.size < 8) {
                //Remove Footer to listView
                this.binding.lvListFood.removeFooterView(this.listViewFooter)
            }
        })

        //Variable to monitor if footer has been created
        var hasCreateFooter = false
        //Listener while listView Scroll
        this.binding.lvListFood.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {}
            override fun onScroll(
                view: AbsListView?, firstVisibleItem: Int,
                visibleItemCount: Int, totalItemCount: Int
            ) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0) {
                    if(totalItemCount >= 8 && !hasCreateFooter) {
                        binding.lvListFood.addFooterView(listViewFooter)
                        hasCreateFooter = true
                    }
                }
            }
        })

        //Set for current adapter
        this.binding.lvListFood.adapter = this.adapter

        //Button "Cari" for search/ filtering current food list listener
        this.binding.btnSearch.setOnClickListener{
            val keyword = this.binding.etSearch.text.toString().trim()
            //Clear search EditText
            this.binding.etSearch.setText("")
            //Filter list
            this.filterByTagsOrIngredients(keyword)
            //Hide soft keyboard
            Utils.hideSoftKeyBoard(context!!, view)
            //Remove ListView Footer
            this.binding.lvListFood.removeFooterView(this.listViewFooter)
        }

        //Listener when user typing on search EditText
        this.binding.etSearch.addTextChangedListener(object : TextWatcher {
            //Must have every override function
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //When no text on EditText, return back listView
                if (count == 0) {
                    adapter.update(foods)
                }
            }
        })

        //Button "+" addFood listener
        this.binding.fbAddFood.setOnClickListener{
            this.pageViewModel.changePage("ADD_FOOD")
        }

        //Override BackButton Method to change fragment layout to HOME
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                pageViewModel.changePage("HOME")
            }
        })
    }

    //Function to filter list by search keyword
    private fun filterByTagsOrIngredients(keyword: String) {
        //Check empty keyword
        if(keyword != "" || keyword.isNotEmpty()) {
            //Filtering array of food with custom function
            val newFoodList = this.foods.filter { food ->
                food.getTags().any { it.contains(keyword, true) } || food.getIngredients().any { it.contains(
                    keyword, true
                ) }
            }
            //Then update it to adapter, but no need update existing array of food
            this.adapter.update(newFoodList)
        }
        //If no keyword, return back the listView items
        else {
            this.adapter.update(this.foods)
        }
    }
}
