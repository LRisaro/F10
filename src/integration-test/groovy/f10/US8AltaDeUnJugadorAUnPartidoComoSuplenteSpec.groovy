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

        given:"Como jugador de un grupo de amigos quiero anotarme para jugar un partido pero el cupo de jugadores está lleno"        
        // Reputacion
        Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

        Reputacion reputacionSuplente = new Reputacion(partidosAbandonados: 3, partidosJugados: 13);
        Reputacion reputacionSuplente1 = new Reputacion(partidosAbandonados: 6, partidosJugados: 10);

        // Jugadores
        Jugador jugador1 = new Jugador(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador2 = new Jugador(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador3 = new Jugador(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador4 = new Jugador(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador5 = new Jugador(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador6 = new Jugador(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador7 = new Jugador(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador8 = new Jugador(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador9 = new Jugador(nombre: "jugador9", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador10 = new Jugador(nombre: "jugador10", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador suplente = new Jugador(nombre: "suplente", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacionSuplente);
        Jugador suplente1 = new Jugador(nombre: "suplente1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacionSuplente1);


        // Grupo de amigos
        def jugadores = [jugador1, jugador2, jugador3, jugador4, jugador5, jugador6, jugador7, jugador8, jugador9, jugador10, suplente, suplente1];
        GrupoDeAmigos grupoDeAmigos = new GrupoDeAmigos(nombre: "SuipachaFC", jugadores: jugadores)

        when:"Voy a anotarme como jugador suplente."

        // Cancha
        Cancha cancha = new Cancha(numero: 5);

        // Partido
        Casual partidoCasual = new Casual();
        partidoCasual.fecha = new Date();
        partidoCasual.cancha = cancha;
        partidoCasual.estado = EstadosPartido.PENDIENTE;

        //Anoto jugadores
        partidoCasual.anotarJugador(jugador1);
        partidoCasual.anotarJugador(jugador2);
        partidoCasual.anotarJugador(jugador3);
        partidoCasual.anotarJugador(jugador4);
        partidoCasual.anotarJugador(jugador5);
        partidoCasual.anotarJugador(jugador6);
        partidoCasual.anotarJugador(jugador7);
        partidoCasual.anotarJugador(jugador8);
        partidoCasual.anotarJugador(jugador9);
        partidoCasual.anotarJugador(jugador10);

        //Anoto jugadores suplentes
        partidoCasual.anotarJugador(suplente);
        partidoCasual.anotarJugador(suplente1);

        //Obtengo al jugador que deberia ser sumado a la lista de anotados por su reputacion
        Jugador jugadorSuplenteCorrecto = partidoCasual.jugadoresSuplentes.pop();
        jugadorSuplenteCorrecto.nombre ==  "suplente1";

        partidoCasual.anotarJugador(suplente1);

        //Doy de baja a un jugador de la lista de anotados pero sumo uno suplente asi que no deberia cambiar el size
        partidoCasual.darDeBajaJugadorAnotado(jugador1);

        then:"Di de baja a un jugador pero como hay suplentes el numero de jugadores anotados no debe variar y mi lista de jugadores suplente debe disminuir en 1 unidad."

        partidoCasual.jugadoresAnotados.size() == 10;
        partidoCasual.jugadoresSuplentes.size() == 1;

    }
}
