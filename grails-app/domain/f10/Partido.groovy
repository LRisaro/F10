package f10

class Partido {

    static constraints = {
    }

    // Constructor (fecha, cancha)
    // Cuadno se crea un nuevo partido es necesario notificar al grupo de amigo del jugador que organiza el partido.

    def jugadoresAnotados = [];
    def jugadoresConfirmados = [];
    def jugadoresSuplentes = [];
    Date fecha;
    Cancha cancha;
    EstadosPartido estado = EstadosPartido.PENDIENTE;

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
