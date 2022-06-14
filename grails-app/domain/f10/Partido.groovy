package f10

abstract class Partido {

    static constraints = {
    }
    // Cuadno se crea un nuevo partido es necesario notificar al grupo de amigo del jugador que organiza el partido.

    def jugadoresAnotados = [];
    def jugadoresConfirmados = [];
    def jugadoresSuplentes = [];
    Date fecha;
    Cancha cancha;
    EstadosPartido estado;

    Partido(fecha, cancha) {
        this.fecha = fecha;
        this.cancha = cancha;
        this.estado = EstadosPartido.PENDIENTE;
    }

    def anotarJugador(jugador) {
        jugadoresAnotados.add(jugador);

        // hay 10 jugadores anotados
        // notificacion al grupo

        // si hay 10 jugadores entra la lofica de anotar como suplente
    }

    def confirmarJugador(jugador) {
        jugadoresConfirmados.add(jugador)
    }
}
