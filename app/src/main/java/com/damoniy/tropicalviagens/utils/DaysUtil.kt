package com.damoniy.tropicalviagens.utils

import com.damoniy.tropicalviagens.model.Pack

object DaysUtil {
    fun formatDays(pack: Pack): String {
        if (pack.days < 2) return "${pack.days} dia"
            return "${pack.days} dias"
    }
}