import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Tests: DescribeSpec ({
    describe("Dado un cliente normal") {

        // para los clientes normales, si no son morosos (la deuda debe ser 0)
        val cliente = ClienteNormal()

        it("Si no es moroso se puede pagar") {
            cliente.sePuedePagarSiniestro() shouldBe true
        }

        it("Si es moroso no se puede pagar") {
            cliente.deuda = 1
            cliente.sePuedePagarSiniestro() shouldBe false
        }
    }

    describe("Dado una flota chica") {

        // para las flotas de autos, se soporta una deuda de hasta $ 10.000 si el cliente tiene más de 5 vehículos ó hasta $ 5.000 en caso contrario
        val flotaChica = Flota(cantidadVehiculos = 5)

        it("Si la deuda es chica se puede pagar") {
            flotaChica.sePuedePagarSiniestro() shouldBe true
        }

        it("Si la deuda es grande no se puede pagar") {
            flotaChica.deuda = 5001
            flotaChica.sePuedePagarSiniestro() shouldBe false
        }
    }

    describe("Dado una flota grande") {

        val flotaGrande = Flota(cantidadVehiculos = 6)

        it("Si la deuda es chica se puede pagar") {
            flotaGrande.sePuedePagarSiniestro() shouldBe true
        }

        it("Si la deuda es grande no se puede pagar") {
            flotaGrande.deuda = 10001
            flotaGrande.sePuedePagarSiniestro() shouldBe false
        }
    }

})
