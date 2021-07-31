package com.singularitybd.dife.interfaces

import android.view.View

interface OnSubItemClickListener {
    fun onItemClickListener(view: View, parentPosition: Int, childPosition: Int)
}