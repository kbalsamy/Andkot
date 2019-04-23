package com.thiran.journal.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.widget.Toast
import com.thiran.journal.R
import com.thiran.journal.activity.fragment.mainFragment
import com.thiran.journal.activity.navigation.navigationAdapter
import com.thiran.journal.activity.navigation.navigationItems
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity:BaseActivity() {

    override val tag: String
        get() = "Main Activity"

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // to support ViewPager, need adapter which instatiate FragmentstatePageradapter and passing fragment manager to it.
        pager.adapter = viewPageAdapter(supportFragmentManager)

        val menuItems = mutableListOf<navigationItems>()
        // creating menu items with corresponding fragments with help of viewpager
        val today = navigationItems("Today", Runnable { pager.setCurrentItem(0, true) })
        val next7days = navigationItems("Next7days", Runnable { pager.setCurrentItem(1,true) })
        val notes = navigationItems("Notes", Runnable { pager.setCurrentItem(2, true) })
        val todos = navigationItems("Todos", Runnable { pager.setCurrentItem(3, true) })

        menuItems.add(today)
        menuItems.add(next7days)
        menuItems.add(notes)
        menuItems.add(todos)

        val nag_adapter = navigationAdapter(this, menuItems)
        left_drawer.adapter = nag_adapter

    }

    private class viewPageAdapter(manager:FragmentManager):FragmentStatePagerAdapter(manager){

        override fun getItem(position: Int): Fragment {
            return mainFragment()
        }

        override fun getCount(): Int {
            return 4
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.drawermenuID -> {
                drawer.openDrawer(GravityCompat.START)
                return true
            }

            R.id.optionmenuID -> {

                Toast.makeText(this, "Option menu pressed", Toast.LENGTH_SHORT).show()
                return true

            }
            else -> return super.onOptionsItemSelected(item)
        }


    }


}