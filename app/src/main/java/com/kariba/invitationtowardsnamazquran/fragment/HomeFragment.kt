package com.kariba.invitationtowardsnamazquran.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kariba.invitationtowardsnamazquran.R
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

        setAnimationOnTouchOption()

        switchFragment()
    }

    private fun switchFragment() {
        cardView_quranRecitation_Rules.setOnClickListener {
            if (nav_host_fragment != null) {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.nav_host_fragment, QuranRecitationRulesFragment())
                transaction?.commit()
            }
        }
    }

    private fun setAnimationOnTouchOption() {
        cardView_quranRecitation_Rules.setOnTouchListener { v, event ->
            if(event.action == KeyEvent.ACTION_DOWN){
                cardView_quranRecitation_Rules.setCardBackgroundColor(resources.getColor(R.color.colorPrimary))

            }else{
                cardView_quranRecitation_Rules.setCardBackgroundColor(resources.getColor(R.color.teal_700))

            }
            return@setOnTouchListener false
        }
    }
}