package com.damoniy.tropicalviagens.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.damoniy.tropicalviagens.R
import com.damoniy.tropicalviagens.dao.PackageDAO
import com.damoniy.tropicalviagens.ui.adapter.PackageListAdapter

class TravelPackageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_package)
        val packageList = findViewById<ListView>(R.id.travel_package_listView)
        packageList.adapter = PackageListAdapter(this, PackageDAO().packageList)
    }
}