package f10

class Partido {

    static constraints = {
    }

    def jugadoresAnotados = [];
    def jugadoresConfirmados = [];
    Date fecha;
    Cancha cancha;
    EstadosPartido estado;
}

enum EstadosPartido {
   PENDIENTE,
   CANCELADO,
   FINALIZADO
}
