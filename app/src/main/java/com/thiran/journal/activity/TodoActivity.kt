package com.thiran.journal.activity

import com.thiran.journal.R

class TodoActivity:itemActivity() {

    override val tag: String
        get() = "Todo Activity"

    override fun getLayout(): Int {
        return R.layout.todolayout
    }
}