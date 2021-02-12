package com.bagasbest.fundamental.myIntentApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.myIntentApp.model.MyIntentAppPerson
import kotlinx.android.synthetic.main.activity_my_intent_app_main.*
import kotlinx.android.synthetic.main.activity_my_intent_app_move_with_object.*

class MyIntentAppMoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_intent_app_move_with_object)

        val person = intent.getParcelableExtra<MyIntentAppPerson>(EXTRA_PERSON) as MyIntentAppPerson
        val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
        tv_object_received.text = text

    }
}