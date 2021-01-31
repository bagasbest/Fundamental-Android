package com.bagasbest.fundamental.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.bagasbest.fundamental.R
import kotlinx.android.synthetic.main.activity_volume_count_app.*

class VolumeCountApp : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val STATE_RESULT = "state_result";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.putString(STATE_RESULT, resultTv.text.toString())
        setContentView(R.layout.activity_volume_count_app)

        if(savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            resultTv.text = result
        }

        val actionBar = supportActionBar;
        actionBar?.title = "Volume Count App"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        calculateBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.calculateBtn) {
            val width = widthEt.text.toString().trim()
            val height = heightEt.text.toString().trim()
            val length = lengthEt.text.toString().trim()


            var isEmptyFields = false

            when {
                width.isEmpty() -> {
                    isEmptyFields = true;
                    widthEt.error = "Kosong";
                }
                height.isEmpty() -> {
                    isEmptyFields = true;
                    heightEt.error = "Kosong";
                }
                length.isEmpty() -> {
                    isEmptyFields = true;
                    lengthEt.error = "Kosong";
                }

            }

            if (!isEmptyFields) {

                val volume = width.toDouble() * height.toDouble() * length.toDouble()
                println("volume: $volume");

                resultTv.text = volume.toString()
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}