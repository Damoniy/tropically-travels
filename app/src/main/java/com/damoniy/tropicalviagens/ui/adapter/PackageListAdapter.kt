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
        formatCode(pack, newView)

        return view1 ?: newView
    }

    private fun formatCode(pack: Pack, view: View) {
        showBackground(view, pack)
        showLocale(view, pack)
        showDays(view, pack)
        showPrice(view, pack)
    }

    private fun showBackground(view: View, pack: Pack) {
        val image: ImageView = view.findViewById(R.id.item_package_imageView)
        val drawableId = context.resources.getIdentifier(pack.image, "drawable", context.packageName)
        image.setImageDrawable(context.resources.getDrawable(drawableId))
    }

    private fun showDays(view: View, pack: Pack) {
        val days: TextView = view.findViewById(R.id.item_package_days)
        days.text = if (pack.days < 2) "${pack.days} dia" else "${pack.days} dias"
    }

    private fun showLocale(view: View, pack: Pack) {
        val locale: TextView = view.findViewById(R.id.item_package_locale)
        locale.text = pack.locale
    }

    private fun showPrice(view: View, pack: Pack) {
        val brazilReal = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
        val price: TextView = view.findViewById(R.id.item_package_value)
        price.text = brazilReal.format(pack.price)
    }

    private fun inflateListView(parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.item_package, parent, false)
    }
 }
