package f10

abstract class Partido {

    static constraints = {
    }
    // Cuadno se crea un nuevo partido es necesario notificar al grupo de amigo del jugador que organiza el partido.

    def jugadoresAnotados = [];
    def jugadoresConfirmados = [];
    def jugadoresSuplentes = [];
    Date fecha;
    Cancha cancha;
    EstadosPartido estado;

    Partido(fecha, cancha) {
        this.fecha = fecha;
        this.cancha = cancha;
        this.estado = EstadosPartido.PENDIENTE;
    }

    def anotarJugador(jugador) {

        if(jugadoresAnotados.size() < 10)
        {
            jugadoresAnotados.add(jugador);
        }
        else 
        {
            anotarJugadorSuplente(jugador);            
        }

        // hay 10 jugadores anotados
        // notificacion al grupo
    }

    def confirmarJugador(jugador) {
        jugadoresConfirmados.add(jugador)
    }

    def anotarJugadorSuplente(jugador) {
        jugadoresSuplentes.add(jugador);

        // ordeno de menor a mayor porcentaje de partidos jugados (creo XD)
        jugadoresSuplentes.sort { (it.reputacion.partidosJugados * 100) / (it.reputacion.partidosJugados + it.reputacion.partidosAbandonados) }
    }

    def darDeBajaAJugador(jugador)
    {
        for(jugadorAnotado in jugadoresAnotados){
            // en el futuro cencano esta comparacion tiene que ser por algo mejor que el nombre (Hay gente que se llama igual)
            // por ejemplo por id
           if(jugadorAnotado.nombre == jugador.nombre){
                jugadoresAnotados.removeElement(jugadorAnotado)
           }
        }
        
        if(jugadoresSuplentes.size() > 0){
            jugadoresAnotados.push(jugadoresSuplentes.pop());
        }
    }
    
    def darDeBajaJugador(jugador){
        jugadoresConfirmados.remove(jugador)
        jugador.penalizar()
    }
}
