package f10

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import spock.lang.Specification

@Integration
class US5AltaJugadorPartido extends Specification {

  def setup() {
  }

  def cleanup() {
  }

  void AltaJugadorSinPenalizacionesAPartido() {
    given:'Como jugador de un grupo de amigos quiero anotarme para jugar un partido para participar del mismo.'
    GrupoDeAmigos grupo = new GrupoDeAmigos(nombre:'F10')
    Jugador jugador = new Jugador()
    grupo.agregarAmigo(jugador)
    Cancha cancha = new Cancha(numero: 5)
    Partido partido = new Casual(new Date(), cancha, jugador)

    when:'Me anoto y confirmo'
    partido.anotarJugador(jugador)
    partido.confirmarJugador(jugador)

    then:'Quedo como jugador anotado y confirmado en el partido'
    partido.jugadoresAnotados.contains(jugador) == true
    partido.jugadoresConfirmados.contains(jugador) == true
  }

  void AltaJugadorSinPenalizacionesAPartidoSinConfirmar() {
    given:'Como jugador de un grupo de amigos quiero anotarme para jugar un partido para participar del mismo.'
    GrupoDeAmigos grupo = new GrupoDeAmigos(nombre:'F10')
    Jugador jugador = new Jugador()
    grupo.agregarAmigo(jugador)
    Cancha cancha = new Cancha(numero: 5)
    Partido partido = new Casual(new Date(), cancha, jugador)

    when:'Me anoto'
    partido.anotarJugador(jugador)

    then:'Quedo como jugador anotado en el partido'
    partido.jugadoresAnotados.contains(jugador) == true

    when:'No confirmo'
    then:'Quedo penalizado'
    if (!partido.jugadoresConfirmados.contains(jugador)) {
      jugador.penalizar()
    }

    jugador.reputacion.tieneBuenaReputacion() == false
  }

  void AltaJugadorConPenalizacionesAPartido() {
    given:'Como jugador, con penalizaciones, de un grupo de amigos quiero anotarme para jugar un partido para participar del mismo.'
    GrupoDeAmigos grupo = new GrupoDeAmigos(nombre:'F10')
    Jugador jugador = new Jugador()
    jugador.penalizar()
    grupo.agregarAmigo(jugador)
    Cancha cancha = new Cancha(numero: 5)
    Partido partido = new Casual(new Date(), cancha, jugador)

    when:'Me anoto'
    partido.anotarJugador(jugador)

    then:'No quedo como anotado ni confirmado'
    partido.jugadoresAnotados.contains(jugador) == false
    partido.jugadoresConfirmados.contains(jugador) == false
  }

}
