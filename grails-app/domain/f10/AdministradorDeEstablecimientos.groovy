package f10

class AdministradorDeEstablecimientos {

    static constraints = {
    }

    def establecimientos = [];

    def obtenerEstablecimientosConCanchasDisponibles(localidad)
    {
        return establecimientos.findAll(establecimiento -> establecimiento.direccion.localidad == localidad && establecimiento.canchasDisponibles.size() > 0);
    }
}
