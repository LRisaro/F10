package f10

class Establecimiento {

    static constraints = {
    }

    String nombre;
    String telefono;
    Direccion direccion;
    def ubicacion = new Tuple(0, 0)
    def canchasDisponibles = []
    def canchasReservadas = []

    Establecimiento(nombre, telefono, direccion, ubicacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
    }

    def reservarCancha(numeroDeCancha)
    {
        Cancha cancha = canchasDisponibles.find(cancha -> cancha.numero == numeroDeCancha);

        canchasDisponibles.remove(cancha);
        canchasReservadas.add(cancha);

        //Generar codigo de reserva y devolverlo para que lo tenga el usuario
        return cancha.numero;
    }
}
