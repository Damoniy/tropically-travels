package com.damoniy.tropicalviagens.utils

import com.damoniy.tropicalviagens.model.Pack
import java.text.DecimalFormat
import java.util.*

object CoinUtil {
    private val BRAZIL = Locale("pt", "br")

    fun formatCurrency(pack: Pack): String {
        val brazilReal = DecimalFormat.getCurrencyInstance(BRAZIL)
        return brazilReal.format(pack.price)
    }
}