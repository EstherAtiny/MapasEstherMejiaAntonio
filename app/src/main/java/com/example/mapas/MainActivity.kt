package com.example.mapas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createMapFragment()
    }

    private fun createMapFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap
        createmarker()

    }
   private fun createmarker(){
       val coordinadas=LatLng(16.802674079196855, -96.43933500024748)
       val marker: MarkerOptions=MarkerOptions().position(coordinadas).title("Mi casa")
       map.addMarker(marker)
       map.animateCamera(
           CameraUpdateFactory.newLatLngZoom(coordinadas, 18f),
       4000,
           null
       )
   }
}