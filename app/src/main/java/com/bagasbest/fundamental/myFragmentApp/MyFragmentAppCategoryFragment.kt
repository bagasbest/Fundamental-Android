package com.bagasbest.fundamental.myFragmentApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bagasbest.fundamental.R
import kotlinx.android.synthetic.main.fragment_my_app_category.*


class MyFragmentAppCategoryFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_app_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_detail_category.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_detail_category) {
            val mDetailCategoryFragment = MyFragmentAppDetailCategoryFragment()


            val mBundle = Bundle()

            mBundle.putString(MyFragmentAppDetailCategoryFragment.EXTRA_NAME, "LifeStyle")
            mBundle.putString(MyFragmentAppDetailCategoryFragment.EXTRA_TARGET_MARKET, "Adult")

            val description = "Kategori ini akan berisi produk - produk Lifestyle"



            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description = description

            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.frame_container,
                    mDetailCategoryFragment,
                    MyFragmentAppDetailCategoryFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
            }
        }
    }

}