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
        if (partidosAbandonados == 0) {
            return True
        }

        return False
    }

}
