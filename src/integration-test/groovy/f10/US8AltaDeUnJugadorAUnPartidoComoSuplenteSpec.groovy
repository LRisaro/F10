package f10

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import spock.lang.Specification

@Integration
@Rollback
class US8AltaDeUnJugadorAUnPartidoComoSuplenteSpec extends Specification {

    def setup() {
        // un partido con jugadores

        // dar de baja a un jugador
        // subir a uno de los suplentes
    }

    def cleanup() {
    }

    void "Alta de un jugador a un partido como suplente"() {

        // Reputacion
        Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

        // Jugadores
        Jugador jugador1 = new Direccion(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador2 = new Direccion(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador3 = new Direccion(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador4 = new Direccion(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador5 = new Direccion(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador6 = new Direccion(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador7 = new Direccion(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador8 = new Direccion(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador9 = new Direccion(nombre: "jugador9", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador10 = new Direccion(nombre: "jugador10", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador11 = new Direccion(nombre: "jugador11", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador12 = new Direccion(nombre: "jugador12", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);

        Jugador suplente = new Direccion(nombre: "suplente", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);

        given:"Como jugador de un grupo de amigos quiero anotarme para jugar un partido pero el cupo de jugadores está lleno"        

        // Grupo de amigos
        def jugadores = [jugador1, jugador2, jugador3, jugador4, jugador5, jugador6, jugador7, jugador8, jugador9, jugador10, jugador11, jugador12, suplente];
        GrupoDeAmigos grupoDeAmigos = new GrupoDeAmigos(nombre: "SuipachaFC", jugadores: jugadores)

        when:"Voy a anotarme como jugador suplente."

        // Cancha
        Cancha cancha = new Cancha(numero: 5);

        // Partido
        Casual partidoCasual = new Casual();
        partidoCasual.jugadoresAnotados.add(jugadorOrganizador);
        partidoCasual.jugadoresConfirmados.add(jugadorOrganizador);
        partidoCasual.fecha = new Date();
        partidoCasual.cancha = cancha;
        partidoCasual.estado = EstadosPartido.PENDIENTE;

        then:"Crear partido casual, completar los jugadores, dar de baja uno, anotar al suplente."

        partidoCasual.jugadoresAnotados.add(jugador1);
        partidoCasual.jugadoresAnotados.add(jugador2);
        partidoCasual.jugadoresAnotados.add(jugador3);
        partidoCasual.jugadoresAnotados.add(jugador4);
        partidoCasual.jugadoresAnotados.add(jugador5);
        partidoCasual.jugadoresAnotados.add(jugador6);
        partidoCasual.jugadoresAnotados.add(jugador7);
        partidoCasual.jugadoresAnotados.add(jugador8);
        partidoCasual.jugadoresAnotados.add(jugador9);
        partidoCasual.jugadoresAnotados.add(jugador10);
        
        partidoCasual.jugadoresConfirmados.size == 1;
    }
}
