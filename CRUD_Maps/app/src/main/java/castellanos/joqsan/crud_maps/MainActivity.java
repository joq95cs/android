package castellanos.joqsan.crud_maps;

import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import android.location.Location;

public class MainActivity extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latitud = findViewById(R.id.r_text_latitud);
        longitud = findViewById(R.id.r_text_longitud);

        ArrayList<EditText> campos = new ArrayList<EditText>();
        campos.add(findViewById(R.id.r_text_id));
        campos.add(findViewById(R.id.r_text_nombre));
        campos.add(findViewById(R.id.r_text_pais));
        campos.add(findViewById(R.id.r_text_estado));
        campos.add(findViewById(R.id.r_text_descripcion));
        campos.add(latitud);
        campos.add(longitud);

        new Metodos.Registrar(
                findViewById(R.id.r_btn_registrar),
                findViewById(R.id.r_btn_buscar),
                findViewById(R.id.r_btn_actualizar),
                findViewById(R.id.r_btn_eliminar),
                MainActivity.this,
                campos
        );

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[] {

                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }

        findViewById(R.id.r_btn_ubicacion).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                getLocation();
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        try {

            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,MainActivity.this);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        try {

            latitud.setText(location.getLatitude() + "");
            longitud.setText(location.getLongitude() + "");

        }catch (Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onProviderDisabled(String provider) {}

    private LocationManager locationManager;
    private EditText latitud;
    private EditText longitud;
}