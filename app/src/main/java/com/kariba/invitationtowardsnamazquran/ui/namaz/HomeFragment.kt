package com.kariba.invitationtowardsnamazquran.ui.namaz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.adapter.SuraOrDoaAdapter
import com.kariba.invitationtowardsnamazquran.databinding.FragmentHomeBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        //val root = inflater.inflate(R.layout.fragment_home, container, false)

        val binding =DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadSuraAndDoaData()
    }

    private fun loadSuraAndDoaData() {
        homeViewModel.loadSuraAndDoaList(requireContext()).observe(viewLifecycleOwner, object : Observer<ArrayList<SuraOrDuaItem>>{
            override fun onChanged(data: ArrayList<SuraOrDuaItem>?) {

                val adapter = data?.let { SuraOrDoaAdapter(requireContext(), it) }
                recyclerView_suraOrDoa.isNestedScrollingEnabled = false
                recyclerView_suraOrDoa.setHasFixedSize(true)
                recyclerView_suraOrDoa.adapter = adapter
            }

        })
    }
}