package castellanos.joqsan.proyecto004

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se capturan los componentes en constantes
        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val check1 = findViewById<CheckBox>(R.id.check1)
        val check2 = findViewById<CheckBox>(R.id.check2)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val button = findViewById<Button>(R.id.button)

        //Se asigna el evento de clic al boton
        button.setOnClickListener {

            var resultado = "" //Variable a usar para el resultado

            //Si el primer check esta seleccionado se realiza la suma
            if(check1.isChecked) {

                //Se fija primero el resultado de la suma
                resultado = "Suma: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
                tv1.text = resultado
            }

            //Si el segundo check esta seleccionado se realiza la resta
            if (check2.isChecked) {

                //Se concatena para mostrar tanto suma como resta
                resultado += "\nResta: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
                tv1.text = resultado
            }
        }
    }
}