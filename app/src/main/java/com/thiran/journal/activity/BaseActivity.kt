package com.thiran.journal.activity

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.Toast
import com.thiran.journal.R
import com.thiran.journal.activity.permission.permissionCompactActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest


abstract class BaseActivity: permissionCompactActivity() {

    companion object{

        val REQUEST_GPS = 0
    }

    protected abstract val  tag :String

    protected abstract fun getLayout():Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setSupportActionBar(ToolbarID)
        requestPermissions(android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true

    }

    override fun onStart() {
        super.onStart()
        //Toast.makeText(this, "Activity started", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this, "Application on Resume started", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        //Toast.makeText(this, "Application On Pause started ", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
       //Toast.makeText(this, "Application stopped", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        //Toast.makeText(this, "Application destroyed", Toast.LENGTH_SHORT).show()
    }



}