package com.bagasbest.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bagasbest.fundamental.myIntentApp.MyIntentAppMainActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_intent_app.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.my_intent_app -> {
                startActivity(Intent(this, MyIntentAppMainActivity::class.java))
            }
        }
    }


}