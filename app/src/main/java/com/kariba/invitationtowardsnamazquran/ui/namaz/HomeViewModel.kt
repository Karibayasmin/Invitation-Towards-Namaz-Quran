package com.kariba.invitationtowardsnamazquran.ui.namaz

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

        suraAndDoaList.add(SuraOrDuaItem("1","Sura Al Fateha"))
        suraAndDoaList.add(SuraOrDuaItem("2","Sura Ekhlas"))
        suraAndDoaList.add(SuraOrDuaItem("3","Sura Falaq"))
        suraAndDoaList.add(SuraOrDuaItem("4","Sura Nas"))

        setSuraAndDoaListData(suraAndDoaList)
    }

    private fun setSuraAndDoaListData(suraAndDoaList: java.util.ArrayList<SuraOrDuaItem>) {
        mutableSuraAndDoaListData.value = suraAndDoaList
    }
}