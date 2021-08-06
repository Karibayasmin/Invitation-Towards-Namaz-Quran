package com.kariba.invitationtowardsnamazquran.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem

class QuranRecitationRulesViewModel : ViewModel() {

    var mutableSuraAndDoaListData = MutableLiveData<ArrayList<SuraOrDuaItem>>()

    fun loadSuraAndDoaList(context: Context) : LiveData<ArrayList<SuraOrDuaItem>> {
        mutableSuraAndDoaListData = MutableLiveData()
        getMutableSuraAndDoaData(context)
        return mutableSuraAndDoaListData
    }

    private fun getMutableSuraAndDoaData(context: Context) {
        var suraAndDoaList : ArrayList<SuraOrDuaItem> = ArrayList()

        var exampleItemListOfItemOne : ArrayList<SuraOrDuaItem> = ArrayList()

        exampleItemListOfItemOne.add(SuraOrDuaItem("", context.getString(
            R.string.Allah_name_example_one),"",  false, ArrayList()
        ))
        exampleItemListOfItemOne.add(SuraOrDuaItem("", context.getString(
            R.string.Allah_name_example_two),"",  false, ArrayList()
        ))

        suraAndDoaList.add(
            SuraOrDuaItem("১.",context.getString(R.string.Allah_name_title),context.getString(
                R.string.Allah_name_describe),false, exampleItemListOfItemOne
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("২.",context.getString(R.string.mod_or_mad_title),context.getString(
                R.string.mod_or_mad_describe), false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("৩.",context.getString(R.string.one_alif_mod_or_mad_title),context.getString(
                R.string.one_alif_mod_or_mad_describe),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("৪.",context.getString(R.string.three_alif_mod_or_mad_title),context.getString(
                R.string.three_alif_mod_or_mad_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("৫.",context.getString(R.string.four_alif_mod_or_mad_title),context.getString(
                R.string.four_alif_mod_or_mad_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("৬.",context.getString(R.string.mod_or_mad_e_tobai_title),context.getString(
                R.string.mod_or_mad_e_tobai_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("৭.",context.getString(R.string.mod_or_mad_e_bodol_title),context.getString(
                R.string.mod_or_mad_e_bodol_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("৮.",context.getString(R.string.mod_or_mad_e_lin_title),context.getString(
                R.string.mod_or_mad_e_lin_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("৯.",context.getString(R.string.mod_or_mad_e_arji_title),context.getString(
                R.string.mod_or_mad_e_arji_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("১০.",context.getString(R.string.mod_or_mad_e_munfasil_title),context.getString(
                R.string.mod_or_mad_e_munfasil_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("১১.",context.getString(R.string.mod_or_mad_e_lazim_kalmi_musakkal_title),context.getString(
                R.string.mod_or_mad_e_lazim_kalmi_musakkal_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("১২.",context.getString(R.string.mod_or_mad_e_lazim_kalmi_mukhaffaf_title),context.getString(
                R.string.mod_or_mad_e_lazim_kalmi_mukhaffaf_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("১৩.",context.getString(R.string.mod_or_mad_e_lazim_horfi_musakkal_title),context.getString(
                R.string.mod_or_mad_e_lazim_horfi_musakkal_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("১৪.",context.getString(R.string.mod_or_mad_e_lazim_horfi_mukhaffaf_title),context.getString(
                R.string.mod_or_mad_e_lazim_horfi_mukhaffaf_description),false, ArrayList()
            )
        )
        suraAndDoaList.add(
            SuraOrDuaItem("১৫.",context.getString(R.string.mod_or_mad_e_muttasil_title),context.getString(
                R.string.mod_or_mad_e_muttasil_description),false, ArrayList()
            )
        )


        setSuraAndDoaListData(suraAndDoaList)
    }

    private fun setSuraAndDoaListData(suraAndDoaList: java.util.ArrayList<SuraOrDuaItem>) {
        mutableSuraAndDoaListData.value = suraAndDoaList
    }
}