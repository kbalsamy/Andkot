package com.thiran.journal.activity.permission

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

abstract class permissionCompactActivity:AppCompatActivity() {

    private val latestPermissionRequest = AtomicInteger()

    private val permissionRequests = ConcurrentHashMap<Int, List<String>>()

    private val permissionCallbacks = ConcurrentHashMap <List<String>, PermissionRequestCallback>()

    private val defaultPermissionCallback = object : PermissionRequestCallback {

        override fun onPermissionGranted(permission: List<String>) {

            Log.i("Permission", "permission granded [$permission]")
        }

        override fun onPermissionDenied(permission: List<String>) {
            Log.i("Permission", "permission not granded [$permission]")
        }

    }

    fun requestPermissions(vararg permission:String, callback:PermissionRequestCallback = defaultPermissionCallback){

        val id = latestPermissionRequest.incrementAndGet()
        val items = mutableListOf<String>()
        items.addAll(permission)
        permissionRequests[id] = items
        permissionCallbacks[items] = callback
        ActivityCompat.requestPermissions(this, permission, id)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        val items = permissionRequests[requestCode]

        items?.let {
            val callback = permissionCallbacks[items]
            callback?.let {
                var success = true
                for (x in 0..grantResults.lastIndex){
                    val result = grantResults[x]
                    if (result != PackageManager.PERMISSION_GRANTED){
                        success = false
                        break
                    }
                    if (success){
                        callback.onPermissionGranted(items)
                    }
                    else {
                        callback.onPermissionDenied(items)
                    }
                }
            }
        }
    }

}