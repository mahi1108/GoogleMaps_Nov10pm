package cubex.mahesh.googlemaps_nov10pm

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sFrag = supportFragmentManager.
                findFragmentById(R.id.frag1) as SupportMapFragment
        sFrag.getMapAsync {

           var lManager = getSystemService(Context.LOCATION_SERVICE)
                                                as LocationManager
            lManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    1000L,1F,
                    object : LocationListener {
                        override fun onLocationChanged(p0: Location?) {

                            var lati = p0!!.latitude
                            var longi = p0!!.longitude

                            var options = MarkerOptions( )
                            options.position(LatLng(lati,longi))
                            options.icon(BitmapDescriptorFactory.fromResource(
                                    R.drawable.delivery_truck))
                            it.addMarker(options)

                            lManager.removeUpdates(this)

                        }

                        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                        }

                        override fun onProviderEnabled(p0: String?) {
                        }

                        override fun onProviderDisabled(p0: String?) {
                        }
                    })




        }
    }
}
