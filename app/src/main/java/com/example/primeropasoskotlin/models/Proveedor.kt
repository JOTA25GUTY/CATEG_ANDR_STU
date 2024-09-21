class Proveedor(nombreprov: String, idProveedor: Int) {
    private var nombreprov: String = nombreprov
    private var idProveedor: Int = idProveedor

    // Getter para nombreprov
    fun getNombreProv(): String {
        return this.nombreprov
    }

    // Getter para idProveedor
    fun getIdProveedor(): Int {
        return this.idProveedor
    }
}