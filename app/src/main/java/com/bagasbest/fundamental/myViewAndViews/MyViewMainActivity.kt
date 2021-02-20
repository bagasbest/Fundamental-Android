package com.bagasbest.fundamental.myViewAndViews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bagasbest.fundamental.R

class MyViewMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_main)

        supportActionBar?.title = "Google Pixel"
    }
}