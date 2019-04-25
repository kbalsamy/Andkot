package com.thiran.journal.activity.model

import android.location.Location
import com.thiran.journal.activity.database.DBmodel

abstract class Entry(var title:String, var message:String, var location:Location):DBmodel() {


}