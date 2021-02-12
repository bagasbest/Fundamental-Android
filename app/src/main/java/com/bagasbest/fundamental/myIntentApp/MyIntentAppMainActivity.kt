package com.bagasbest.fundamental.myIntentApp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.myIntentApp.model.MyIntentAppPerson
import kotlinx.android.synthetic.main.activity_my_intent_app_main.*

class MyIntentAppMainActivity : AppCompatActivity(), View.OnClickListener {


    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_intent_app_main)

        btn_move_activity.setOnClickListener(this)
        btn_move_with_data.setOnClickListener(this)
        btn_move_activity_object.setOnClickListener(this)
        btn_dial_number.setOnClickListener(this)
        btn_move_for_result_Activity.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this, MyIntentAppMoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data -> {
                val moveWithDataIntent = Intent(this, MyIntentAppMoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MyIntentAppMoveWithDataActivity.EXTRA_NAME, "Bagas Pangestu")
                moveWithDataIntent.putExtra(MyIntentAppMoveWithDataActivity.EXTRA_AGE, 21)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = MyIntentAppPerson(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )
                val moveWithObjectIntent = Intent(this, MyIntentAppMoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MyIntentAppMoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "082289538906"
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")))
            }
            R.id.btn_move_for_result_Activity -> {
                val moveForResultIntent = Intent(this, MyIntentAppMoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST_CODE)

            }

        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE) {
            if(resultCode == MyIntentAppMoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MyIntentAppMoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tv_result.text = "Hasil : $selectedValue"
            }
        }

    }

}

