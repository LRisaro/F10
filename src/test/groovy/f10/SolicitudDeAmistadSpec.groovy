package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class SolicitudDeAmistadSpec extends Specification implements DomainUnitTest<SolicitudDeAmistad> {

    def setup() {
    }

    def cleanup() {
    }

    void "Crear solicitud"() {
        GrupoDeAmigos grupo = new GrupoDeAmigos(nombre:"F10")
        Jugador jugador = new Jugador()
        SolicitudDeAmistad solicitud = new SolicitudDeAmistad(jugadorDestino: jugador, grupoSolicitante: grupo)

        expect:"se crea la solicitud con los datos esperados"
            solicitud.grupoSolicitante == grupo
            solicitud.jugadorDestino == jugador
    }
}
