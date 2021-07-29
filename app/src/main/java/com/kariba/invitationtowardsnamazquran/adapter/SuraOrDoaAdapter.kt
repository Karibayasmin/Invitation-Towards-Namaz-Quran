package com.kariba.invitationtowardsnamazquran.adapter

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.databinding.FragmentHomeBinding
import com.kariba.invitationtowardsnamazquran.databinding.ItemSuraDoaOfNamazBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem

/**
 * Created by Kariba Yasmin on 7/13/21.
 */
class SuraOrDoaAdapter (
    var context: Context,
    var suraAndDoaList : ArrayList<SuraOrDuaItem> = ArrayList()

) : RecyclerView.Adapter<SuraOrDoaAdapter.SuraOrDoaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraOrDoaViewHolder {
        val itemBinding : ItemSuraDoaOfNamazBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_sura_doa_of_namaz, parent, false)

        return SuraOrDoaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SuraOrDoaViewHolder, position: Int) {
        holder.bindView(context, suraAndDoaList[position])
    }

    override fun getItemCount(): Int {
       return suraAndDoaList.size
    }

    class SuraOrDoaViewHolder(private val itemBinding: ItemSuraDoaOfNamazBinding) :
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