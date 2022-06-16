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
    Jugador organizador

    Partido(fecha, cancha, organizador) {
        this.fecha = fecha
        this.cancha = cancha
        this.estado = EstadosPartido.PENDIENTE
        this.organizador = organizador
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

    def anotarJugadorSuplente(jugador) {
        jugadoresSuplentes.add(jugador)

        // ordeno de menor a mayor porcentaje de partidos jugados (creo XD)
        jugadoresSuplentes.sort { (it.reputacion.partidosJugados * 100) / (it.reputacion.partidosJugados + it.reputacion.partidosAbandonados) }
    }


    //TODO Estos metodos no tienen que estar implementados aca. Tienen que ir en cada uno de los distintos tipos de partido.
    def darDeBajaJugadorAnotado(jugador)
    {
        jugadoresAnotados.remove(jugador);
        
        if(jugadoresSuplentes.size() > 0){
            jugadoresAnotados.push(jugadoresSuplentes.pop());

        }
    }

    def darDeBajaJugador(jugador) {
        jugadoresConfirmados.remove(jugador)
        jugador.penalizar()
    }

}
