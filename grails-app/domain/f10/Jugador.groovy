package f10

class Jugador {

    static constraints = {
    }

    String nombre;
    int edad;
    String email;
    String whatsapp;
    Reputacion reputacion;
    def gruposDeAmigos = [];

    Jugador(nombre, edad, email, whatsapp) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.whatsapp = whatsapp;
    }

    def agregarGrupoDeAmigos(grupoDeAmigos) {
        gruposDeAmigos.add(grupoDeAmigos);
    }
}
