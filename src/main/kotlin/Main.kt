open class ClienteNormal {
    var deuda = 0

    open fun sePuedePagarSiniestro(): Boolean = !esMoroso()

    private fun esMoroso(): Boolean = deuda > 0
}

class Flota(var cantidadVehiculos: Int): ClienteNormal() {

    override fun sePuedePagarSiniestro() = limiteDeuda() > deuda

    private fun limiteDeuda(): Int {
        if(cantidadVehiculos <= 5) {
            return 5000
        }
        else {
            return 10000
        }
    }
}