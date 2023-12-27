package castellanos.joqsan.proyecto003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se capturan los componentes
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val r1 = findViewById<RadioButton>(R.id.r1)
        val r2 = findViewById<RadioButton>(R.id.r2)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val button = findViewById<Button>(R.id.button)

        //Se agrega el evento clic al boton
        button.setOnClickListener{

            //Si el radio 1 esta seleccionado se hace la suma
            if(r1.isChecked) {

                tv1.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
            }

            //Si el radio 2 esta seleccionado se hace la resta
            if(r2.isChecked) {

                tv1.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
            }
        }
    }
}