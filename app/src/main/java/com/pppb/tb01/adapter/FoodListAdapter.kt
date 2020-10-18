package com.pppb.tb01.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.pppb.tb01.databinding.ComponentFoodItemBinding
import com.pppb.tb01.fragment.FragmentListener
import com.pppb.tb01.model.Food

class FoodListAdapter(context: Context, data: List<Food>, private val listener: FragmentListener) : ArrayAdapter<Food>(context, 0, data) {
    private var foodList: List<Food> = data
    private val view: Context = context

    override fun getItem(position: Int): Food {
        return foodList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {val viewHolder: ViewHolder
        val itemView: View

        if (convertView == null) {
            itemView = ComponentFoodItemBinding.inflate(LayoutInflater.from(this.view)).root
            viewHolder = ViewHolder(itemView, listener)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.updateView(this.getItem(position))

        return itemView
    }

    fun update(foods: List<Food>) {
        this.foodList = foods
        this.notifyDataSetChanged()
    }

    private class ViewHolder(view: View, private val listener: FragmentListener) {
        private val binding: ComponentFoodItemBinding = ComponentFoodItemBinding.bind(view)

        fun updateView(food: Food) {
            this.binding.tvFoodText.text = food.getName()
        }
    }
}