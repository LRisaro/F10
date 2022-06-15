package f10

class Establecimiento {

    static constraints = {
    }

    String nombre;
    String telefono;
    Direccion direccion;
    def canchas = []

    Establecimiento(nombre, telefono, direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
