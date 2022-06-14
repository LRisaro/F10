package f10

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import spock.lang.Specification

@Integration
@Rollback
class US8AltaDeUnJugadorAUnPartidoComoSuplenteSpec extends Specification {

    def setup() {
        // jugadores
        // Jugador jugador1 = new Direccion(nombre: "jugador1", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador2 = new Direccion(nombre: "jugador2", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador3 = new Direccion(nombre: "jugador3", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador4 = new Direccion(nombre: "jugador4", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador5 = new Direccion(nombre: "jugador5", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador6 = new Direccion(nombre: "jugador6", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador7 = new Direccion(nombre: "jugador7", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador8 = new Direccion(nombre: "jugador8", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador9 = new Direccion(nombre: "jugador9", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());
        // Jugador jugador10 = new Direccion(nombre: "jugador10", edad: 18, email: "asd@asd.com", whatsapp: :'123456789', reputacion: new  Reputacion());

        // grupo de amigos
        // un partido con jugadores
        // dar de baja a un jugador
        // subir a uno de los suplentes
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }
}
