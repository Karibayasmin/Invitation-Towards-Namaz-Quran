package com.kariba.invitationtowardsnamazquran.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.databinding.ItemQuranRecitationRulesBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem

/**
 * Created by Kariba Yasmin on 7/13/21.
 */
class QuranRecitationRulesAdapter (
    var context: Context,
    var suraAndDoaList : ArrayList<SuraOrDuaItem> = ArrayList()

) : RecyclerView.Adapter<QuranRecitationRulesAdapter.QuranRecitationRulesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranRecitationRulesViewHolder {
        val itemBinding : ItemQuranRecitationRulesBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_quran_recitation_rules, parent, false)

        return QuranRecitationRulesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: QuranRecitationRulesViewHolder, position: Int) {
        holder.bindView(context, suraAndDoaList[position])
    }

    override fun getItemCount(): Int {
       return suraAndDoaList.size
    }

    class QuranRecitationRulesViewHolder(private val itemBinding: ItemQuranRecitationRulesBinding) :
        RecyclerView.ViewHolder(itemBinding.root){
            fun bindView(
                context : Context,
                item: SuraOrDuaItem
                ){
                itemBinding.suraAndDoaItem = item
                itemBinding.executePendingBindings()

                itemBinding.cardViewSuraOrDua.setOnClickListener {
                    if(item.itemDescribe == "")
                        return@setOnClickListener

                    itemBinding.textViewItemDescription.visibility =
                        if(itemBinding.textViewItemDescription.visibility == View.GONE)
                            View.VISIBLE
                        else
                            View.GONE
                }
        }
    }
}