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
import com.example.primeropasoskotlin.models.Categoria

class Kategoria : AppCompatActivity() {
    lateinit var btnAgregarCate: Button
    lateinit var txtnombreCategoria: EditText
    lateinit var txtIDCategoria: EditText
    lateinit var txtDescripcion: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_categoria)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoButon()
    }
        fun cargarR() {
            btnAgregarCate = findViewById(R.id.btnRegistrarCategoria)
            txtIDCategoria = findViewById(R.id.txtCodCategoria)
            txtnombreCategoria = findViewById(R.id.txtNombreCategoria)
            txtDescripcion = findViewById(R.id.txtDescripcionCat)
        }
        fun estadoButon() {
            btnAgregarCate.setOnClickListener {
                val obj = Categoria(
                    txtnombreCategoria.getText().toString(),
                    txtIDCategoria.getText().toString().toInt()
                )
                val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("id_categoria", txtIDCategoria.getText().toString())
                registro.put("nombrecat", obj.getNombreCategoria())
                registro.put("descripcion", txtDescripcion.getText().toString())
                bd.insert("producto", null, registro)
                bd.close()
                txtIDCategoria.setText("")
                txtnombreCategoria.setText("")
                txtDescripcion.setText("")
                Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT).show()
            }
        }
}
