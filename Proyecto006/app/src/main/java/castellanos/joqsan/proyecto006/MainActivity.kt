package castellanos.joqsan.proyecto006

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se capturan los componentes
        val tv1 = findViewById<TextView>(R.id.tv1)
        val list1 = findViewById<ListView>(R.id.list1)

        //Se crean los arreglos para los paises y sus respectivas poblaciones
        val paises = arrayOf("Argentina", "Chile", "Paraguay", "Bolivia", "México", "Perú", "Guatemala")
        val habitantes = arrayOf(45_000_000, 20_000_000, 7_000_000, 12_000_000, 130_000_000, 33_000_000, 17_000_000)

        //Se configura el listview
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            paises
        )
        list1.adapter = adapter

        //Se le asigna el evento al listview
        list1.setOnItemClickListener { adapterView, view, i, l ->
            tv1.text = "Población: ${habitantes[i]}"
        }
    }
}