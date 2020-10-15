package com.pppb.tb01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.pppb.tb01.databinding.ActivityMainBinding
import com.pppb.tb01.fragment.FragmentListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentListener {
    private lateinit var binding : ActivityMainBinding

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
    }

    override fun closeDrawer() {
        this.drawer_layout.closeDrawers()
    }

    override fun changePage(pageNumber: Int) {
        TODO("on next update")
    }
}