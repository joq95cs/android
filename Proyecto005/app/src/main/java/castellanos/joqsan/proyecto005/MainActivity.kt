package castellanos.joqsan.proyecto005

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.et1)
        val et2 = findViewById<EditText>(R.id.et2)
        val tv1 = findViewById<TextView>(R.id.tv1)
        val button = findViewById<Button>(R.id.button)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val lista = arrayOf(

            "Sumar",
            "Restar",
            "Multiplicar",
            "Dividir"
        )

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            lista
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        button.setOnClickListener {

            when(spinner.selectedItem.toString()) {

                "Sumar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
                "Restar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
                "Multiplicar" -> tv1.text = "Resultado: ${et1.text.toString().toInt() * et2.text.toString().toInt()}"
                "Dividir" -> tv1.text = "Resultado: ${et1.text.toString().toInt() / et2.text.toString().toInt()}"
            }
        }
    }
}