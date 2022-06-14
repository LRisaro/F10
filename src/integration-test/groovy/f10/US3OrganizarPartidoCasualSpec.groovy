package f10

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
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
        grupoDeAmigos.jugadores.add(jugadorOrganizador);

        jugadorOrganizador.gruposDeAmigos.add(grupoDeAmigos);

        when:"Quiero seleccionar un día, horario y cancha."

        // Establecimiento 
        Direccion direccion = new Direccion(calle: "Paseo colon", altura: "850");

        Cancha cancha = new Cancha(numero: 5);

        // Buscar cancha disponible en establecimiento

        Casual partidoCasual = new Casual();
        partidoCasual.jugadoresAnotados.add(jugadorOrganizador);
        partidoCasual.jugadoresConfirmados.add(jugadorOrganizador);
        partidoCasual.fecha = new Date();
        partidoCasual.cancha = cancha;
        partidoCasual.estado = EstadosPartido.PENDIENTE;


        then:"Crear partido casual y notificar a todos los miembros de mi grupo de amigos."
        partidoCasual.jugadoresAnotados.size == 1;
        partidoCasual.jugadoresConfirmados.size == 1;
        // add id in a new base entity 
    }
}
