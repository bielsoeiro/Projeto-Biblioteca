package Servico.Reserva;

import java.util.List;
import table.Reserva;

public class CancelarReservaService {

    private List<Reserva> reservas;

    public CancelarReservaService(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void executar(int id) {

        Reserva remover = null;

        for (Reserva r : reservas) {
            if (r.getId() == id) {
                remover = r;
                break;
            }
        }

        if (remover != null) {
            reservas.remove(remover);
            System.out.println("Reserva cancelada com sucesso!");
        } else {
            System.out.println("Reserva não encontrada!");
        }
    }
}