package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etIdentificador: EditText
    private lateinit var etPassword: EditText
    private lateinit var spRol: Spinner
    private lateinit var btnIniciarSesion: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar vistas desde el diseño XML
        etIdentificador = findViewById(R.id.etIdentificador)
        etPassword = findViewById(R.id.etPassword)
        spRol = findViewById(R.id.spRol)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        tvResultado = findViewById(R.id.tvResultado)

        // Poblar el Spinner de Roles
        val roles = arrayOf("Administrador", "Operario", "Veterinario")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, roles)
        spRol.adapter = adapter

        // Manejador de evento al presionar INICIAR SESIÓN
        btnIniciarSesion.setOnClickListener {
            validarIngreso()
        }
    }

    private fun validarIngreso() {
        val identificador = etIdentificador.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val rolSeleccionado = spRol.selectedItem.toString()

        // Validar que los campos no estén vacíos
        if (identificador.isEmpty() || password.isEmpty()) {
            tvResultado.text = getString(R.string.error_campos_vacios)
            tvResultado.setTextColor(resources.getColor(android.R.color.holo_red_dark, theme))
            tvResultado.visibility = View.VISIBLE
            Toast.makeText(this, getString(R.string.toast_llenar_campos), Toast.LENGTH_SHORT).show()
            return
        }

        // Simulación de ingreso correcto
        tvResultado.text = getString(R.string.bienvenida_sigepor, rolSeleccionado)
        tvResultado.setTextColor(resources.getColor(android.R.color.holo_green_dark, theme))
        tvResultado.visibility = View.VISIBLE

        Toast.makeText(this, getString(R.string.toast_ingreso_exitoso, rolSeleccionado), Toast.LENGTH_SHORT).show()

        // AQUÍ PUEDES REDIRIGIR A LA SIGUIENTE ACTIVIDAD:
        // val intent = Intent(this, RegistroPorcinoActivity::class.java)
        // startActivity(intent)
    }
}
