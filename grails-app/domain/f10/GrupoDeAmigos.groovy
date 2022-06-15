package f10

class GrupoDeAmigos {

    static constraints = {
    }

    String nombre;
    def jugadores = [];

    GrupoDeAmigos(nombre) {
        this.nombre = nombre;
    }

    def agregarAmigo(jugador) {
        jugadores.add(jugador)
    }
}
