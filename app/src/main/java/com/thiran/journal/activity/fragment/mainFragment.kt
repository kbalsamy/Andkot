package com.thiran.journal.activity.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.thiran.journal.R
import com.thiran.journal.activity.MainActivity
import com.thiran.journal.activity.NoteActivity
import com.thiran.journal.activity.TodoActivity

class mainFragment:BaseFragment() {

    override val frag_tag: String
        get() = "Main Fragment"

    override fun getFragment(): Int {
        return R.layout.fragmentlayout
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(getFragment(), container, false)

        val btn = view?.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        btn?.setOnClickListener{

            val items = arrayOf("Notes", "Todos")

            val builder = AlertDialog.Builder(this@mainFragment.context).setTitle("choose").setItems(items) { _, which ->
                when (which)  {
                    0 -> {openNotes()}
                    1 -> {openTodo()}
                    else -> {
                        Log.v("fragment", "Menu selection not done")}

                }
            }

            builder.show()


        }

        return view
    }

    private fun openNotes(){

        val intent  = Intent(context, NoteActivity::class.java)
        startActivity(intent)

    }

    private fun openTodo(){
        val intent = Intent(context, TodoActivity::class.java)
        startActivity(intent)
    }
}