package com.bagasbest.fundamental.myUnitTesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bagasbest.fundamental.R
import com.bagasbest.fundamental.myUnitTesting.model.MyUnitTestingCuboidModel
import com.bagasbest.fundamental.myUnitTesting.viewModel.MyUnitTestingMainViewModel
import kotlinx.android.synthetic.main.activity_my_unit_testing_main.*

class MyUnitTestingMainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MyUnitTestingMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_unit_testing_main)

        mainViewModel = MyUnitTestingMainViewModel(MyUnitTestingCuboidModel())

        btn_save.setOnClickListener(this)
        btn_calculate_surface_area.setOnClickListener(this)
        btn_calculate_circumference.setOnClickListener(this)
        btn_calculate_volume.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val length = et_length.text.toString().trim()
        val width = et_width.text.toString().trim()
        val height = et_height.text.toString().trim()

        when {
            length.isEmpty() -> et_length.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> et_width.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> et_height.error = "Field ini tidak boleh kosong"

            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()
                when {
                    view.id == R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    view.id == R.id.btn_calculate_circumference -> {
                        tv_result.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    view.id == R.id.btn_calculate_surface_area -> {
                        tv_result.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    view.id == R.id.btn_calculate_volume -> {
                        tv_result.text = mainViewModel.getVolume().toString()
                        gone()
                    }

                }
            }

        }
    }

    private fun visible() {
        btn_calculate_volume.visibility = View.VISIBLE
        btn_calculate_circumference.visibility = View.VISIBLE
        btn_calculate_surface_area.visibility = View.VISIBLE
        btn_save.visibility = View.GONE
    }
    private fun gone() {
        btn_calculate_volume.visibility = View.GONE
        btn_calculate_circumference.visibility = View.GONE
        btn_calculate_surface_area.visibility = View.GONE
        btn_save.visibility = View.VISIBLE
    }


}