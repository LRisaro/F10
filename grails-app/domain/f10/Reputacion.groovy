package f10

class Reputacion {

    static constraints = {
    }

    int partidosAbandonados
    int partidosJugados

    Reputacion() {
        partidosAbandonados = 0
        partidosJugados = 0
    }

    def tieneBuenaReputacion() {
        //TODO  La buena o mala reputacion se va a basar en el porcentaje de partidos jugados
        if((partidosJugados + partidosAbandonados) == 0 || (partidosJugados > partidosAbandonados))
        {
            return true;
        }
        return false;
    }

}
