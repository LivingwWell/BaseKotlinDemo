package com.example.core

import android.app.Application
import android.content.Context

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 4:58 PM
 */
class BaseApplication : Application() {

    companion object {
        lateinit var currentApplication: Context

        @JvmStatic
        fun currentApplication(): Context {
            return currentApplication
        }
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }


}