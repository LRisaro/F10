package f10

class Partido {

    static constraints = {
    }

    // Constructor
    // Cuadno se crea un nuevo partido es necesario notificar al grupo de amigo del jugador que organiza el partido.

    def jugadoresAnotados = [];
    def jugadoresConfirmados = [];
    Date fecha;
    Cancha cancha;
    EstadosPartido estado;
}
