package com.kariba.invitationtowardsnamazquran.fragment

import android.animation.Animator
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kariba.invitationtowardsnamazquran.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_tasbih.*
import kotlin.concurrent.thread

class TasbihFragment : Fragment() {

    var tasbihCount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbih, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCountTasbih()

        setTasbihReset()
    }

    private fun setTasbihReset() {
        textView_tasbih_reset.setOnClickListener {
            if(tasbihCount > 0){
                setResetAlertDialog()
            }
        }
    }

    private fun setResetAlertDialog() {
        var builder : AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setMessage(getString(R.string.tasbih_reset_alert))
        builder.setCancelable(true)

        builder.setPositiveButton(getString(R.string.yes_alert), DialogInterface.OnClickListener { dialog, which ->
            tasbihCount = 0
            textView_tasbih_count.text = tasbihCount.toString()
            dialog.dismiss()
        })

        builder.setNegativeButton(getString(R.string.no_alert), DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })

        var alert : AlertDialog = builder.create()
        alert.show()
    }

    private fun setCountTasbih() {

        animationView.pauseAnimation()
        animationView.setMinFrame(60)

        layout_tasbih.setOnClickListener {
            val handler = Handler()
            handler.postDelayed({
                animationView.playAnimation()
            }, 1000)


            if(animationView.progress > 0.0f){
                animationView.pauseAnimation()
                animationView.setMinFrame(60)

                tasbihCount++
                textView_tasbih_count.text = tasbihCount.toString()

            }
        }


    }

}