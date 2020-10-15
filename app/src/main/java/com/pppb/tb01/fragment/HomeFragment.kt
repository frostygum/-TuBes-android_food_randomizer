package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentHomeBinding
import java.lang.ClassCastException

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var listener: FragmentListener

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentHomeBinding.inflate(inflater, container, false)

        this.binding.btnHomeCari.setOnClickListener {
            this.listener.changePage(2)
        }

        return this.binding.root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is FragmentListener) {
            this.listener = context
        }
        else {
            throw ClassCastException("$context must implement FragmentListener")
        }
    }
}