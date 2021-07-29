package com.kariba.invitationtowardsnamazquran.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Kariba Yasmin on 7/13/21.
 */
class SuraOrDuaItem (
    @SerializedName("itemNumber") val itemNumber : String? = "",
    @SerializedName("itemTitle") val itemTitle : String? = "",
    @SerializedName("itemDescribe") val itemDescribe : String? = "",
    @SerializedName("isOpen") val isOpen : Boolean? = false

) : Serializable {
    fun modifiedItemNumber() : String{
        return itemNumber ?: ""
    }

    fun modifiedItemTitle() : String{
        return  itemTitle ?: ""
    }

    fun modifiedItemDescribe() : String{
        return  itemDescribe ?: ""
    }

    fun modifiedItemIsOpen() : Boolean{
        return  isOpen ?: false
    }

}