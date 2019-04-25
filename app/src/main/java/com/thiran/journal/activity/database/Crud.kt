package com.thiran.journal.activity.database

interface Crud<T> where T :DBmodel{

    fun insert(what :T):Long
    fun insert(what: Collection<T>):List<Long>
    fun update (what:T):Int
    fun update(what:Collection<T>):Int
    fun delete(what: T):Int
    fun delete(what: Collection<T>):Int
    fun select(args:Pair<String, String>):List<T>
    fun select(args: Collection<Pair<String, String>>):List<T>
    fun selectAll():List<T>

}