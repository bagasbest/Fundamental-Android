package com.bagasbest.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bagasbest.fundamental.screens.VolumeCountApp
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        volumeCountAppBtn.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.volumeCountAppBtn) {
            startActivity(Intent(this, VolumeCountApp::class.java))
        }
    }


}