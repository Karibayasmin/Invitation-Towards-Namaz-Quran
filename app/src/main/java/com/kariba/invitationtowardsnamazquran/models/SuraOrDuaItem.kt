package com.kariba.invitationtowardsnamazquran.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Kariba Yasmin on 7/13/21.
 */
class SuraOrDuaItem (
    @SerializedName("itemNumber") val itemNumber : String? = "",
    @SerializedName("") val itemName : String? = ""

) : Serializable {
    fun modifiedItemNumber() : String{
        return itemNumber ?: ""
    }

    fun modifiedItemName() : String{
        return  itemName ?: ""
    }

}