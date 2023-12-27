package castellanos.joqsan.proyecto008

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numero = (Math.random() * 100_001).toInt()
        Toast.makeText(this, "Número: ${numero}", Toast.LENGTH_LONG).show()

        val et1=findViewById<EditText>(R.id.et1)
        val boton1=findViewById<Button>(R.id.boton1)

        boton1.setOnClickListener {

            if (numero == et1.text.toString().toInt()) {

                Toast.makeText(this, "CORRECTO", Toast.LENGTH_LONG).show()

            } else {

                Toast.makeText(this, "INCORRECTO", Toast.LENGTH_LONG).show()
            }
        }
    }
}