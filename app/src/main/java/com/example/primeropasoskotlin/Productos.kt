package com.example.primeropasoskotlin


import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.primeropasoskotlin.db.AdminSQLiteOpenHelper
import com.example.primeropasoskotlin.models.Productos

class Productos : AppCompatActivity() {
    lateinit var btnAgregar:Button
    lateinit var txtNombre: EditText
    lateinit var txtPrecio: EditText
    lateinit var txtCodigo: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cargarR()
        estadoButon()
    }
    fun cargarR(){
        btnAgregar = findViewById(R.id.btnRegistrarProducto)
        txtNombre = findViewById(R.id.txtNombreProducto)
        txtCodigo = findViewById(R.id.txtCodigoProducto)
        txtPrecio = findViewById(R.id.txtPrecioProducto)
    }
    fun estadoButon(){
        btnAgregar.setOnClickListener{
            val obj = Productos(txtNombre.getText().toString(),txtPrecio.getText().toString().toDouble())
            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("id_producto", txtCodigo.getText().toString())
            registro.put("nombre", obj.getNombre())
            registro.put("precio", obj.getPrecio())
            bd.insert("producto", null, registro)
            bd.close()
            txtCodigo.setText("")
            txtNombre.setText("")
            txtPrecio.setText("")
            Toast.makeText(this, "Se cargaron los datos del producto", Toast.LENGTH_SHORT).show()
        }

    }
}