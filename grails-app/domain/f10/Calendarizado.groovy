package f10

class Calendarizado extends Partido {

    static constraints = {
    }

    Date fechaInicial;
    int periodicidad;

    Calendarizado(fecha, cancha) {
        super(fecha, cancha);
    }
}
