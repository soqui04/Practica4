package mx.edu.itson.practica4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            // Obtener valores de los EditText
            val peso = etPeso.text.toString().toFloatOrNull()
            val altura = etAltura.text.toString().toFloatOrNull()

            // Validar que los datos sean correctos
            if (peso == null || altura == null || peso <= 0 || altura <= 0) {
                tvResultado.text = "⚠️ Ingresa valores válidos."
                return@setOnClickListener
            }

            // Calcular el IMC
            val imc = peso / (altura * altura)

            // Determinar la categoría
            val categoria = when {
                imc < 18.5 -> "Bajo peso 🟡"
                imc < 24.9 -> "Peso normal ✅"
                imc < 29.9 -> "Sobrepeso 🟠"
                else -> "Obesidad 🔴"
            }

            // Mostrar el resultado en el TextView
            tvResultado.text = "Tu IMC es: %.2f\nCategoría: $categoria".format(imc)
        }
    }
}