package com.kariba.invitationtowardsnamazquran.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kariba.invitationtowardsnamazquran.R
import com.kariba.invitationtowardsnamazquran.databinding.ItemQuranRecitationRulesBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem
import com.kariba.invitationtowardsnamazquran.viewmodel.QuranRecitationRulesViewModel
import com.singularitybd.dife.interfaces.OnItemClickListener
import com.singularitybd.dife.interfaces.OnSubItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
* Created by Kariba Yasmin on 7/13/21.
*/


class QuranRecitationRulesAdapter (
    var context: Context,
    var viewModel: QuranRecitationRulesViewModel,
    private val onMenuItemClickListener: OnItemClickListener,
    private val onSubItemClickListener: OnSubItemClickListener


) : RecyclerView.Adapter<QuranRecitationRulesAdapter.QuranRecitationRulesViewHolder>(){

    var suraAndDoaList : ArrayList<SuraOrDuaItem> = ArrayList()

    fun setMenuItemList(suraAndDoaList: ArrayList<SuraOrDuaItem>) {
        this.suraAndDoaList = suraAndDoaList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranRecitationRulesViewHolder {
        val itemBinding : ItemQuranRecitationRulesBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_quran_recitation_rules, parent, false)

        return QuranRecitationRulesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: QuranRecitationRulesViewHolder, position: Int) {
        holder.bindView(
                context, suraAndDoaList[position], viewModel, position, onMenuItemClickListener, onSubItemClickListener)
    }

    override fun getItemCount(): Int {
       return suraAndDoaList.size
    }

    class QuranRecitationRulesViewHolder(private val itemBinding: ItemQuranRecitationRulesBinding) :
        RecyclerView.ViewHolder(itemBinding.root){
            @SuppressLint("ClickableViewAccessibility")
            fun bindView(
                    context: Context,
                    item: SuraOrDuaItem,
                    viewModel: QuranRecitationRulesViewModel,
                    position: Int,
                    onMenuItemClickListener: OnItemClickListener,
                    onSubItemClickListener: OnSubItemClickListener) {
                itemBinding.suraAndDoaItem = item
                itemBinding.suraAndDoaViewModel = viewModel
                itemBinding.position = position
                itemBinding.executePendingBindings()

                itemBinding.cardViewSuraOrDua.setOnTouchListener { v, event ->
                    if(event.action == KeyEvent.ACTION_DOWN){
                        itemBinding.cardViewSuraOrDua.setCardBackgroundColor(ContextCompat.getColor(context, R.color.teal_700))

                    }else{
                        itemBinding.cardViewSuraOrDua.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))

                    }
                    return@setOnTouchListener false
                }

                itemBinding.cardViewSuraOrDua.setOnClickListener {
                    onMenuItemClickListener.onItemClickListener(it, adapterPosition)

                    if(item.itemDescribe == "")
                        return@setOnClickListener

                    itemBinding.textViewItemDescription.visibility =
                        if(itemBinding.textViewItemDescription.visibility == View.GONE)
                            View.VISIBLE
                        else
                            View.GONE
                }

                /*if(item.subMenu.isNullOrEmpty()){
                    itemBinding.recyclerViewSuraOrDoaSubitem.visibility = View.GONE

                }else{
                    itemBinding.recyclerViewSuraOrDoaSubitem.visibility = View.VISIBLE
                    itemBinding.recyclerViewSuraOrDoaSubitem.setHasFixedSize(true)
                    itemBinding.recyclerViewSuraOrDoaSubitem.isNestedScrollingEnabled = false

                    val subMenuAdapter = QuranRecitationRulesSubMenuAdapter(context, position, onSubItemClickListener)
                    subMenuAdapter.setMenuItemList(item.subMenu)
                    itemBinding.recyclerViewSuraOrDoaSubitem.adapter = subMenuAdapter


                }*/
        }
    }
}
