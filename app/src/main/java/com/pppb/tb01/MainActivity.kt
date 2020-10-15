package com.pppb.tb01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.pppb.tb01.databinding.ActivityMainBinding
import com.pppb.tb01.fragment.FoodListFragment
import com.pppb.tb01.fragment.FragmentListener
import com.pppb.tb01.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentListener {
    private lateinit var binding : ActivityMainBinding
    private val homeFragment: HomeFragment = HomeFragment.newInstance()
    private val foodListFragment: FoodListFragment = FoodListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        //Bikin custom ActionBar
        this.setSupportActionBar(this.binding.toolbar)
        //Tombol Garis Tiga
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open_drawer, R.string.close_drawer)
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

        when (pageNumber) {
            1 -> {
                if (this.homeFragment.isAdded) {
                    ft.show(this.homeFragment)
                } else {
                    ft.add(container, this.homeFragment)
                }

                if (this.foodListFragment.isAdded) {
                    ft.hide(this.foodListFragment)
                }
            }
            2 -> {
                if (this.foodListFragment.isAdded) {
                    ft.show(this.foodListFragment)
                } else {
                    ft.add(container, this.foodListFragment).addToBackStack(null)
                }

                if (this.homeFragment.isAdded) {
                    ft.hide(this.homeFragment)
                }
            }
            else -> {
                TODO("no main fragment")
            }
        }

        ft.commit()
    }
}