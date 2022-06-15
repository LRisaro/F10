package f10

class SolicitudDeAmistad {

    static constraints = {
    }

    Jugador jugadorDestino
    GrupoDeAmigos grupoSolicitante
    EstadosSolicitud estado

    SolicitudDeAmistad(jugadorDestino, grupoSolicitante) {
        this.jugadorDestino = jugadorDestino;
        this.grupoSolicitante = grupoSolicitante;
        this.estado = EstadosSolicitud.PENDIENTE;
    }

    def aceptarSolicitud(){
        this.jugadorDestino.agregarGrupoDeAmigos(this.grupoSolicitante)
        this.grupoSolicitante.agregarAmigo(this.jugadorDestino)
        this.estado = EstadosSolicitud.ACEPTADA
    }

    def rechazarSolicitud(){
        this.estado = EstadosSolicitud.RECHAZADA
    }
}
