package castellanos.joqsan.crud_maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class EliminarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        ArrayList<EditText> campos = new ArrayList<EditText>();
        campos.add(findViewById(R.id.e_text_id));

        new Metodos.Eliminar(
                findViewById(R.id.e_btn_registrar),
                findViewById(R.id.e_btn_buscar),
                findViewById(R.id.e_btn_actualizar),
                findViewById(R.id.e_btn_eliminar),
                EliminarActivity.this,
                campos
        );
    }
}