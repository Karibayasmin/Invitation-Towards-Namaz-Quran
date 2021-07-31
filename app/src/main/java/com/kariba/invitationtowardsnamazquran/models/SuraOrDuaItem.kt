package com.kariba.invitationtowardsnamazquran.models

import android.media.MediaPlayer
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Kariba Yasmin on 7/13/21.
 */
class SuraOrDuaItem (
    @SerializedName("itemNumber") val itemNumber : String? = "",
    @SerializedName("itemTitle") val itemTitle : String? = "",
    @SerializedName("itemDescribe") val itemDescribe : String? = "",
    @SerializedName("isOpen") val isOpen : Boolean? = false,
    @SerializedName("") val subMenu : ArrayList<AudioItem>? = ArrayList()


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

    class AudioItem(
        @SerializedName("audio") val audioName : String? = ""
    ) : Serializable{

        fun modifiedAudioItemName() : String{
            return  audioName ?: ""
        }
    }

}