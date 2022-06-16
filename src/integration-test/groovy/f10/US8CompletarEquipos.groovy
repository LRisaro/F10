package f10

import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
class US8CompletarEquipos extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void CompletarEquipoJugadoresAceptanInvitacion() {
    given:'Como Organizador de un partido, quiero Buscar jugadores disponibles, para Completar los faltantes de uno o ambos equipos'

    Jugador jugadorOrganizador = new Jugador()
    Jugador jugador = new Jugador()

    Establecimiento establecimiento = new Establecimiento("Test", "11111", new Direccion(localidad: "localidad2", calle: "Suipacha", altura: 288), new Tuple(100, 100))
    Cancha cancha = new Cancha(numero: 5)
    Partido partido = new Casual(new Date(), cancha, jugadorOrganizador)
    BuscadorJugadores ubicador = new BuscadorJugadores()
    Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

    // Jugadores
    Jugador jugador2 = new Jugador(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(10,10));
    Jugador jugador3 = new Jugador(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(20,20));
    Jugador jugador4 = new Jugador(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(30,30));
    Jugador jugador1 = new Jugador(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(40,40));
    Jugador jugador5 = new Jugador(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(50,50));
    Jugador jugador6 = new Jugador(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(60,60));
    Jugador jugador7 = new Jugador(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(70,70));
    Jugador jugador8 = new Jugador(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(80,80));
    Jugador jugador9 = new Jugador(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(10,10));
    Jugador jugador10 = new Jugador(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(25,25));
    Jugador jugador11 = new Jugador(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(35,35));
    Jugador jugador12 = new Jugador(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(45,45));
    Jugador jugador13 = new Jugador(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(55,55));
    Jugador jugador14 = new Jugador(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(65,65));
    Jugador jugador15 = new Jugador(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(75,75));
    Jugador jugador16 = new Jugador(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(85,85));

    // Agrego jugadores al Ubicador
    ubicador.agregarJugador(jugador1)
    ubicador.agregarJugador(jugador2)
    ubicador.agregarJugador(jugador3)
    ubicador.agregarJugador(jugador4)
    ubicador.agregarJugador(jugador5)
    ubicador.agregarJugador(jugador6)
    ubicador.agregarJugador(jugador7)
    ubicador.agregarJugador(jugador8)
    ubicador.agregarJugador(jugador9)
    ubicador.agregarJugador(jugador10)
    ubicador.agregarJugador(jugador11)
    ubicador.agregarJugador(jugador12)
    ubicador.agregarJugador(jugador13)
    ubicador.agregarJugador(jugador14)
    ubicador.agregarJugador(jugador15)
    ubicador.agregarJugador(jugador16)



    // Anoto jugadores
    partido.anotarJugador(jugador1)
    partido.anotarJugador(jugador2)
    partido.anotarJugador(jugador3)
    partido.anotarJugador(jugador4)
    partido.anotarJugador(jugador5)
    partido.anotarJugador(jugador6)
    partido.anotarJugador(jugador7)
    partido.anotarJugador(jugador8)


    when:'Faltan jugadores'
    then:'Busco jugadores y los invito'

    // Jugador 1
    Jugador jugadorPosible1 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible1.invitar(new Invitacion(partido, jugadorPosible1))
    jugadorPosible1.invitacionesPendientes.get(0).aceptarInvitacion()

    // Jugador 2
    Jugador jugadorPosible2 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible2.invitar(new Invitacion(partido, jugadorPosible2))
    jugadorPosible2.invitacionesPendientes.get(0).aceptarInvitacion()


    then:'Quedan Anotados'
    partido.jugadoresAnotados.contains(jugadorPosible1) == true
    partido.jugadoresAnotados.contains(jugadorPosible2) == true

  }


  void CompletarEquipoJugadoresAceptanInvitacionLosSegundos() {
    given:'Como Organizador de un partido, quiero Buscar jugadores disponibles, para Completar los faltantes de uno o ambos equipos'

    Jugador jugadorOrganizador = new Jugador()
    Jugador jugador = new Jugador()

    Establecimiento establecimiento = new Establecimiento("Test", "11111", new Direccion(localidad: "localidad2", calle: "Suipacha", altura: 288), new Tuple(100, 100))
    Cancha cancha = new Cancha(numero: 5)
    Partido partido = new Casual(new Date(), cancha, jugadorOrganizador)
    BuscadorJugadores ubicador = new BuscadorJugadores()
    Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

    // Jugadores
    Jugador jugador2 = new Jugador(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(10,10));
    Jugador jugador3 = new Jugador(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(20,20));
    Jugador jugador4 = new Jugador(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(30,30));
    Jugador jugador1 = new Jugador(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(40,40));
    Jugador jugador5 = new Jugador(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(50,50));
    Jugador jugador6 = new Jugador(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(60,60));
    Jugador jugador7 = new Jugador(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(70,70));
    Jugador jugador8 = new Jugador(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(80,80));
    Jugador jugador9 = new Jugador(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(10,10));
    Jugador jugador10 = new Jugador(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(25,25));
    Jugador jugador11 = new Jugador(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(35,35));
    Jugador jugador12 = new Jugador(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(45,45));
    Jugador jugador13 = new Jugador(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(55,55));
    Jugador jugador14 = new Jugador(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(65,65));
    Jugador jugador15 = new Jugador(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(75,75));
    Jugador jugador16 = new Jugador(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(85,85));

    // Agrego jugadores al Ubicador
    ubicador.agregarJugador(jugador1)
    ubicador.agregarJugador(jugador2)
    ubicador.agregarJugador(jugador3)
    ubicador.agregarJugador(jugador4)
    ubicador.agregarJugador(jugador5)
    ubicador.agregarJugador(jugador6)
    ubicador.agregarJugador(jugador7)
    ubicador.agregarJugador(jugador8)
    ubicador.agregarJugador(jugador9)
    ubicador.agregarJugador(jugador10)
    ubicador.agregarJugador(jugador11)
    ubicador.agregarJugador(jugador12)
    ubicador.agregarJugador(jugador13)
    ubicador.agregarJugador(jugador14)
    ubicador.agregarJugador(jugador15)
    ubicador.agregarJugador(jugador16)



    // Anoto jugadores
    partido.anotarJugador(jugador1)
    partido.anotarJugador(jugador2)
    partido.anotarJugador(jugador3)
    partido.anotarJugador(jugador4)
    partido.anotarJugador(jugador5)
    partido.anotarJugador(jugador6)
    partido.anotarJugador(jugador7)
    partido.anotarJugador(jugador8)


    when:'Faltan jugadores'
    // Jugador 1
    Jugador jugadorPosible1 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible1.invitar(new Invitacion(partido, jugadorPosible1))
    jugadorPosible1.invitacionesPendientes.get(0).negarInvitacion()

    // Jugador 2
    Jugador jugadorPosible2 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible2.invitar(new Invitacion(partido, jugadorPosible2))
    jugadorPosible2.invitacionesPendientes.get(0).negarInvitacion()


    then:'No quedan anotados'
    partido.jugadoresAnotados.contains(jugadorPosible1) == false
    partido.jugadoresAnotados.contains(jugadorPosible2) == false

    when:'Faltan jugadores'
    // Jugador 3
    Jugador jugadorPosible3 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible3.invitar(new Invitacion(partido, jugadorPosible3))
    jugadorPosible3.invitacionesPendientes.get(0).aceptarInvitacion()

    // Jugador 4
    Jugador jugadorPosible4 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible4.invitar(new Invitacion(partido, jugadorPosible4))
    jugadorPosible4.invitacionesPendientes.get(0).aceptarInvitacion()


    then:'No quedan anotados'
    partido.jugadoresAnotados.contains(jugadorPosible3) == true
    partido.jugadoresAnotados.contains(jugadorPosible4) == true

  }


  void CompletarEquipoJugadoresNoAceptanInvitacionCancelaPartido() {
    given:'Como Organizador de un partido, quiero Buscar jugadores disponibles, para Completar los faltantes de uno o ambos equipos'

    Jugador jugadorOrganizador = new Jugador()
    Jugador jugador = new Jugador()

    Establecimiento establecimiento = new Establecimiento("Test", "11111", new Direccion(localidad: "localidad2", calle: "Suipacha", altura: 288), new Tuple(100, 100))
    Cancha cancha = new Cancha(numero: 5)
    Partido partido = new Casual(new Date(), cancha, jugadorOrganizador)
    BuscadorJugadores ubicador = new BuscadorJugadores()
    Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

    // Jugadores
    Jugador jugador2 = new Jugador(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(10,10));
    Jugador jugador3 = new Jugador(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(20,20));
    Jugador jugador4 = new Jugador(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(30,30));
    Jugador jugador1 = new Jugador(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(40,40));
    Jugador jugador5 = new Jugador(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(50,50));
    Jugador jugador6 = new Jugador(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(60,60));
    Jugador jugador7 = new Jugador(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(70,70));
    Jugador jugador8 = new Jugador(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(80,80));
    Jugador jugador9 = new Jugador(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(10,10));
    Jugador jugador10 = new Jugador(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(25,25));
    Jugador jugador11 = new Jugador(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(35,35));
    Jugador jugador12 = new Jugador(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(45,45));
    Jugador jugador13 = new Jugador(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(55,55));
    Jugador jugador14 = new Jugador(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(65,65));
    Jugador jugador15 = new Jugador(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(75,75));
    Jugador jugador16 = new Jugador(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion, ubicacion: new Tuple(85,85));

    // Agrego jugadores al Ubicador
    ubicador.agregarJugador(jugador1)
    ubicador.agregarJugador(jugador2)
    ubicador.agregarJugador(jugador3)
    ubicador.agregarJugador(jugador4)
    ubicador.agregarJugador(jugador5)
    ubicador.agregarJugador(jugador6)
    ubicador.agregarJugador(jugador7)
    ubicador.agregarJugador(jugador8)
    ubicador.agregarJugador(jugador9)
    ubicador.agregarJugador(jugador10)
    ubicador.agregarJugador(jugador11)
    ubicador.agregarJugador(jugador12)
    ubicador.agregarJugador(jugador13)
    ubicador.agregarJugador(jugador14)
    ubicador.agregarJugador(jugador15)
    ubicador.agregarJugador(jugador16)



    // Anoto jugadores
    partido.anotarJugador(jugador1)
    partido.anotarJugador(jugador2)
    partido.anotarJugador(jugador3)
    partido.anotarJugador(jugador4)
    partido.anotarJugador(jugador5)
    partido.anotarJugador(jugador6)
    partido.anotarJugador(jugador7)
    partido.anotarJugador(jugador8)


    when:'Faltan jugadores'
    // Jugador 1
    Jugador jugadorPosible1 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible1.invitar(new Invitacion(partido, jugadorPosible1))
    jugadorPosible1.invitacionesPendientes.get(0).negarInvitacion()

    // Jugador 2
    Jugador jugadorPosible2 = ubicador.buscarJugadorCercano(establecimiento, partido)
    jugadorPosible2.invitar(new Invitacion(partido, jugadorPosible2))
    jugadorPosible2.invitacionesPendientes.get(0).negarInvitacion()

    // Como no acepto nadie, doy de baja la reserva
    partido.estado = EstadosPartido.CANCELADO

    then:'No quedan anotados'
    partido.jugadoresAnotados.contains(jugadorPosible1) == false
    partido.jugadoresAnotados.contains(jugadorPosible2) == false

    then:'Cancelo reserva'
    partido.estado == EstadosPartido.CANCELADO

  }



}
