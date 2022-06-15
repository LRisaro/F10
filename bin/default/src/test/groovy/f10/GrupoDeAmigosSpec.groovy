package f10

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class GrupoDeAmigosSpec extends Specification implements DomainUnitTest<GrupoDeAmigos> {

    def setup() {
    }

    def cleanup() {
    }

    void "CrearGrupoDeAmigos"() {
        Reputacion reputacion = new Reputacion(partidosAbandonados: 0, partidosJugados: 16);

        Jugador jugador1 = new Direccion(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);
        Jugador jugador2 = new Direccion(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: '123456789', reputacion: reputacion);

        def jugadores = [jugador1, jugador2];
        GrupoDeAmigos grupoDeAmigos = new GrupoDeAmigos(nombre: "SuipachaFC", jugadores: jugadores)

        expect:"fix me"
            grupoDeAmigos.nombre == "SuipachaFC";
            grupoDeAmigos.jugadores.size() == 2;
    }
}
