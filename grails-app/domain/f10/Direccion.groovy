package f10

class Direccion {

    static constraints = {
    }

    String calle;
    int altura;
    String localidad;

    Direccion(localidad, calle, altura) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
    }
}
