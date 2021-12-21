package com.dicoding.schoolreview.detail

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.schoolreview.data.SchoolEntity
import com.dicoding.schoolreview.databinding.ActivityDetailTangkotBinding
import com.dicoding.schoolreview.databinding.ContentDetailTangkotBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.lang.Exception
import java.util.*

class DetailTangkotActivity : AppCompatActivity(), OnMapReadyCallback {
    companion object {
        const val EXTRA_TANGKOT = "extra_tangkot"
    }

    private lateinit var mMap: GoogleMap
    private val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    private lateinit var mMapView: MapView
    private lateinit var geocoder: Geocoder

    private lateinit var detailContentTangkotBinnding: ContentDetailTangkotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTangkotBinding = ActivityDetailTangkotBinding.inflate(layoutInflater)
        detailContentTangkotBinnding = activityDetailTangkotBinding.detailContent1
        setContentView(activityDetailTangkotBinding.root)

        val viewmodel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ViewModelDetailTangkot::class.java]

        val extras = intent.extras
        val faktor = extras?.getString(EXTRA_TANGKOT)
        if (extras != null) {
            if (faktor != null) {
                // println(viewModel)
                viewmodel.setSelectTitle(faktor)
                populatemovies(viewmodel.getTangkot())
            }
        }
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }
        mMapView = detailContentTangkotBinnding.userListMap
        mMapView.onCreate(mapViewBundle)

        mMapView.getMapAsync(this)
        geocoder = Geocoder(this)

        val actionbar = supportActionBar
        actionbar!!.title = "Info"

        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    private fun populatemovies(geCinema: SchoolEntity) {
        detailContentTangkotBinnding.textName.text = geCinema.name
        detailContentTangkotBinnding.textJalan.text = geCinema.street
        detailContentTangkotBinnding.textNomer.text = geCinema.number
        Glide.with(this@DetailTangkotActivity).load(geCinema.imagePath).into(detailContentTangkotBinnding.imagePoster)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {

            this.finish()
            true
        }
        else -> {
            true
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY)
        if (mapViewBundle == null) {
            mapViewBundle = Bundle()
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle)
        }
        mMapView.onSaveInstanceState(mapViewBundle)
    }

    override fun onResume() {
        super.onResume()
        mMapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mMapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMapView.onStop()
    }




    override fun onMapReady(map: GoogleMap) {


        mMap = map

        try {
            var geoResults: List<Address> = geocoder.getFromLocationName( detailContentTangkotBinnding.textName.text.toString(), 1)
            val addr: Address = geoResults.get(0)

            // map.addMarker(MarkerOptions().position(LatLng(addr.latitude, addr.longitude)).title("Marker"))
            Log.d("TAG","onmapready : " + addr.toString())
            Log.d("TAG","lang : " + addr.latitude.toString())
            Log.d("TAG","long : " + addr.longitude.toString())
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(addr.latitude, addr.longitude), 16F))

            val school = LatLng(addr.latitude, addr.longitude)
            mMap.addMarker(MarkerOptions().position(school).title(detailContentTangkotBinnding.textName.text.toString()))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(school))

        }
        catch(e : Exception) {
            e.printStackTrace()
        }







//get LatLong


        //get LatLong




    }



    override fun onPause() {
        mMapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mMapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView.onLowMemory()
    }


    fun geoLocate(view: View){
        val geocoder = Geocoder(this, Locale.getDefault())



        var geoResults: List<Address> = geocoder.getFromLocationName("london", 1)


        val addr: Address = geoResults[0]
        mMap.addMarker(MarkerOptions().position(LatLng(addr.latitude, addr.longitude)).title("Marker"))
    }

}