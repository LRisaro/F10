package f10

class Partido {

    static constraints = {
    }

    // jugadores anotados
    // jugadores confirmados
    Date fecha;
    Cancha cancha;
    EstadosPartido estado;
}

enum EstadosPartido {
   PENDIENTE,
   CANCELADO,
   FINALIZADO
}
