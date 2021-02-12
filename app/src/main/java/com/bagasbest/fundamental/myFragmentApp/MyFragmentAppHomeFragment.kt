package com.bagasbest.fundamental.myFragmentApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bagasbest.fundamental.R
import kotlinx.android.synthetic.main.fragment_my_app_home.*

class MyFragmentAppHomeFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_app_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_category.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_category) {
            val mCategoryFragment = MyFragmentAppCategoryFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(
                    R.id.frame_container,
                    mCategoryFragment,
                    MyFragmentAppCategoryFragment::class.java.simpleName
                )
                    addToBackStack(null)
                    commit()
            }
        }
    }


}