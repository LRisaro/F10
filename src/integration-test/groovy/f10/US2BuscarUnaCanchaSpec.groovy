package f10

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import spock.lang.Specification

@Integration
@Rollback
class US2BuscarUnaCanchaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "BuscarCanchasDisponiblesEnMiLocalidad"() {

        Cancha cancha1 = new Cancha(numero: 1);
        Cancha cancha2 = new Cancha(numero: 2);
        Cancha cancha3 = new Cancha(numero: 3);
        Cancha cancha4 = new Cancha(numero: 4);
        Cancha cancha5 = new Cancha(numero: 5);
        Cancha cancha6 = new Cancha(numero: 6);

        Direccion direccion1 = new Direccion(localidad: "localidad1", calle: "Suipacha", altura: 245);
        Direccion direccion2 = new Direccion(localidad: "localidad2", calle: "Suipacha", altura: 288);

        Establecimiento establecimiento1 = new Establecimiento(nombre: "Establecimiento1", telefono: "1234567860", direccion: direccion1);
        Establecimiento establecimiento2 = new Establecimiento(nombre: "Establecimiento2", telefono: "1234567860", direccion: direccion2);

        establecimiento1.canchasDisponibles.add(cancha1);
        establecimiento1.canchasDisponibles.add(cancha2);
        establecimiento1.canchasDisponibles.add(cancha3);

        establecimiento2.canchasDisponibles.add(cancha4);
        establecimiento2.canchasDisponibles.add(cancha5);
        establecimiento2.canchasDisponibles.add(cancha6);
    
        AdministradorDeEstablecimientos administradorDeEstablecimientos = new AdministradorDeEstablecimientos();
        administradorDeEstablecimientos.establecimientos.add(establecimiento1);
        administradorDeEstablecimientos.establecimientos.add(establecimiento2);

        given:"Como jugador de un grupo de amigos quiero realizar una búsqueda de predios donde poder reservar una cancha."   
        
        def establecimientosConCanchasDisponibles = administradorDeEstablecimientos.obtenerEstablecimientosConCanchasDisponibles("localidad1").sort{it.establecimiento.direccion.altura};

        Establecimiento establecimientoElegido = establecimientosConCanchasDisponibles.first();

        when:"Voy a elegir una cancha que me quede comoda."

        //Elijo la cancha 2 para reservar
        establecimientoElegido.reservarCancha(2);

        then:"Seleccione un establecimiento y reserve una cancha. Voy a asegurarme que sea el establecimiento correcto y la cancha correcta."

        establecimientoElegido.nombre == "Establecimiento1";
        establecimientoElegido.canchasDisponibles.contains(cancha2) == false;
        establecimientoElegido.canchasReservadas.contains(cancha2) == true; 
    }
}
