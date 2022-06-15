package f10

import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class US3OrganizarPartidoCasualSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "OrganizarPartidoCasual"() {

        given:"Como jugador de un grupo de amigos."

        Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);
        Jugador jugadorOrganizador = new Jugador(nombre: "Javier", edad: 23, email: "jnunezl@fi.uba.ar", whatsapp: "11-2243-6789", reputacion: reputacion);

        GrupoDeAmigos grupoDeAmigos = new GrupoDeAmigos(nombre: "FUTBOL 24/7");
        grupoDeAmigos.agregarAmigo(jugadorOrganizador);

        jugadorOrganizador.agregarGrupoDeAmigos(grupoDeAmigos);

        when:"Quiero seleccionar un día, horario y cancha para jugar un partido."

        // Buscar cancha disponible en establecimiento
        Cancha cancha = new Cancha(numero: 5);

        def fecha = new Date();
        Casual partidoCasual = new Casual(fecha, cancha);
        partidoCasual.anotarJugador(jugadorOrganizador);
        partidoCasual.confirmarJugador(jugadorOrganizador);

        then:"Crear partido casual y notificar a todos los miembros de mi grupo de amigos."

        partidoCasual.jugadoresAnotados.size == 1;
        partidoCasual.jugadoresConfirmados.size == 1;
        partidoCasual.estado == EstadosPartido.PENDIENTE;
        partidoCasual.cancha.numero == "5";
        // add id in a new base entity 
    }
}
