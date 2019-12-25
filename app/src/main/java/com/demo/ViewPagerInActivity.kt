package com.demo

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_viewpager_in_activity.*

/**
 * viewpager+Fragment，直接展示在activity中
 */
class ViewPagerInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_viewpager_in_activity)

        viewPagerLl_1?.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {

                return myViewPager_1.dispatchTouchEvent(event);
            }

        })

        var myFragments: MutableList<Fragment> = mutableListOf()

        myFragments.add(OneFragment())
        myFragments.add(TwoFragment())
        myFragments.add(ThreeFragment())

        myViewPager_1?.setOffscreenPageLimit(myFragments.size)

        //设置界面转变样式
        myViewPager_1?.setPageTransformer(
            true,
            ScalePageTransformer()
        )

        //给viewpager设置adapter
        myViewPager_1?.adapter = MyViewPagerAdapter(myFragments, supportFragmentManager)

        //首页viewpager
        myViewPager_1?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                //这句很关键
                viewPagerLl_1?.invalidate()

            }

            override fun onPageSelected(position: Int) {

                Toast.makeText(this@ViewPagerInActivity, "$position", Toast.LENGTH_SHORT).show()

            }

        })

    }
}
