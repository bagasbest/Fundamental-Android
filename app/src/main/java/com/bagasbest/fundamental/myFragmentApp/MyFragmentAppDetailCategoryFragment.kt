package com.bagasbest.fundamental.myFragmentApp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bagasbest.fundamental.R
import kotlinx.android.synthetic.main.fragment_my_app_detail_category.*


class MyFragmentAppDetailCategoryFragment : Fragment() {

    var description: String? = null

    companion object {
        var EXTRA_NAME = "name"
        var EXTRA_DESCRIPTION = "desc"
        var EXTRA_TARGET_MARKET = "market"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_app_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_show_dialog.setOnClickListener {
            val mOptionDialogFragment = MyFragmentAppOptionDialogFragment()

            val mFragmentManager = childFragmentManager
            mOptionDialogFragment.show(
                mFragmentManager,
                MyFragmentAppOptionDialogFragment::class.java.simpleName
            )
        }

        btn_profile.setOnClickListener {
            startActivity(Intent(activity, MyFragmentAappProfileActivity::class.java))
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            val targetMarket = arguments?.getString(EXTRA_TARGET_MARKET)
            tv_category_name.text = categoryName
            tv_category_description.text = description
            tv_target_market.text = targetMarket
        }
    }

    internal var optionDialogListener: MyFragmentAppOptionDialogFragment.OnOptionDialogListener =
        object : MyFragmentAppOptionDialogFragment.OnOptionDialogListener {
            override fun onOptionChosen(text: String?) {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
            }
        }


}