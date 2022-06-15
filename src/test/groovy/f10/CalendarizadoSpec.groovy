package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CalendarizadoSpec extends Specification implements DomainUnitTest<Calendarizado> {

    def setup() {
    }

    def cleanup() {
    }

    void "CrearPartidoCalendarizado"() {
        Date fechaInicial = new Date();
        int periodicidad = 7;
        Cancha cancha = new Cancha(numero: 6);

        Calendarizado calendarizado = new Calendarizado(fechaInicial, periodicidad, cancha);
        expect:"Se crea el partido calendarizado"
            calendarizado.periodicidad == 7
            calendarizado.cancha.numero == "6"
            calendarizado.fechaInicial == fechaInicial;
    }
}
