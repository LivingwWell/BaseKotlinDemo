package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 5:05 PM
 */
abstract class BaseViewHolder : RecyclerView.ViewHolder{

    constructor(item:View):super(item)

    @SuppressLint("UseSparseArrays")
    private val viewHashMap: MutableMap<Int, View> = HashMap()

    protected open fun <T : View?> getView(@IdRes id: Int): T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T?
    }

    protected fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }
}