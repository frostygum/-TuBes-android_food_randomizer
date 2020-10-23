package com.pppb.tb01.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.pppb.tb01.databinding.ComponentMenuItemBinding
import com.pppb.tb01.model.Menu
import com.pppb.tb01.viewmodel.PageViewModel

class MenuListAdapter(context: Context, data: List<Menu>, private val pageViewModel: PageViewModel) : ArrayAdapter<Menu>(context, 0, data) {
    private val menuList: List<Menu> = data
    private val view: Context = context

    override fun getCount(): Int {
        return menuList.size
    }

    override fun getItem(position: Int): Menu {
        return menuList[position]
    }

    //Recycle List Pattern
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {val viewHolder: ViewHolder
        val itemView: View

        if (convertView == null) {
            itemView = ComponentMenuItemBinding.inflate(LayoutInflater.from(this.view)).root
            viewHolder = ViewHolder(itemView, pageViewModel)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.updateView(this.getItem(position))

        return itemView
    }

    private class ViewHolder(view: View,  private val pageViewModel: PageViewModel) {
        private val binding: ComponentMenuItemBinding = ComponentMenuItemBinding.bind(view)

        fun updateView(menu: Menu) {
            //Instantiate View Binding for Menu Item
            this.binding.tvMenuText.text = menu.getName()
            //Listener when Clicked Menu
            this.binding.menuList.setOnClickListener{
                when(menu.getId()) {
                    1 -> pageViewModel.changePage("HOME")
                    2 -> {}
                    3 -> pageViewModel.changePage("LIST_FOOD")
                    4 -> pageViewModel.changePage("SETTING")
                    5 -> {}
                    else -> {
                        Log.d("DEBUG", "BTN CLICK")
                    }
                }
                //Close Drawer
                pageViewModel.closeLeftDrawer()
            }
        }
    }
}