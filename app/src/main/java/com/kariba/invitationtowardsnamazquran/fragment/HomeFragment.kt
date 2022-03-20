package com.kariba.invitationtowardsnamazquran.fragment

import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.activity.FragmentActivity.Companion.TAG_QURAN_RECITATION_RULES
import com.kariba.invitationtowardsnamazquran.activity.FragmentActivity.Companion.TAG_TASBIH
import com.kariba.invitationtowardsnamazquran.activity.FragmentActivity.Companion.startActivity
import com.kariba.invitationtowardsnamazquran.databinding.FragmentHomeBinding
import com.kariba.invitationtowardsnamazquran.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchFragment()
    }

    private fun switchFragment() {
        cardView_quranRecitation_Rules.setOnClickListener {
            startActivity(requireContext(), TAG_QURAN_RECITATION_RULES)

            val handler = Handler()
            handler.postDelayed({
                cardView_quranRecitation_Rules.setCardBackgroundColor(resources.getColor(R.color.colorPrimary))
            }, 1000)
            cardView_quranRecitation_Rules.setCardBackgroundColor(resources.getColor(R.color.teal_700))
        }

        cardView_tasbih.setOnClickListener {
            startActivity(requireContext(), TAG_TASBIH)

            val handler = Handler()
            handler.postDelayed({
                cardView_tasbih.setCardBackgroundColor(resources.getColor(R.color.colorPrimary))
            }, 1000)
            cardView_tasbih.setCardBackgroundColor(resources.getColor(R.color.teal_700))
        }
    }
}