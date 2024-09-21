package com.example.primeropasoskotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeropasoskotlin.models.Categoria

class Home : AppCompatActivity() {
    lateinit var carProducto:CardView
    lateinit var carIva:CardView
    lateinit var carcategoria:CardView
    lateinit var carproveedor:CardView
    lateinit var carcliente:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoBoton()
    }

    fun cargarR(){
        carProducto = findViewById(R.id.carProducto)
        carIva = findViewById(R.id.carIva)
        carproveedor = findViewById(R.id.carProv)
        carcategoria = findViewById(R.id.carCates)
        carcliente = findViewById(R.id.clienttttt)
    }

    fun estadoBoton(){
        carIva.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        carProducto.setOnClickListener{
            val i = Intent(this,Productos::class.java)
            startActivity(i)
        }
        carproveedor.setOnClickListener{
            val i = Intent(this,Proveedores::class.java)
            startActivity(i)
        }
        carcategoria.setOnClickListener{
            val i = Intent(this,Kategoria::class.java)
            startActivity(i)
        }


    }
}