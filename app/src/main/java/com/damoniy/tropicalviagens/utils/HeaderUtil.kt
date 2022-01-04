package com.damoniy.tropicalviagens.utils

import android.content.Context
import android.graphics.drawable.Drawable
import com.damoniy.tropicalviagens.model.Pack

object HeaderUtil {
    fun getPackBanner(context: Context, pack: Pack): Drawable {
        val bannerId = context.resources.getIdentifier(pack.image, "drawable", context.packageName)
        return context.resources.getDrawable(bannerId)
    }
}