package com.pppb.tb01

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pppb.tb01.databinding.ActivityMainBinding
import com.pppb.tb01.fragment.FoodListFragment
import com.pppb.tb01.fragment.FragmentListener
import com.pppb.tb01.fragment.HomeFragment
import com.pppb.tb01.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentListener {
    private lateinit var binding : ActivityMainBinding
    //fragments
    private val homeFragment: HomeFragment = HomeFragment.newInstance()
    private val foodListFragment: FoodListFragment = FoodListFragment.newInstance()

    private val fragments: List<Fragment> = listOf(homeFragment, foodListFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        //Bikin custom ActionBar
        this.setSupportActionBar(this.binding.toolbar)
        //Tombol Garis Tiga
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.open_drawer,
            R.string.open_drawer
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        changePage(1)
    }

    override fun closeDrawer() {
        this.drawer_layout.closeDrawers()
    }

    override fun changePage(pageNumber: Int) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        val container: Int = this.binding.fragmentContainer.id

//        when(pageNumber) {
//            1 -> {
//                if (this.homeFragment.isAdded) {
//                    ft.show(this.homeFragment)
//                } else {
//                    ft.add(container, this.homeFragment)
//                }
//
//                if (this.foodListFragment.isAdded) {
//                    ft.hide(this.foodListFragment)
//                }
//            }
//            2 -> {
//                if (this.foodListFragment.isAdded) {
//                    ft.show(this.foodListFragment)
//                } else {
//                    ft.add(container, this.foodListFragment).addToBackStack(null)
//                }
//
//                if (this.homeFragment.isAdded) {
//                    ft.hide(this.homeFragment)
//                }
//            }
//        }

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