package com.example.hand_cricket_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.fragment_mainfragmentscore.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

var ball:Int=0
var ComputerScore:Int=0
var PlayerScore:Int=0
var playerturn:Int=0
val Tag:String="MSG"
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val args:MainFragmentArgs by navArgs()

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
        val view= inflater.inflate(R.layout.fragment_main, container, false)
        var action1=MainFragmentDirections.actionMainFragmentToResultFragment()
        var action2=MainFragmentDirections.actionMainFragmentToLosfragment()

        val temponame=args.playerName
        val tempotarget=args.target
        val tempoballs=args.ballsLeft

        view.name.text=temponame.toString()

        view.target1.text=tempotarget.toString()

        view.balls2.text=tempoballs.toString()
        ball=tempoballs

        view.go.setOnClickListener {
            var computerturn=(1..6).random()
            playerturn= User.text.toString().toInt()
            ComputerScore=tempotarget


            if(playerturn<=6 && playerturn>=1){
                Computer.text=computerturn.toString()
                Player.text= playerturn.toString()

                if(computerturn==playerturn || ball<=0){
                    action2=MainFragmentDirections.actionMainFragmentToLosfragment(PlayerScore,ComputerScore)
                    Navigation.findNavController(view).navigate(action2)
                }
                else{
                    PlayerScore+=playerturn
                    val scoreleft= ComputerScore- PlayerScore
                    ScoreLeft.text=scoreleft.toString()
                    CurrentScore.text= PlayerScore.toString()
                }
                if(PlayerScore>ComputerScore){
                    action1=MainFragmentDirections.actionMainFragmentToResultFragment(PlayerScore,ComputerScore)
                    Navigation.findNavController(view).navigate(action1)
                }
                else{
                    ball-=1
                    balls2.text=ball.toString()
                }
            }
            else{
                Toast.makeText(activity,"Please Enter a number between 1 and 6",Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }

}