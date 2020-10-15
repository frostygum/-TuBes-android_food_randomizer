package com.pppb.tb01.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.pppb.tb01.databinding.ComponentMenuItemBinding
import com.pppb.tb01.fragment.FragmentListener
import com.pppb.tb01.model.Menu

class MenuListAdapter(context: Context, data: List<Menu>, private val listener: FragmentListener) : ArrayAdapter<Menu>(context, 0, data) {
    private val menuList: List<Menu> = data
    private val view: Context = context

    override fun getItem(position: Int): Menu {
        return menuList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {val viewHolder: ViewHolder
        val itemView: View

        if (convertView == null) {
            itemView = ComponentMenuItemBinding.inflate(LayoutInflater.from(this.view)).root
            viewHolder = ViewHolder(itemView, listener)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.updateView(this.getItem(position))

        return itemView
    }

    private class ViewHolder(view: View,  private val listener: FragmentListener) {
        private val binding: ComponentMenuItemBinding = ComponentMenuItemBinding.bind(view)

        fun updateView(menu: Menu) {
            this.binding.tvMenuText.text = menu.getName()

            this.binding.foodList.setOnClickListener{
                when(menu.getId()) {
                    1 -> this.listener.changePage(1)
                    2 -> this.listener.changePage(2)
                }
                this.listener.closeDrawer()
            }
        }
    }
}