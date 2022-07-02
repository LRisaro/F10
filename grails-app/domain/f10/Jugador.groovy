package f10

class Jugador {

    static constraints = {
    }

    String nombre;
    int edad;
    String email;
    String whatsapp;
    Reputacion reputacion = new Reputacion()
    def ubicacion = new Tuple(0,0)
    def gruposDeAmigos = [];
    def invitacionesPendientes = [];

    Jugador(nombre, edad, email, whatsapp, ubicacion) {
        new ValidacionesJugador(nombre, edad, email, whatsapp)
            .validar();

        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.whatsapp = whatsapp;
        this.ubicacion = ubicacion;
    }

    def agregarGrupoDeAmigos(grupoDeAmigos) {
        gruposDeAmigos.add(grupoDeAmigos);
    }

    def penalizar(){
        reputacion.partidosAbandonados +=  1
    }

    def invitar(invitacion) {
        this.invitacionesPendientes.add(invitacion)
    }
}
