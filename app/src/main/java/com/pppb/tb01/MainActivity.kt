package com.pppb.tb01

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.databinding.ActivityMainBinding
import com.pppb.tb01.fragment.*
import com.pppb.tb01.viewmodel.PageViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding : ActivityMainBinding
    //fragments
    private val homeFragment: HomeFragment = HomeFragment.newInstance()
    private val foodListFragment: FoodListFragment = FoodListFragment.newInstance()
    private val addFoodFragment: AddFoodFragment = AddFoodFragment.newInstance()
    private val foodDescFragment: FoodDescFragment = FoodDescFragment.newInstance()
    private val editFoodFragment: EditFoodFragment = EditFoodFragment.newInstance()
    //viewModel
    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java)

        //Bikin custom ActionBar
        this.setSupportActionBar(this.binding.toolbar)

        pageViewModel.getLeftDrawerState().observe(this, {
            if (!it) {
                this.binding.drawerLayout.closeDrawers()
            }
        })

        pageViewModel.getPage().observe(this, {
            changePage(it.first, it.second)
        })

        pageViewModel.getTitle().observe(this, {
            changeTitle(it)
        })

        //Creating burger navigation button
        val toggle = ActionBarDrawerToggle(
            this,
            this.binding.drawerLayout,
            this.binding.toolbar,
            R.string.open_drawer,
            R.string.open_drawer
        )
        drawer_layout.addDrawerListener(toggle)

        //SyncState must be last open or close Drawer
        toggle.syncState()
    }

    private fun changeFragment(frag: Fragment, tag: String, saveInBackStack: Boolean = false) {
        val manager: FragmentManager = supportFragmentManager
        //Pop current fragment if fragment inside backStack
        val fragmentPopped: Boolean = manager.popBackStackImmediate(tag, 0)
        val ft: FragmentTransaction = manager.beginTransaction()

        if (!fragmentPopped && manager.findFragmentByTag(tag) == null) {
            ft.replace(this.binding.fragmentContainer.id, frag, tag)
            if (saveInBackStack) {
                ft.addToBackStack(tag)
            }
        } else {
            ft.replace(this.binding.fragmentContainer.id, frag, tag)
        }

        ft.commit()
    }

    private fun changePage(pageName: String, popBackStack: Boolean) {
        when(pageName) {
            "HOME" -> {
                this.changeFragment(this.homeFragment, pageName)
            }
            "LIST_FOOD" -> {
                this.changeFragment(this.foodListFragment, pageName, true)
            }
            "ADD_FOOD" -> {
                this.changeFragment(this.addFoodFragment, pageName, true)
            }
            "DESC_FOOD" -> {
                this.changeFragment(this.foodDescFragment, pageName, true)
            }
            "EDIT_FOOD" -> {
                this.changeFragment(this.editFoodFragment, pageName, true)
            }
        }
    }

    private fun changeTitle(title: String){
        this.binding.toolbar.title = title
    }
}


