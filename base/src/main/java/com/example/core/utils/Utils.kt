package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 *
 * @Description:     java类作用描述
 * @Author:          lee
 * @CreateDate:     2020/9/7 5:55 PM
 */
class Utils {
    companion object {
        @JvmStatic
        val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics
        @JvmStatic
        fun dp2px(dp: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
        }
        @JvmStatic
        fun toast(string: String?) {
            toast(string, Toast.LENGTH_SHORT)
        }
        @JvmStatic
          fun toast( string:String?,  duration:Int) {
            Toast.makeText(BaseApplication.currentApplication(), string, duration).show();
        }
    }
}