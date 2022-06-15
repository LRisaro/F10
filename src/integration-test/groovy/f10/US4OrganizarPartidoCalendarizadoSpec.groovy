package f10

import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class US4OrganizarPartidoCalendarizadoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "OrganizarPartidoCalendarizado"() {

        given:"Como jugador de un grupo de amigos."

        Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);
        Jugador jugadorOrganizador = new Jugador(nombre: "Javier", edad: 23, email: "jnunezl@fi.uba.ar", whatsapp: "11-2243-6789", reputacion: reputacion);

        GrupoDeAmigos grupoDeAmigos = new GrupoDeAmigos(nombre: "FUTBITO SABADO");
        grupoDeAmigos.agregarAmigo(jugadorOrganizador);

        jugadorOrganizador.agregarGrupoDeAmigos(grupoDeAmigos);

        when:"Quiero seleccionar un día, horario y cancha para calendarizar el partido."

        // Buscar cancha disponible en establecimiento
        Cancha cancha = new Cancha(numero: 7);

        // Buscar cancha disponible en establecimiento
        def fechaInicial = new Date();
        def periodicidad = 7;

        Calendarizado partidoCalendarizado = new Calendarizado(fechaInicial, periodicidad, cancha);

        then:"Crear partido calendarizado y notificar a todos los miembros de mi grupo de amigos."

        partidoCalendarizado.partidos.size == 1; 
        def partidoEnCurso = partidoCalendarizado.proximoPartido();
        partidoEnCurso.cancha.numero == "7";
        partidoEnCurso.estado == EstadosPartido.PENDIENTE;
    }
}
