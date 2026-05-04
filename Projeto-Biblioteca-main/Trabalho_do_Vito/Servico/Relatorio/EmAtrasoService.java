package Servico.Relatorio;

import java.time.LocalDate;
import java.util.List;

import table.Emprestimo;

public class EmAtrasoService {

    private List<Emprestimo> emprestimos;

    public EmAtrasoService(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void executar() {

        System.out.println("\n--- EM ATRASO ---");

        for (Emprestimo e : emprestimos) {
            if (e.getDataDevolucao() == null &&
                e.getDataPrevista().isBefore(LocalDate.now())) {

                System.out.println("Exemplar " + e.getExemplarId() +
                        " | Usuário " + e.getUsuarioId());
            }
        }
    }
}