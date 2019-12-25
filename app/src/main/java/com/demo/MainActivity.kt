package com.demo

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        toActivity_1?.setOnClickListener {

            startActivity(Intent(this, ViewPagerInActivity::class.java))

        }

        toActivity_2?.setOnClickListener {

            startActivity(Intent(this, ViewPagerInFragmentActivity::class.java))

        }


    }
}
