package com.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.frgament_my.*

class MyFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //先于 onViewCreated 执行
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.frgament_my, container, false);
        return view
    }

    //先于 onStart() 执行
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun init() {

        viewPagerLl_2?.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {

                return myViewPager_2.dispatchTouchEvent(event);
            }

        })

        var myFragments: MutableList<Fragment> = mutableListOf()

        myFragments.add(OneFragment())
        myFragments.add(TwoFragment())
        myFragments.add(ThreeFragment())

        myViewPager_2?.setOffscreenPageLimit(myFragments.size)

        //设置界面转变样式
        myViewPager_2?.setPageTransformer(
            true,
            ScalePageTransformer()
        )

        //给viewpager设置adapter
        myViewPager_2?.adapter = MyViewPagerAdapter(myFragments, childFragmentManager)

        //首页viewpager
        myViewPager_2?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                //有的博客中说要加这句话，但是实际测试发现，没有这个，也没异常。安全起见，还是保留
                viewPagerLl_2?.invalidate()

            }

            override fun onPageSelected(position: Int) {

                Toast.makeText(activity, "$position", Toast.LENGTH_SHORT).show()

            }

        })

    }

}