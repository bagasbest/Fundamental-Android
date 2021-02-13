package com.bagasbest.fundamental.myTestingApp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bagasbest.fundamental.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_my_testing_app_main.*

class MyTestingAppMainActivity : AppCompatActivity(), View.OnClickListener {

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_testing_app_main)

        btn_Set_value.setOnClickListener(this)

        names.add("Bagas Pangestu")
        names.add("Yoza")
        names.add("Randi")


        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/3/3f/Fronalpstock_big.jpg").into(img_preview)

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {
        if(view.id == R.id.btn_Set_value) {
           Log.d("Main Activity", names.toString())
            val name = StringBuilder()
            for(i in 0..2) {
                name.append(names[i]).append("\n")
            }
            tv_text.text = name.toString()
        }
    }
}