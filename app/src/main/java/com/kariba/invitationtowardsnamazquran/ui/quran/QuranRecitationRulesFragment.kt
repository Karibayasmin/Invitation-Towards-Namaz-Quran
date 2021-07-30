package com.kariba.invitationtowardsnamazquran.ui.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.adapter.QuranRecitationRulesAdapter
import com.kariba.invitationtowardsnamazquran.databinding.FragmentQuranRecitationRulesBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem
import kotlinx.android.synthetic.main.fragment_quran_recitation_rules.*

class QuranRecitationRulesFragment : Fragment() {

    private lateinit var quranRecitationRulesViewModel: QuranRecitationRulesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        quranRecitationRulesViewModel =
                ViewModelProvider(this).get(QuranRecitationRulesViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentQuranRecitationRulesBinding>(inflater, R.layout.fragment_quran_recitation_rules, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadSuraAndDoaData()
    }

    private fun loadSuraAndDoaData() {
        quranRecitationRulesViewModel.loadSuraAndDoaList(requireContext()).observe(viewLifecycleOwner, object : Observer<ArrayList<SuraOrDuaItem>>{
            override fun onChanged(data: ArrayList<SuraOrDuaItem>?) {

                val adapter = data?.let { QuranRecitationRulesAdapter(requireContext(), it) }
                recyclerView_suraOrDoa.isNestedScrollingEnabled = false
                recyclerView_suraOrDoa.setHasFixedSize(true)
                recyclerView_suraOrDoa.adapter = adapter
            }

        })
    }
}