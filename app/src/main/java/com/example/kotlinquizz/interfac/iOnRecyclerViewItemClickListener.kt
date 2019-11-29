package com.example.kotlinquizz.interfac

import android.view.View


interface iOnRecyclerViewItemClickListener {
    fun onClick(view:View,position: Int)
}