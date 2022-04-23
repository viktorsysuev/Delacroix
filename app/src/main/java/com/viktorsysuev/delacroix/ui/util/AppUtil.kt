package com.viktorsysuev.delacroix.ui.util

import android.content.res.Resources

object AppUtil {

    fun dpToPx(dp: Int): Int = (dp * Resources.getSystem().displayMetrics.density).toInt()

    fun pxToDp(px: Int): Int = (px / Resources.getSystem().displayMetrics.density).toInt()


}