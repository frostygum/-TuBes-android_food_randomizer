package com.pppb.tb01

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pppb.tb01.databinding.FragmentHomeBinding

class MainFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentHomeBinding.inflate(inflater, container, false)

        this.binding.btnHomeCari.setOnClickListener {

        }

        return this.binding.root
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        //nunggu fragment listenernya dulu
    }
}