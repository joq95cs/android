package castellanos.joqsan.proyecto007;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView boton1 = findViewById(R.id.boton1);
        TextView tv1 = findViewById(R.id.tv1);

        boton1.setOnClickListener(view -> {

            tv1.setText("Llamando");
        });
    }
}