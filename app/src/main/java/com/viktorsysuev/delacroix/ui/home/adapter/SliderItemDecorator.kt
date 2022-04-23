package com.viktorsysuev.delacroix.ui.home.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.viktorsysuev.delacroix.ui.util.AppUtil


open class SliderItemDecorator : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        recyclerView: RecyclerView,
        state: RecyclerView.State
    ) {
        val index = recyclerView.getChildAdapterPosition(view)
        val isFirstItem = isFirstItem(index)
        val isLastItem = isLastItem(index, recyclerView)

        val leftInset = AppUtil.dpToPx(16)
        val rightInset = if (isLastItem) AppUtil.dpToPx(16) else 0

        outRect.set(leftInset, AppUtil.dpToPx(16), rightInset, AppUtil.dpToPx(16))
    }

    private fun isFirstItem(index: Int) = index == 0
    private fun isLastItem(index: Int, recyclerView: RecyclerView) =
        index == recyclerView.adapter?.itemCount?.minus(1) ?: 0
}