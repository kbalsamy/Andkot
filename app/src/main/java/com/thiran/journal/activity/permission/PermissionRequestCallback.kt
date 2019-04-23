package com.thiran.journal.activity.permission

interface PermissionRequestCallback {

    fun onPermissionGranted(permission:List<String>)
    fun onPermissionDenied(permission: List<String>)
}