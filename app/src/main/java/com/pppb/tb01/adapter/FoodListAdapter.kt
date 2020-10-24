package com.pppb.tb01.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import com.pppb.tb01.databinding.ComponentFoodItemBinding
import com.pppb.tb01.model.Food
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import java.util.*
import kotlin.collections.ArrayList

class FoodListAdapter(context: Context, data: List<Food>, private val pageViewModel: PageViewModel, private val foodListViewModel: FoodListViewModel) : ArrayAdapter<Food>(
    context,
    0,
    data
) {
    private var foodList: List<Food> = data
    private val view: Context = context

    override fun getCount(): Int {
        return foodList.size
    }

    override fun getItem(position: Int): Food {
        return foodList[position]
    }

    //Recycle List Pattern
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {val viewHolder: ViewHolder
        val itemView: View

        if (convertView == null) {
            itemView = ComponentFoodItemBinding.inflate(LayoutInflater.from(this.view)).root
            viewHolder = ViewHolder(itemView, pageViewModel, foodListViewModel)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.updateView(this.getItem(position), position)

        return itemView
    }

    //Function to update current array of food
    fun update(foods: List<Food>) {
        this.foodList = foods
        this.notifyDataSetChanged()
    }

    private class ViewHolder(private val view: View, private val pageViewModel: PageViewModel, private val foodListViewModel: FoodListViewModel) {
        //Instantiate view binding for list item
        private val binding: ComponentFoodItemBinding = ComponentFoodItemBinding.bind(view)

        fun updateView(food: Food, position: Int) {
            //Set item title using food name
            this.binding.tvFoodText.text = food.getName()
            //Set onClick listener when item in the list was clicked
            this.binding.foodItem.setOnClickListener{
                //Set current selected to viewModel then change fragment
                this.pageViewModel.setSelectedFoodId(position)
                this.pageViewModel.changePage("DESC_FOOD")
            }
            //Set onClick listener when item delete button icon in the list was clicked
            this.binding.ibTrashFood.setOnClickListener {
                Toast.makeText(this.view.context, "Delete ${this.foodListViewModel.getFoodAt(position)?.getName()}", Toast.LENGTH_SHORT).show()
                //Delete food item from list
                this.foodListViewModel.deleteFoodAt(position)
            }
        }
    }
}