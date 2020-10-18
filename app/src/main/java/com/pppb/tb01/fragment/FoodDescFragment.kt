package com.pppb.tb01.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pppb.tb01.R
import com.pppb.tb01.databinding.FragmentFoodDescBinding


class FoodDescFragment() : Fragment(R.layout.fragment_food_desc) {
    private lateinit var binding: FragmentFoodDescBinding

    companion object {
        fun newInstance(foodNama: String, foodDesc: String, foodTag: ArrayList<String>, foodBahan: ArrayList<String>, foodLangkah: ArrayList<String>, foodResto: ArrayList<String>): FoodDescFragment {
            val fragment = FoodDescFragment()
            val args = Bundle()
            args.putString("namaFood", foodNama)
            args.putString("descFood", foodDesc)
            args.putStringArrayList("tagFood", foodTag)
            args.putStringArrayList("bahanFood", foodBahan)
            args.putStringArrayList("langkahFood", foodLangkah)
            args.putStringArrayList("restoFood", foodResto)

            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentFoodDescBinding.inflate(inflater, container, false)
        val menuName = "Menu: ${arguments?.getString("namaFood")}"
        val desc = "Deskripsi: ${arguments?.getString("descFood")}"
        val tagStringBuilder = StringBuilder()
        arguments?.getStringArrayList("tagFood")?.forEach {
            tagStringBuilder.append("$it\n\n")
        }
        val bahanStringBuilder = StringBuilder()
        arguments?.getStringArrayList("bahanFood")?.forEach {
            bahanStringBuilder.append("$it\n\n")
        }

        val langkahStringBuilder = StringBuilder()
        arguments?.getStringArrayList("langkahFood")?.forEach {
            langkahStringBuilder.append("$it\n\n")
        }
        val restoStringBuilder = StringBuilder()
        arguments?.getStringArrayList("restoFood")?.forEach {
            restoStringBuilder.append("$it\n\n")
        }

        this.binding.tvMenuTitle.text = menuName
        this.binding.tvDesc.text = desc
        this.binding.tvTags.text = tagStringBuilder
        this.binding.tvBahan.text = bahanStringBuilder
        this.binding.tvLangkah.text = langkahStringBuilder
        this.binding.tvResto.text = restoStringBuilder

        return this.binding.root
    }

}