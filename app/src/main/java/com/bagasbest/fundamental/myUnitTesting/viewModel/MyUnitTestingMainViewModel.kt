package com.bagasbest.fundamental.myUnitTesting.viewModel

import com.bagasbest.fundamental.myUnitTesting.model.MyUnitTestingCuboidModel

class MyUnitTestingMainViewModel(private val cuboidModel: MyUnitTestingCuboidModel)  {
    fun getCircumference(): Double = cuboidModel.getCircumference()
    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()
    fun getVolume(): Double = cuboidModel.getVolume()
    fun save(l: Double, w: Double, h: Double) {
        cuboidModel.save(l, w, h)
    }
}