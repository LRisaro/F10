package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class JugadorSpec extends Specification implements DomainUnitTest<Jugador> {

    def setup() {
    }

    def cleanup() {
    }

    void "CreoJugadorNuevo"() {

        when:
        Jugador jugador = new Jugador(nombre: "jugador", edad: 18, email: "asd@asd.com", whatsapp: '123456789');

        then:
        jugador.nombre == "jugador";
        jugador.edad == 18;
        jugador.email == "asd@asd.com";       
    }

    void "CreoJugadorNuevoConNombreVacio"() {

        when:
        Jugador jugador = new Jugador(nombre: "", edad: 18, email: "asd@asd.com", whatsapp: '123456789');

        then:
        NombreVacioException
    }

    void "CreoJugadorNuevoConEdadInvalida"() {

        when:
        Jugador jugador = new Jugador(nombre: "Javier", edad: 0, email: "asd@asd.com", whatsapp: '123456789');

        then:
        EdadInvalidaException
    }

    void "CreoJugadorNuevoConEmailVacio"() {

        when:
        Jugador jugador = new Jugador(nombre: "Javier", edad: 45, email: "", whatsapp: '123456789');

        then:
        EmailVacioException
    }

    void "CreoJugadorNuevoConWhatsappVacio"() {

        when:
        Jugador jugador = new Jugador(nombre: "Javier", edad: 45, email: "asf@fi.uba.ar", whatsapp: '');

        then:
        EmailVacioException
    }
}
