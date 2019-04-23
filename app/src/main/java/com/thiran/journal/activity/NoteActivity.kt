package com.thiran.journal.activity

import com.thiran.journal.R

class NoteActivity:itemActivity() {

    override val tag: String
        get() = "Note Activity"

    override fun getLayout(): Int {
        return R.layout.notelayout
    }
}