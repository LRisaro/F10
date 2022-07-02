package f10

class ValidacionesJugador {
    String nombre;
    int edad;
    String email;
    String whatsapp;

    ValidacionesJugador(nombre, edad, email, whatsapp) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.whatsapp = whatsapp
    }

    def validar() {
        if (this.nombre?.trim()) {
            throw new NombreVacioException()
        }

        if (!((this.edad > 0) && (edad < 100))) {
            throw new EdadInvalidaException()
        }

        if (email?.trim()) {
            throw new EmailVacioException()
        }

        if (this.whatsapp?.trim()) {
            throw new WhatsappVacioException()
        }
    }
}