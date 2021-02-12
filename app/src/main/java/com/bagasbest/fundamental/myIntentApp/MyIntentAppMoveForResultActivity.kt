package com.bagasbest.fundamental.myIntentApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bagasbest.fundamental.R
import kotlinx.android.synthetic.main.activity_my_intent_app_move_for_result.*

class MyIntentAppMoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_intent_app_move_for_result)

        btn_choose.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_choose) {
            if(rg_number.checkedRadioButtonId > 0) {
                var value = 0
                when (rg_number.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
                val resultIntent = Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}