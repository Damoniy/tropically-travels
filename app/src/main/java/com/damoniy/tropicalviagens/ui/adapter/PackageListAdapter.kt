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
import com.damoniy.tropicalviagens.utils.CoinUtil
import com.damoniy.tropicalviagens.utils.DaysUtil
import com.damoniy.tropicalviagens.utils.HeaderUtil

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
        showHeader(view, pack)
        showLocale(view, pack)
        showDays(view, pack)
        showPrice(view, pack)
    }

    private fun showHeader(view: View, pack: Pack) {
        val image: ImageView = view.findViewById(R.id.item_package_imageView)
        image.setImageDrawable(HeaderUtil.getPackBanner(context, pack))
    }

    private fun showDays(view: View, pack: Pack) {
        val days: TextView = view.findViewById(R.id.item_package_days)
        days.text = DaysUtil.formatDays(pack)
    }

    private fun showLocale(view: View, pack: Pack) {
        val locale: TextView = view.findViewById(R.id.item_package_locale)
        locale.text = pack.locale
    }

    private fun showPrice(view: View, pack: Pack) {
        val price: TextView = view.findViewById(R.id.item_package_value)
        price.text = CoinUtil.formatCurrency(pack)
    }

    private fun inflateListView(parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.item_package, parent, false)
    }
 }
