package com.demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyViewPagerAdapter(
    private var list: MutableList<Fragment>,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {

        return list[position]

    }


    override fun getCount(): Int {
        return list.size

    }

}