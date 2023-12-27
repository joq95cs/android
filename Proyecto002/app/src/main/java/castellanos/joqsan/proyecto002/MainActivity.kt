package castellanos.joqsan.proyecto002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se guardan en variables los componentes de la aplicacion
        val et1 = findViewById<EditText>(R.id.et1) //Se guarda el primer input
        val et2 = findViewById<EditText>(R.id.et2) //Se guarda el segundo input
        val tv1 = findViewById<TextView>(R.id.tv1) //Se guarda la etiqueta
        val button = findViewById<Button>(R.id.button) //Se guarda el boton

        //Se asigna el evento clic al boton
        button.setOnClickListener {

            val n1 = et1.text.toString().toInt() //Se pasa a entero el primer valor
            val n2 = et2.text.toString().toInt() //Se pasa a entero el segundo valor
            val sum = n1 + n2 //Se hace la suma
            tv1.text = "Resultado: ${sum.toString()}" //Se coloca el resultado
        }


    }
}