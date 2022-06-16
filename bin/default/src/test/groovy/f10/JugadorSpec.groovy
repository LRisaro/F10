package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class JugadorSpec extends Specification implements DomainUnitTest<Jugador> {

    def setup() {
    }

    def cleanup() {
    }

    void "CreoJugadorNuevo"() {

        Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

        Jugador jugador = new Jugador(nombre: "jugador", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);

        expect:"fix me"
            jugador.nombre == "jugador";
            jugador.edad == 18;
            jugador.email == "asd@asd.com";       
    }
}
