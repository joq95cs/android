package castellanos.joqsan.crud_maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class BuscarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        ArrayList<EditText> campos = new ArrayList<EditText>();
        campos.add(findViewById(R.id.b_text_id));
        campos.add(findViewById(R.id.b_text_nombre));
        campos.add(findViewById(R.id.b_text_pais));
        campos.add(findViewById(R.id.b_text_estado));
        campos.add(findViewById(R.id.b_text_descripcion));
        campos.add(findViewById(R.id.b_text_latitud));
        campos.add(findViewById(R.id.b_text_longitud));

        new Metodos.Buscar(
                findViewById(R.id.b_btn_registrar),
                findViewById(R.id.b_btn_buscar),
                findViewById(R.id.b_btn_actualizar),
                findViewById(R.id.b_btn_eliminar),
                BuscarActivity.this,
                campos
        );
    }
}