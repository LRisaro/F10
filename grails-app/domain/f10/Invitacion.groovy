package f10

class Invitacion {

    static constraints = {
    }

    Partido partido;
    Jugador jugador;

    Invitacion(partido, jugador) {
        this.partido = partido;
        this.jugador = jugador;
    }

    def aceptarInvitacion() {
        this.partido.anotarJugador(jugador)
        this.partido.confirmarJugador(jugador)
    }
}
