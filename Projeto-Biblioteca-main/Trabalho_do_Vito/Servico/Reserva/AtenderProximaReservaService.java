package Servico.Reserva;

import java.util.List;
import table.Reserva;

public class AtenderProximaReservaService {

    private List<Reserva> reservas;

    public AtenderProximaReservaService(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void executar(String isbn) {

        for (Reserva r : reservas) {
            if (r.getIsbnLivro().equalsIgnoreCase(isbn)) {

                reservas.remove(r);

                System.out.println("Reserva atendida para ISBN: " + isbn);
                return;
            }
        }

        System.out.println("Nenhuma reserva encontrada para este livro.");
    }
}