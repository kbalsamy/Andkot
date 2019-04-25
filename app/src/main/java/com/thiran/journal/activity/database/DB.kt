package com.thiran.journal.activity.database


import android.content.ContentValues
import android.util.Log
import com.thiran.journal.activity.model.Note
import java.lang.StringBuilder

object DB {

    private val version = 1
    private val name = "Journal"


    val NOTE = object : Crud<Note> {

        override fun insert(what: Note): Long {
            val inserted = insert(listOf(what))
            if (!inserted.isEmpty()) {return inserted[0]}
            return 0
        }

        override fun insert(what: Collection<Note>): List<Long> {

            val db = DBHelper(name,version).writableDatabase
            db.beginTransaction()

            var inserted = 0
            val items = mutableListOf<Long>()
            what.forEach { item ->

                val values = ContentValues()

                values.put(DBHelper.COLUMN_TITLE, item.title)
                values.put(DBHelper.COLUMN_MESSAGE, item.message)
                values.put(DBHelper.COULMN_LOCATION_LATITUDE, item.location.latitude)
                values.put(DBHelper.COULMN_LOCATION_LONGITUDE, item.location.latitude)

                val id = db.insert(DBHelper.TABLE_NOTES, null, values)

                if (id > 0){
                    items.add(id)
                    Log.v("Database", "Values inserted")
                    inserted++
                }
            }

            val success = inserted == what.size

            if (success){

                db.setTransactionSuccessful()
            }
            else{

                items.clear()

            }

            db.endTransaction()
            db.close()
            return items

        }

        override fun update(what: Note): Int = update(listOf(what))

        override fun update(what: Collection<Note>): Int {

            val db = DBHelper(name,version).writableDatabase
            db.beginTransaction()

            var updated = 0

            what.forEach { item ->

                val values = ContentValues()
                values.put(DBHelper.COLUMN_TITLE, item.title)
                values.put(DBHelper.COLUMN_MESSAGE, item.message)
                values.put(DBHelper.COULMN_LOCATION_LATITUDE, item.location.latitude)
                values.put(DBHelper.COULMN_LOCATION_LONGITUDE, item.location.latitude)

                db.update(DBHelper.TABLE_NOTES,values, "_id=?", arrayOf(item.id.toString()) )
                updated++
            }

            val result = updated == what.size
            if(result){
                db.setTransactionSuccessful()
            }
            else{
                updated = 0

            }
            db.endTransaction()
            db.close()
            return updated
        }

        override fun delete(what: Note): Int = delete(listOf(what))

        override fun delete(what: Collection<Note>): Int {

            val db = DBHelper(name,version).writableDatabase
            db.beginTransaction()
            val ids = StringBuilder()
            what.forEachIndexed { index, note ->
                ids.append(note.id.toString())
                if (index< what.size-1){
                    ids.append(", ")
                }

                val statement = "DELETE FROM ${DBHelper.TABLE_NOTES} WHERE ${DBHelper.ID} in "


            }


        }

        override fun select(args: Pair<String, String>): List<Note> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun select(args: Collection<Pair<String, String>>): List<Note> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun selectAll(): List<Note> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}