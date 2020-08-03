package com.ebookfrenzy.fragmentexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.SeekBar
import android.content.Context

import kotlinx.android.synthetic.main.toolbar_fragment.*


class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    var seekvalue = 10

    var activityCallback: ToolbarFragment.ToolbarListener? = null

    interface ToolbarListener {
        fun onButtonClick(position: Int, text:String)
    }


    override fun onAttach(context:Context){

        super.onAttach(context)

        try {
            activityCallback = context as ToolbarListener

        } catch(e: ClassCastException) {

            throw ClassCastException(context.toString() + "Must implement ToolbarListener")
        }

    }
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState:Bundle?):View?{

        val view = inflater.inflate(R.layout.toolbar_fragment, container, false)

        val seekBar:SeekBar? = view?.findViewById(R.id.seekBar1)

        val button: Button? = view?.findViewById(R.id.button1)

        button?.setOnClickListener {v: View -> buttonClicked(v) }

        return view



    }

    private fun buttonClicked(view:View){

        activityCallback?.onButtonClick(seekvalue,editText1.text.toString())


    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            seekvalue = progress
        }
    override fun onStartTrackingTouch(argo:SeekBar){


    }

        override fun onStopTrackingTouch(argo:SeekBar){




    }


    }