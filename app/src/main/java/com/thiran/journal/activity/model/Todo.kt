package com.thiran.journal.activity.model

import android.location.Location

class Todo(title:String, message:String, location:Location, var scheduledfor:Long):Entry(title, message, location) {

    override var id: Long = 0L

}
