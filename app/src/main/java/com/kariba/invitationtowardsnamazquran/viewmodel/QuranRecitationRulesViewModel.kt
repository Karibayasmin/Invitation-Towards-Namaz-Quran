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
        suraAndDoaList.add(
            SuraOrDuaItem("১৬.",context.getString(R.string.horkot),context.getString(
                R.string.horkot_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("১৭.",context.getString(R.string.tanbin),context.getString(
                R.string.tanbin_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("১৮.",context.getString(R.string.nun_sakin),context.getString(
                R.string.nun_sakin_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("১৯.",context.getString(R.string.nun_sakin_and_tanbin),context.getString(
                R.string.nun_sakin_and_tanbin_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২০.",context.getString(R.string.iklab),context.getString(
                R.string.iklab_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২১.",context.getString(R.string.izhar),context.getString(
                R.string.izhar_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২২.",context.getString(R.string.idgom),context.getString(
                R.string.idgom_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২৩.",context.getString(R.string.idgom_type),context.getString(
                R.string.idgom_type_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২৪.",context.getString(R.string.idgom_e_bagunna),context.getString(
                R.string.idgom_e_bagunna_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২৫.",context.getString(R.string.idgom_e_belagunna),context.getString(
                R.string.idgom_e_belagunna_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২৬.",context.getString(R.string.ikfa),context.getString(
                R.string.ikfa_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২৭.",context.getString(R.string.alamote_wakfo),context.getString(
                R.string.alamote_wakfo_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২৮.",context.getString(R.string.wakfe_moanaka),context.getString(
                R.string.wakfe_moanaka_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("২৯.",context.getString(R.string.modde_ewaj),context.getString(
                R.string.modde_ewaj_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("৩০.",context.getString(R.string.modde_tobai),context.getString(
                R.string.modde_tobai_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("৩১.",context.getString(R.string.mim_sakin_porar_niom),context.getString(
                R.string.mim_sakin_porar_niom_description),false, ArrayList()
            )
        )

        suraAndDoaList.add(
            SuraOrDuaItem("৩২.",context.getString(R.string.ana_shobdo_porar_niom),context.getString(
                R.string.ana_shobdo_porar_niom_description),false, ArrayList()
            )
        )


        setSuraAndDoaListData(suraAndDoaList)
    }

    private fun setSuraAndDoaListData(suraAndDoaList: java.util.ArrayList<SuraOrDuaItem>) {
        mutableSuraAndDoaListData.value = suraAndDoaList
    }
}