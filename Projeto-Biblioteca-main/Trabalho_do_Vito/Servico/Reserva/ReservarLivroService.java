package Servico.Reserva;

import java.time.LocalDate;
import java.util.List;
import table.Reserva;

public class ReservarLivroService {

    private List<Reserva> reservas;

    public ReservarLivroService(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void executar(Reserva reserva) {

        if (reserva == null) {
            System.out.println("Reserva inválida!");
            return;
        }

        reserva.setDataReserva(LocalDate.now());
        reserva.setStatus("RESERVADO");

        reservas.add(reserva);

        System.out.println("Reserva realizada com sucesso!");
    }
}