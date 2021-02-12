package com.bagasbest.fundamental.myFragmentApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bagasbest.fundamental.R

class MyFragmentAppMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_fragment_app_main)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = MyFragmentAppHomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(MyFragmentAppHomeFragment::class.java.simpleName)

        if(fragment !is MyFragmentAppHomeFragment) {
            Log.d("MyFlexibleFragment", "FragmentName : " + MyFragmentAppHomeFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mHomeFragment, MyFragmentAppHomeFragment::class.java.simpleName)
                .commit()
        }

    }
}