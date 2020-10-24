package com.pppb.tb01

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.pppb.tb01.databinding.ActivityMainBinding
import com.pppb.tb01.fragment.*
import com.pppb.tb01.utils.Utils
import com.pppb.tb01.viewmodel.FoodListViewModel
import com.pppb.tb01.viewmodel.PageViewModel
import com.pppb.tb01.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding : ActivityMainBinding
    //fragments
    private val homeFragment: HomeFragment = HomeFragment.newInstance()
    private val foodListFragment: FoodListFragment = FoodListFragment.newInstance()
    private val addFoodFragment: AddFoodFragment = AddFoodFragment.newInstance()
    private val foodDescFragment: FoodDescFragment = FoodDescFragment.newInstance()
    private val editFoodFragment: EditFoodFragment = EditFoodFragment.newInstance()
    private val settingFragment: SettingFragment = SettingFragment.newInstance()
    //viewModel
    private lateinit var pageViewModel: PageViewModel
    private lateinit var foodListViewModel: FoodListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        //Instantiate ViewModel with ViewModelFactory
        this.pageViewModel = ViewModelFactory().createViewModel(this, application, PageViewModel::class.java)
        //Change Theme When Activity Starts
        this.changeTheme(this.pageViewModel.getPreferredTheme().value!!)
        super.onCreate(savedInstanceState)

        //Instantiate ViewBinding
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        //Instantiate Food ViewModel
        this.foodListViewModel = ViewModelFactory().createViewModel(this, application, FoodListViewModel::class.java)
        //Create Custom ToolBar
        this.setSupportActionBar(this.binding.toolbar)

        //Observe LeftDrawer toggle state
        this.pageViewModel.getLeftDrawerState().observe(this, {
            //When FALSE Close Drawer
            this.binding.drawerLayout.closeDrawers()
        })
        //Observe Page state
        this.pageViewModel.getPage().observe(this, {
            //Update Page
            this.changePage(it)
        })
        //Observe Food Randomizer
        this.pageViewModel.getRandomizerState().observe(this, {
            //Start Randomizer
            if(it) {
                this.displayRandomFood()
            }
        })
        //Observe Exit State
        this.pageViewModel.getExitState().observe(this, {
            //Exit App
            if(it) {
                this.exit()
            }
        })
        //Observe ToolbarTitle state
        this.pageViewModel.getTitle().observe(this, {
            //Update Title
            this.changeTitle(it)
        })

        //Creating burger navigation button
        val toggle = ActionBarDrawerToggle(
            this,
            this.binding.drawerLayout,
            this.binding.toolbar,
            R.string.open_drawer,
            R.string.open_drawer
        )
        //Set Burger as Toggle Button to drawer
        this.binding.drawerLayout.addDrawerListener(toggle)

        //SyncState must be last open or close Drawer
        toggle.syncState()
    }

    //Method for update current activity Theme
    private fun changeTheme(isDarkTheme: Boolean) {
        if(isDarkTheme) {
            setTheme(R.style.DarkTheme)
        }
        else {
            setTheme(R.style.LightTheme)
        }
    }

    //Method for change current fragment view
    private fun changeFragment(frag: Fragment, tag: String, saveInBackStack: Boolean = false) {
        val manager: FragmentManager = supportFragmentManager
        //Pop current fragment if fragment inside backStack
        val fragmentPopped: Boolean = manager.popBackStackImmediate(tag, 0)
        val ft: FragmentTransaction = manager.beginTransaction()

        ft.replace(this.binding.fragmentContainer.id, frag, tag)

        if (!fragmentPopped && manager.findFragmentByTag(tag) == null) {
            if (saveInBackStack) {
                ft.addToBackStack(tag)
            }
        }

        ft.commit()
    }

    private fun changePage(pageName: String) {
        when(pageName) {
            "HOME" -> {
                this.clearBackStack()
                this.changeFragment(this.homeFragment, pageName)
            }
            "LIST_FOOD" -> {
                this.clearBackStack()
                this.changeFragment(this.foodListFragment, pageName)
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
            "SETTING" -> {
                this.changeFragment(this.settingFragment, pageName)
            }
        }
    }

    private fun changeTitle(title: String){
        this.binding.toolbar.title = title
    }

    private fun clearBackStack() {
        val fm: FragmentManager = supportFragmentManager
        for (i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }

    private fun displayRandomFood() {
        val rand = Utils.getRandomNumberFromFoodList(this.foodListViewModel.getFoods().value!!)
        if(rand > -1) {
            this.pageViewModel.setSelectedFoodId(this.foodListViewModel.getFoodAt(rand)!!.getId())
            this.pageViewModel.changePage("DESC_FOOD")
        }
        else {
            Toast.makeText(this,"No Food found at Menu, Please insert some :3", Toast.LENGTH_SHORT).show()
        }
    }

    private fun exit() {
        this.moveTaskToBack(true)
        this.finish()
    }
}


