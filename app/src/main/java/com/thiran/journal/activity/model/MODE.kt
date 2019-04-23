package com.thiran.journal.activity.model

enum class MODE(val mode:Int) {

    CREATE(0),
    EDIT(1),
    VIEW(2);

    companion object {

        val EXTRA_KEY = "mode"

        fun getValue(value:Int):MODE{

            values().forEach {
                item -> if (item.mode == value){
                return item
            }
            }
            return VIEW
        }
    }

}