package com.thiran.journal.activity.navigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.LinearLayout
import com.thiran.journal.R

class navigationAdapter(val ctx: Context, val items :List<navigationItems> ):BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = LayoutInflater.from(ctx)

        var v = convertView

        if (v == null){

            v = inflater.inflate(R.layout.navigationlayout,null) as LinearLayout
        }

        // populate the navigation items

        val item = items[position]
        var title = v.findViewById<Button>(R.id.drawer_item)
        title.text = item.title
        title.setOnClickListener {
            item.onclick.run()
        }

        return v

    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return 0L
    }

    override fun getCount(): Int {
        return items.size
    }
}