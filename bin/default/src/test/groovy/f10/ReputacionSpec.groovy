package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ReputacionSpec extends Specification implements DomainUnitTest<Reputacion> {

    def setup() {
    }

    def cleanup() {
    }

    void "CrearReputacion"() {
         Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

        expect:"fix me"
            reputacion.partidosAbandonados == 0;
            reputacion.partidosJugados == 16;
    }
}
