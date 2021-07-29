package com.kariba.invitationtowardsnamazquran.ui.namaz

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem

class HomeViewModel : ViewModel() {
    var mutableSuraAndDoaListData = MutableLiveData<ArrayList<SuraOrDuaItem>>()

    fun loadSuraAndDoaList(context: Context) : LiveData<ArrayList<SuraOrDuaItem>> {
        mutableSuraAndDoaListData = MutableLiveData()
        getMutableSuraAndDoaData(context)
        return mutableSuraAndDoaListData
    }

    private fun getMutableSuraAndDoaData(context: Context) {
        var suraAndDoaList : ArrayList<SuraOrDuaItem> = ArrayList()

        suraAndDoaList.add(SuraOrDuaItem("1.",context.getString(R.string.Allah_name_title),context.getString(R.string.Allah_name_describe),false))
        suraAndDoaList.add(SuraOrDuaItem("2.",context.getString(R.string.mod_or_mad_title),context.getString(R.string.Allah_name_describe),false))
        suraAndDoaList.add(SuraOrDuaItem("3.",context.getString(R.string.one_alif_mod_or_mad_title),context.getString(R.string.one_alif_mod_or_mad_describe),false))
        suraAndDoaList.add(SuraOrDuaItem("4.",context.getString(R.string.three_alif_mod_or_mad_title),context.getString(R.string.three_alif_mod_or_mad_description),false))
        suraAndDoaList.add(SuraOrDuaItem("5.",context.getString(R.string.four_alif_mod_or_mad_title),context.getString(R.string.four_alif_mod_or_mad_description),false))
        suraAndDoaList.add(SuraOrDuaItem("6.",context.getString(R.string.mod_or_mad_e_tobai_title),context.getString(R.string.mod_or_mad_e_tobai_description),false))
        suraAndDoaList.add(SuraOrDuaItem("7.",context.getString(R.string.mod_or_mad_e_bodol_title),context.getString(R.string.mod_or_mad_e_bodol_description),false))
        suraAndDoaList.add(SuraOrDuaItem("8.",context.getString(R.string.mod_or_mad_e_lin_title),context.getString(R.string.mod_or_mad_e_lin_description),false))
        suraAndDoaList.add(SuraOrDuaItem("9.",context.getString(R.string.mod_or_mad_e_arji_title),context.getString(R.string.mod_or_mad_e_arji_description),false))
        suraAndDoaList.add(SuraOrDuaItem("10.",context.getString(R.string.mod_or_mad_e_munfasil_title),context.getString(R.string.mod_or_mad_e_munfasil_description),false))
        suraAndDoaList.add(SuraOrDuaItem("11.",context.getString(R.string.mod_or_mad_e_lazim_kalmi_musakkal_title),context.getString(R.string.mod_or_mad_e_lazim_kalmi_musakkal_description),false))
        suraAndDoaList.add(SuraOrDuaItem("12.",context.getString(R.string.mod_or_mad_e_lazim_kalmi_mukhaffaf_title),context.getString(R.string.mod_or_mad_e_lazim_kalmi_mukhaffaf_description),false))
        suraAndDoaList.add(SuraOrDuaItem("13.",context.getString(R.string.mod_or_mad_e_lazim_horfi_musakkal_title),context.getString(R.string.mod_or_mad_e_lazim_horfi_musakkal_description),false))
        suraAndDoaList.add(SuraOrDuaItem("14.",context.getString(R.string.mod_or_mad_e_lazim_horfi_mukhaffaf_title),context.getString(R.string.mod_or_mad_e_lazim_horfi_mukhaffaf_description),false))
        suraAndDoaList.add(SuraOrDuaItem("15.",context.getString(R.string.mod_or_mad_e_muttasil_title),context.getString(R.string.mod_or_mad_e_muttasil_description),false))


        setSuraAndDoaListData(suraAndDoaList)
    }

    private fun setSuraAndDoaListData(suraAndDoaList: java.util.ArrayList<SuraOrDuaItem>) {
        mutableSuraAndDoaListData.value = suraAndDoaList
    }
}