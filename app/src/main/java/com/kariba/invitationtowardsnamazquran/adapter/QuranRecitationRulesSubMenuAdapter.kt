package com.kariba.invitationtowardsnamazquran.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kariba.invitationtowardsnamazquran.databinding.SubItemQuranRecitationRulesBinding
import com.kariba.invitationtowardsnamazquran.models.SuraOrDuaItem
import com.singularitybd.dife.interfaces.OnSubItemClickListener
import java.util.ArrayList
import com.kariba.invitationtowardsnamazquran.R

/**
 * Created by Kariba Yasmin on 8/1/21.
 */
class QuranRecitationRulesSubMenuAdapter(
    private val context: Context,
    private val parentPosition: Int,
    private val onSubItemClickListener: OnSubItemClickListener
) : RecyclerView.Adapter<QuranRecitationRulesSubMenuAdapter.QuranRecitationRulesSubMenuViewHolder>() {

    private var subMenuList : List<SuraOrDuaItem> = ArrayList()

    fun setMenuItemList(subMenuList : ArrayList<SuraOrDuaItem>) {
        this.subMenuList = subMenuList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuranRecitationRulesSubMenuViewHolder {
        val itemBinding : SubItemQuranRecitationRulesBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.sub_item_quran_recitation_rules,
                parent,
                false
        )
        return QuranRecitationRulesSubMenuViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: QuranRecitationRulesSubMenuViewHolder, position: Int) {
        holder.bindView(context, subMenuList[position], parentPosition, position, onSubItemClickListener)
    }

    override fun getItemCount(): Int {
        return subMenuList.size
    }

    class QuranRecitationRulesSubMenuViewHolder(private val itemBinding : SubItemQuranRecitationRulesBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bindView(
                context: Context,
                suraOrDuaItem: SuraOrDuaItem,
                parentPosition: Int,
                position: Int,
                onSubItemClickListener: OnSubItemClickListener) {
            itemBinding.suraAndDoaItem = suraOrDuaItem
            itemBinding.position = position
            itemBinding.executePendingBindings()

            itemBinding.cardViewSuraOrDua.setOnClickListener {
                onSubItemClickListener.onItemClickListener(it, parentPosition, position)

                if(suraOrDuaItem.itemDescribe == "")
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