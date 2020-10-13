package com.pppb.tb01.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentListMenuBinding

class ListMenuFragment: Fragment(R.layout.fragment_list_menu) {
    private lateinit var binding: FragmentListMenuBinding

    companion object {
        fun newInstance(): ListMenuFragment {
            return ListMenuFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentListMenuBinding.inflate(inflater, container, false)

        return this.binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        TODO("To be implemented soon")
    }
}