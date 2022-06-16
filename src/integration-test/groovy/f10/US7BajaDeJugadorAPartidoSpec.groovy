package f10

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import spock.lang.Specification

@Integration
class US7BajaDeJugadorAPartidoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Dar de baja un jugador de un partido"() {
        given:"Como jugador quiero darme de baja de un partido que confirmé"
            Jugador jugador1 = new Jugador()
            Jugador jugador2 = new Jugador()
            Casual partido = new Casual(new Date(), new Cancha(), jugador1)
            partido.confirmarJugador(jugador1)
            partido.confirmarJugador(jugador2)
            
        when: "me doy de baja del partido"
            partido.darDeBajaJugador(jugador2)

        then:"el jugador no se encuentra entre los confirmados"
            partido.jugadoresConfirmados.size() == 1
            partido.jugadoresConfirmados.indexOf(jugador2) == -1         
    }

    void "Se penaliza un jugador por darse de baja de un partido"() {
        given:"Como jugador quiero darme de baja de un partido que confirmé"
            Jugador jugador1 = new Jugador()
            Jugador jugador2 = new Jugador()
            Casual partido = new Casual(new Date(), new Cancha(), jugador1)
            partido.confirmarJugador(jugador1)
            partido.confirmarJugador(jugador2)

        when: "me doy de baja del partido"
            partido.darDeBajaJugador(jugador1)

        then:"el jugador es penalizado"
            jugador1.reputacion.partidosAbandonados == 1
    }
}
