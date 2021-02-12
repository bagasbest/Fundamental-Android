package com.bagasbest.fundamental.myFragmentApp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bagasbest.fundamental.R
import kotlinx.android.synthetic.main.fragment_my_app_option_dialog.*


class MyFragmentAppOptionDialogFragment : DialogFragment() {

    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_app_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_choose.setOnClickListener {
            val checkRadioButtonId = rg_options.checkedRadioButtonId
            if(checkRadioButtonId != -1) {
                var coach: String? = null;
                when (checkRadioButtonId) {
                    R.id.rb_saf -> coach = rb_saf.text.toString().trim()
                    R.id.rb_mou -> coach = rb_mou.text.toString().trim()
                    R.id.rb_lvg -> coach = rb_lvg.text.toString().trim()
                    R.id.rb_moyes -> coach = rb_moyes.text.toString().trim()
                }

                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()

            }
        }
        btn_close.setOnClickListener {
            dialog?.cancel()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        val fragment = parentFragment

        if(fragment is MyFragmentAppDetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}