package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DireccionSpec extends Specification implements DomainUnitTest<Direccion> {

    def setup() {
    }

    def cleanup() {
    }

    void "CrearNuevaDireccion"() {

        given:"Como propietario de un establecimiento"

        when:"Creo mi establecimiento"
        Direccion direccion = new Direccion(calle: "Suipacha", altura: "875");

        then:"Verifco que los datos son correctos"
        direccion.calle == "Suipacha";
        direccion.altura == "875";
    }
}
