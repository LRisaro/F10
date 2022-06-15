package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PartidoSpec extends Specification implements DomainUnitTest<Partido> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        Jugador jugador = new Jugador(nombre: "Micaela")
        Jugador jugador1 = new Jugador(nombre: "Micaela2")

        Partido partido = new Partido();
        partido.jugadores.add(jugador)
        partido.jugadores.add(jugador1)

        partido.jugadores.size() == 2
        partido.jugadores[0].nombre == "Micaela";
    }
}
