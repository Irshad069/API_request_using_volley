package com.example.api_request_using_volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

class search : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        if (!Places.isInitialized()){
            Places.initialize(applicationContext,"AIzaSyBOD5-j2ElNi1GuIbPEZntT1iNLHKassW4")
        }

        val autocompleteSupportFragment =
            (supportFragmentManager.findFragmentById(R.id.fragment)
                    as AutocompleteSupportFragment).setPlaceFields(
                listOf(Place.Field.LAT_LNG,Place.Field.NAME)
                    )

        autocompleteSupportFragment.setOnPlaceSelectedListener(object :PlaceSelectionListener{
            override fun onError(p0: Status) {
                Log.e("error",p0.statusMessage.toString())
            }

            override fun onPlaceSelected(p0: Place) {
               if (p0.latLng!=null){
                   val latlng = p0.latLng
                   Toast.makeText(this@search,latlng!!.toString(),Toast.LENGTH_SHORT).show()
               }
            }

        })

    }
}