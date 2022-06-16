package f10

class Partido {

    static constraints = {
    }
    // Cuadno se crea un nuevo partido es necesario notificar al grupo de amigo del jugador que organiza el partido.

    def jugadoresAnotados = []
    def jugadoresConfirmados = []
    def jugadoresSuplentes = []
    Date fecha
    Cancha cancha
    EstadosPartido estado

    Partido(fecha, cancha) {
        this.fecha = fecha
        this.cancha = cancha
        this.estado = EstadosPartido.PENDIENTE
    }

    def anotarJugador(jugador) {
        if (jugador.reputacion.tieneBuenaReputacion()) {
            if (jugadoresAnotados.size < 10) {
                jugadoresAnotados.add(jugador)
            } else {
                jugadoresSuplentes.add(jugador)
            }
        }
    // TODO notificacion al grupo
    }

    def confirmarJugador(jugador) {
        jugadoresConfirmados.add(jugador)
    }

    def darDeBajaJugador(jugador) {
        jugadoresConfirmados.remove(jugador)
        jugador.penalizar()
    }

}
