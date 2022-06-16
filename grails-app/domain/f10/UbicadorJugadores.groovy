package f10

class UbicadorJugadores {

    static constraints = {
    }

    def listaJugadores = [];

    UbicadorJugadores() {

    }

    def agregarJugador(jugadores) {
        listaJugadores.add(jugadores);
    }

    def buscarJugadorCercano(establecimiento, partido){
       def jugadoresCercanos = []

       this.listaJugadores.each { val ->
            if (    (establecimiento.ubicacion.get(0) - 20 < val.ubicacion.get(0)) && ( val.ubicacion.get(0) < establecimiento.ubicacion.get(0) + 20 ) &&
                    (establecimiento.ubicacion.get(1) - 20 < val.ubicacion.get(1)) && ( val.ubicacion.get(1) < establecimiento.ubicacion.get(1) + 20 ) &&
                    (!partido.jugadoresAnotados.contains(val))
            ) {
                    jugadoresCercanos.add(val)
            }
       }

       return jugadoresCercanos
    }
}
