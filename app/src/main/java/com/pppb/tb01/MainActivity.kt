package com.pppb.tb01

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.databinding.ActivityMainBinding
import com.pppb.tb01.fragment.AddFoodFragment
import com.pppb.tb01.fragment.FoodListFragment
import com.pppb.tb01.fragment.FragmentListener
import com.pppb.tb01.fragment.HomeFragment
import com.pppb.tb01.viewmodel.PageViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentListener {
    private lateinit var binding : ActivityMainBinding
    //fragments
    private val homeFragment: HomeFragment = HomeFragment.newInstance()
    private val foodListFragment: FoodListFragment = FoodListFragment.newInstance()
    private val addFoodFragment: AddFoodFragment = AddFoodFragment.newInstance()
    private val fragments: List<Fragment> = listOf(homeFragment, foodListFragment, addFoodFragment)
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
            if(!it) {
                this.binding.drawerLayout.closeDrawers()
            }
        })

        pageViewModel.getPage().observe(this, {
            changePage(it)
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

    private fun changePage(pageNumber: Int) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        val container: Int = this.binding.fragmentContainer.id

        if(this.fragments[pageNumber - 1].isAdded) {
            ft.show(this.fragments[pageNumber - 1])
        }
        else {
            if(pageNumber > 1) {
                ft.add(container, this.fragments[pageNumber - 1]).addToBackStack(null)
            }
            else {
                ft.add(container, this.fragments[pageNumber - 1])
            }
        }

        for((i, fragment) in fragments.withIndex()) {
            if(i + 1 != pageNumber) {
                if(fragment.isAdded) {
                    ft.hide(fragment)
                }
            }
        }

        ft.commit()
    }
}