package com.thiran.journal.activity.database

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.thiran.journal.activity.Journal

class DBHelper(val dbname:String, val version:Int):SQLiteOpenHelper(Journal.ctx, dbname, null, version) {

    companion object {
        val ID = "_id"
        val TABLE_NOTES = "Note"
        val TABLE_TODOS = "Todo"
        val COLUMN_TITLE = "Title"
        val COLUMN_MESSAGE ="Message"
        val COULMN_LOCATION_LATITUDE = "Latitude"
        val COULMN_LOCATION_LONGITUDE = "Longitude"
        val COULMN_SCHEDULEDFOR  = "scheduledfor"

    }

    private val CreateNoteTable = """ CREATE TABLE if not exists $TABLE_NOTES
        ( $ID integer PRIMARY KEY autoincrement,
         $COLUMN_TITLE text,
         $COLUMN_MESSAGE text,
         $COULMN_LOCATION_LATITUDE real,
         $COULMN_LOCATION_LONGITUDE real)
    """

    private val CreateTodoTable = """ CREATE TABLE if not exists $TABLE_NOTES
        ( $ID integer PRIMARY KEY autoincrement,
         $COLUMN_TITLE text,
         $COLUMN_MESSAGE text,
         $COULMN_SCHEDULEDFOR integer,
         $COULMN_LOCATION_LATITUDE real,
         $COULMN_LOCATION_LONGITUDE real)
    """


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CreateNoteTable)
        db?.execSQL(CreateTodoTable)
        Log.v("Database", "Tables created for Notes and Todos")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}