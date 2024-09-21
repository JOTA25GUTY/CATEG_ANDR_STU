package com.example.primeropasoskotlin

import Proveedor
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


class Proveedores : AppCompatActivity() {

    lateinit var btnAgregarProv: Button
    lateinit var txtNombreprov: EditText
    lateinit var txtIDprovedor: EditText
    lateinit var txtNIT: EditText
    lateinit var txtDireccion: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_proveedores)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoButon()
    }

    fun cargarR() {
        btnAgregarProv = findViewById(R.id.btnRegistrarProveedor)
        txtIDprovedor = findViewById(R.id.txtIdProv)
        txtNombreprov = findViewById(R.id.txtNombreProveedor)
        txtNIT = findViewById(R.id.txtNitProv)
        txtDireccion = findViewById(R.id.txtDireccion)
    }

    fun estadoButon() {
        btnAgregarProv.setOnClickListener {
            val obj = Proveedor(txtNombreprov.getText().toString(),txtIDprovedor.getText().toString().toInt())
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("id_proveedor", txtIDprovedor.getText().toString())
            registro.put("nombreprov", obj.getNombreProv())
            registro.put("nit", txtNIT.getText().toString())
            registro.put("direccion", txtDireccion.getText().toString())
            bd.insert("producto", null, registro)
            bd.close()
            txtIDprovedor.setText("")
            txtNombreprov.setText("")
            txtNIT.setText("")
            txtDireccion.setText("")
            Toast.makeText(this, "Se cargaron los datos del producto", Toast.LENGTH_SHORT).show()
        }
    }
}