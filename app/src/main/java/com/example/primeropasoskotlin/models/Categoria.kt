package com.example.primeropasoskotlin.models

class Categoria(nombreCategoria: String, idCategoria: Int) {
    private var nombreCategoria: String = nombreCategoria
    private var idCategoria: Int = idCategoria

    // Getter para nombreCategoria
    fun getNombreCategoria(): String {
        return this.nombreCategoria
    }

    // Getter para idCategoria
    fun getIdCategoria(): Int {
        return this.idCategoria
    }
}