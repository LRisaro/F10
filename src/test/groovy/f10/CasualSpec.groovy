package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CasualSpec extends Specification implements DomainUnitTest<Casual> {

    def setup() {
    }

    def cleanup() {
    }

    void "CrearPartidoCasual"() {
        Date fecha = new Date();
        Cancha cancha = new Cancha(numero: 6);

        Casual partidoCasual = new Casual(fecha, cancha);

        expect:"Se crea partido casual"
            partidoCasual.cancha.numero == "6"
            partidoCasual.fecha == fecha;
    }
}
