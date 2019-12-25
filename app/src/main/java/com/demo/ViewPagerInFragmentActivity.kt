package com.demo

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

/**
 * viewpager+Fragment，展示在一个Fragment中
 */
class ViewPagerInFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_viewpager_in_fragment)

        var myFragment:MyFragment = MyFragment()

        val beginTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        if (myFragment.isAdded().not()) {
            beginTransaction.add(R.id.myLl, myFragment)
        }

        beginTransaction.show(myFragment)

        beginTransaction.commitAllowingStateLoss()


    }
}
