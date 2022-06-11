package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DireccionSpec extends Specification implements DomainUnitTest<Direccion> {

    def setup() {
    }

    def cleanup() {
    }

    void "CrearNuevaDireccion"() {

        Direccion direccion = new Direccion(calle: "Suipacha", altura: "875");
        expect:"fix me"
            direccion.calle == "Suipacha";
            direccion.altura == "875";
    }
}
