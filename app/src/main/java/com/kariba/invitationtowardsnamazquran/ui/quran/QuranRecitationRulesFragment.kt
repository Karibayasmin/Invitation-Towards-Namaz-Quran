package com.kariba.invitationtowardsnamazquran.ui.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kariba.invitationtowardsnamazquran.R

class QuranRecitationRulesFragment : Fragment() {

    private lateinit var quranRecitationRulesViewModel: QuranRecitationRulesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        quranRecitationRulesViewModel =
                ViewModelProvider(this).get(QuranRecitationRulesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quran_recitation_rules, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        quranRecitationRulesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}