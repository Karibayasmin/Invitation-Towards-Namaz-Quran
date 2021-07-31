package com.kariba.invitationtowardsnamazquran.fragment

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kariba.invitationtowardsnamazquran.adapter.QuranRecitationRulesAdapter
import com.kariba.invitationtowardsnamazquran.databinding.FragmentQuranRecitationRulesBinding
import com.kariba.invitationtowardsnamazquran.databinding.ActivityMainBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem
import com.kariba.invitationtowardsnamazquran.viewmodel.QuranRecitationRulesViewModel
import kotlinx.android.synthetic.main.fragment_quran_recitation_rules.*
import com.kariba.invitationtowardsnamazquran.R
import kotlinx.android.synthetic.main.item_quran_recitation_rules.*
import com.kariba.invitationtowardsnamazquran.BR
import com.singularitybd.dife.interfaces.OnItemClickListener
import com.singularitybd.dife.interfaces.OnSubItemClickListener


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

    private fun setAudio() {
            val music: MediaPlayer = MediaPlayer.create(context, R.raw.allohu)
            music.start()

    }

    private fun loadSuraAndDoaData() {
        quranRecitationRulesViewModel.loadSuraAndDoaList(requireContext()).observe(viewLifecycleOwner, object : Observer<ArrayList<SuraOrDuaItem>> {
            override fun onChanged(data: ArrayList<SuraOrDuaItem>?) {

                val adapter = data?.let { QuranRecitationRulesAdapter(requireContext(), it) }
                recyclerView_suraOrDoa.isNestedScrollingEnabled = false
                recyclerView_suraOrDoa.setHasFixedSize(true)
                recyclerView_suraOrDoa.adapter = adapter
            }

        })
    }

    private val onMenuClickListener = object : OnItemClickListener {
        override fun onItemClickListener(view: View, position: Int) {
            val item = quranRecitationRulesViewModel.mutableSuraAndDoaListData.value?.get(position) ?: return

            onItemClickedFunction(view.context, item)
        }
    }

    private val onSubMenuItemClickListener = object : OnSubItemClickListener {
        override fun onItemClickListener(view: View, parentPosition: Int, childPosition: Int) {
            val parentItem = quranRecitationRulesViewModel.mutableSuraAndDoaListData.value?.get(parentPosition) ?: return

            val childItem = parentItem.subMenu?.get(childPosition)
            onItemClickedFunctionSubMenu(view.context, childItem)
        }
    }

    private fun onItemClickedFunctionSubMenu(
        context: Context,
        childItem: SuraOrDuaItem.AudioItem?
    ) {
        if(childItem?.modifiedAudioItemName() == "Allohu"){
            setAudio()
        }
    }

    private fun onItemClickedFunction(context: Context, item: SuraOrDuaItem) {
        TODO("Not yet implemented")
    }
}