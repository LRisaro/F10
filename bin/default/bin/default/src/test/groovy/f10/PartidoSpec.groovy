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
        Partido partido = new Partido();
        partido.jugadores.add(jugador)

        expect:"fix me"
            partido.jugadores.size() == 1
            partido.jugadores[0].nombre == "Micaela";
    }
}
