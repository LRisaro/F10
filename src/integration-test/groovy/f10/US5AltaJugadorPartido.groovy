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
    Partido partido = new Partido()

    when:'Me anoto'
    partido.anotarJugador(jugador)

    then:'Quedo como jugador anotado en el partido'
    partido.jugadoresAnotados.contains(jugador) == True
  }

}
