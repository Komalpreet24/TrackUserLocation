package com.example.trackuserlocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.Intent
import com.example.trackuserlocation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    ActivityCompat.requestPermissions(
      this,
      arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.POST_NOTIFICATIONS),
      0
      )

    binding.button.setOnClickListener {

      Intent(applicationContext, LocationService::class.java).apply {
        action = LocationService.ACTION_START
        startService(this)
      }

    }

    binding.button2.setOnClickListener {

      Intent(applicationContext, LocationService::class.java).apply {
        action = LocationService.ACTION_STOP
        startService(this)
      }

    }


  }
}