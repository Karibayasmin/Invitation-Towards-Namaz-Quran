package com.kariba.invitationtowardsnamazquran.fragment

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kariba.invitationtowardsnamazquran.adapter.QuranRecitationRulesAdapter
import com.kariba.invitationtowardsnamazquran.databinding.FragmentQuranRecitationRulesBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem
import com.kariba.invitationtowardsnamazquran.viewmodel.QuranRecitationRulesViewModel
import kotlinx.android.synthetic.main.fragment_quran_recitation_rules.*
import com.kariba.invitationtowardsnamazquran.R
import com.singularitybd.dife.interfaces.OnItemClickListener
import com.singularitybd.dife.interfaces.OnSubItemClickListener


class QuranRecitationRulesFragment : Fragment() {

    private lateinit var quranRecitationRulesViewModel: QuranRecitationRulesViewModel

    private lateinit var adapter : QuranRecitationRulesAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        quranRecitationRulesViewModel =
                ViewModelProvider(this).get(QuranRecitationRulesViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentQuranRecitationRulesBinding>(inflater, R.layout.fragment_quran_recitation_rules, container, false)

        initViews(binding, context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initViews(binding: FragmentQuranRecitationRulesBinding?, context: Context?) {
        adapter = QuranRecitationRulesAdapter(requireContext(), quranRecitationRulesViewModel, onMenuClickListener, onSubMenuItemClickListener)

        binding?.recyclerViewSuraOrDoa?.setHasFixedSize(true)
        binding?.recyclerViewSuraOrDoa?.adapter = adapter

        loadSuraAndDoaData(context)
    }

    private fun loadSuraAndDoaData(context: Context?) {
        if (context != null) {
            quranRecitationRulesViewModel.loadSuraAndDoaList(context).observe(viewLifecycleOwner, object : Observer<ArrayList<SuraOrDuaItem>> {
                override fun onChanged(data: ArrayList<SuraOrDuaItem>?) {
                    if (data != null) {
                        adapter.setMenuItemList(data)
                    }
                    adapter.notifyDataSetChanged()
                }

            })
        }
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
            if (childItem != null) {
                onItemClickedFunction(view.context, childItem)
            }
        }
    }

    private fun onItemClickedFunction(context: Context, item: SuraOrDuaItem) {
        if (item.subMenu?.isNotEmpty() == true)
            return

        /*if(item.itemTitle == context.getString(R.string.Allah_name_example_one)){
            val music: MediaPlayer = MediaPlayer.create(context, R.raw.allohu)
            music.start()
        }
        if(item.itemTitle == context.getString(R.string.Allah_name_example_two)){
            val music: MediaPlayer = MediaPlayer.create(context, R.raw.allohu)
            music.start()
        }*/
    }
}