package com.example.avjindersinghsekhon.minimaltodo.Main

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.avjindersinghsekhon.minimaltodo.R
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_bonus.*

class BonusFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bonus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val toUse = editText.text.toString().toInt()

            val preference = context!!.getSharedPreferences(MainFragment.SHARED_PREF_BONUS, MODE_PRIVATE)

            val bonus = preference.getInt(MainFragment.SHARED_PREF_BONUS, 0) - toUse

            if (bonus < 0){
                Toast.makeText(context, "Invalid value!", Toast.LENGTH_SHORT).show()
                return
            }

            val editor = preference.edit()
            editor.putInt(MainFragment.SHARED_PREF_BONUS, bonus)
            editor.apply()

            tvBonusNum.text = bonus.toString()
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onResume() {
        super.onResume()

        val preference = context!!.getSharedPreferences(MainFragment.SHARED_PREF_BONUS, MODE_PRIVATE)

        val bonus = preference.getInt(MainFragment.SHARED_PREF_BONUS, 0)

        tvBonusNum.text = bonus.toString()
    }
}
