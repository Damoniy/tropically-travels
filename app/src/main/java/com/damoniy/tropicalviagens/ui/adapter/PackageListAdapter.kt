package com.damoniy.tropicalviagens.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.damoniy.tropicalviagens.R
import com.damoniy.tropicalviagens.model.Pack
import java.text.DecimalFormat
import java.util.*
import kotlin.collections.ArrayList

class PackageListAdapter(private val context: Context, private val packs: ArrayList<Pack>) : BaseAdapter() {
    override fun getCount(): Int {
        return packs.size
    }

    override fun getItem(p0: Int): Any {
        return packs[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, view1: View?, parent: ViewGroup?): View {
        val pack = packs[position]
        val newView = inflateListView(parent)

        val locale: TextView = newView.findViewById(R.id.item_package_locale)
        val image: ImageView = newView.findViewById(R.id.item_package_imageView)
        val days: TextView = newView.findViewById(R.id.item_package_days)
        val price: TextView = newView.findViewById(R.id.item_package_value)
        locale.text = pack.locale
        val drawableId = context.resources.getIdentifier(pack.image, "drawable", context.packageName)
        image.setImageDrawable(context.resources.getDrawable(drawableId))
        days.text = if(pack.days < 2) "${pack.days} dia" else "${pack.days} dias"
        val brazilReal = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
        price.text = brazilReal.format(pack.price)

        return view1 ?: newView
    }

    private fun inflateListView(parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.item_package, parent, false)

    }
 }
