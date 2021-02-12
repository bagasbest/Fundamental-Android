package com.bagasbest.fundamental.myIntentApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bagasbest.fundamental.R
import kotlinx.android.synthetic.main.activity_my_intent_app_move_with_data.*

class MyIntentAppMoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_AGE = "age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_intent_app_move_with_data)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Name: $name, your age: $age"
        tv_data_received.text = text
    }
}