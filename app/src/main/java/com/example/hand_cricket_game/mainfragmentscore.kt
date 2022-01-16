package com.example.hand_cricket_game

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_mainfragmentscore.*
import kotlinx.android.synthetic.main.fragment_mainfragmentscore.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [mainfragmentscore.newInstance] factory method to
 * create an instance of this fragment.
 */
class mainfragmentscore : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mainfragmentscore, container, false)
        view.next1.setOnClickListener {
            val tempo=view.name1.text.toString()

            val tempt=view.over1.text.toString()
            val temptarget=(0..tempt.toInt()*36).random()

            val tempb=view.over1.text.toString().toInt()*6

            val action = mainfragmentscoreDirections.actionMainfragmentscoreToMainFragment(tempo,temptarget,tempb)


            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

}