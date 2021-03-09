package com.bagasbest.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bagasbest.fundamental.myActionBar.MyActionBarsMainActivity
import com.bagasbest.fundamental.myDrawer.MyDrawerMainActivity
import com.bagasbest.fundamental.myFragmentApp.MyFragmentAppMainActivity
import com.bagasbest.fundamental.myIntentApp.MyIntentAppMainActivity
import com.bagasbest.fundamental.myListView.MyListViewMainActivity
import com.bagasbest.fundamental.myNavigation.MyNavigationMainActivity
import com.bagasbest.fundamental.submission1.GithubUserMainActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_intent_app.setOnClickListener(this)
        my_fragmet_app.setOnClickListener(this)
        my_list_view.setOnClickListener(this)
        submission1.setOnClickListener(this)
        my_navigation.setOnClickListener(this)
        my_option_menu.setOnClickListener(this)
        my_drawer_navigation.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.my_intent_app -> {
                startActivity(Intent(this, MyIntentAppMainActivity::class.java))
            }
            R.id.my_fragmet_app -> {
                startActivity(Intent(this, MyFragmentAppMainActivity::class.java))
            }
            R.id.my_list_view -> {
                startActivity(Intent(this, MyListViewMainActivity::class.java))
            }
            R.id.submission1 -> {
                startActivity(Intent(this, GithubUserMainActivity::class.java))
            }
            R.id.my_navigation ->  {
                startActivity(Intent(this, MyNavigationMainActivity::class.java))
            }
            R.id.my_option_menu -> {
                startActivity(Intent(this, MyActionBarsMainActivity::class.java))
            }
            R.id.my_drawer_navigation -> {
                startActivity(Intent(this, MyDrawerMainActivity::class.java))
            }
        }
    }


}