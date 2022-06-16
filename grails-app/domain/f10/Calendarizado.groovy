package f10

class Calendarizado {

    static constraints = {
    }

    Date fechaInicial;
    int periodicidad;
    Cancha cancha;
    def partidos = [];

    Calendarizado(fechaInicial, periodicidad, cancha) {
        this.fechaInicial = fechaInicial;
        this.periodicidad = periodicidad;
        this.cancha = cancha;

        agregarPartido(fechaInicial, cancha);
    }

    def procesar() {
        if (!this.partidos.isEmpty()) {
            def ultimoPartidoCalendarizado = this.partidos.get(this.partidos.size() - 1);

            if (ultimoPartidoCalendarizado.estado == EstadosPartido.CANCELADO || ultimoPartidoCalendarizado.estado == EstadosPartido.FINALIZADO) {
                agregarPartido(ultimoPartidoCalendarizado.fecha.plus(this.periodicidad), this.cancha);
            }

        } else {
            agregarPartido(this.fechaInicial, this.cancha);
        }
    }

    def proximoPartido() {
        return this.partidos.get(this.partidos.size - 1);
    }

    def agregarPartido(fecha, cancha) {
        Partido partido = new Partido(fecha, cancha)
        this.partidos.add(partido);
    }
}
