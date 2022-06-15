package f10

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import spock.lang.Specification

@Integration
class US1AgregarAmigoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Aceptar solicitud de amistad para un grupo de amigo"() {        
        given:"Como jugador recibo una solicitud para unirme a un grupo de amigo"
            GrupoDeAmigos grupo = new GrupoDeAmigos(nombre:"F10")
            Jugador jugador = new Jugador()
            SolicitudDeAmistad solicitud = new SolicitudDeAmistad(jugadorDestino: jugador, grupoSolicitante: grupo)

        when:"acepto la solicitud"
            solicitud.aceptarSolicitud()

        then:"la solicitud queda con estado aceptada"
            solicitud.estado == EstadosSolicitud.ACEPTADA

        then:"se agrega el grupo a mi lista de grupos"
            jugador.gruposDeAmigos.size() == 1
            jugador.gruposDeAmigos[0] == grupo
        
        then:"se agrega el jugador al grupo de amigos"
            grupo.jugadores.size() == 1
            grupo.jugadores[0] == jugador
    }

    void "Rechazar solicitud de amistad para un grupo de amigo"() {        
        given:"Como jugador recibo una solicitud para unirme a un grupo de amigo"
            GrupoDeAmigos grupo = new GrupoDeAmigos(nombre:"F10")
            Jugador jugador = new Jugador()
            SolicitudDeAmistad solicitud = new SolicitudDeAmistad(jugadorDestino: jugador, grupoSolicitante: grupo)

        when:"rechazo la solicitud"
            solicitud.rechazarSolicitud()

        then:"la solicitud queda con estado rechazada"
            solicitud.estado == EstadosSolicitud.RECHAZADA

        then:"no se agrega el grupo a mi lista de grupos"
            jugador.gruposDeAmigos.size() == 0
        
        then:"no se agrega el jugador al grupo de amigos"
            grupo.jugadores.size() == 0
    }
}
