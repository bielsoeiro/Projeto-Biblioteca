package Servico.Emprestimo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import table.Emprestimo;

public class CalcularMultaService {

    public double executar(Emprestimo emp) {

        if (emp == null) {
            System.out.println("Empréstimo inválido!");
            return 0;
        }

        // Se ainda não devolveu, calcula até hoje
        LocalDate dataFinal = emp.getDataDevolucao() != null
                ? emp.getDataDevolucao()
                : LocalDate.now();

        long diasAtraso = ChronoUnit.DAYS.between(
                emp.getDataPrevista(),
                dataFinal
        );

        if (diasAtraso > 0) {
            double multa = diasAtraso * 2.0; // R$2 por dia
            return multa;
        }

        return 0;
    }
}