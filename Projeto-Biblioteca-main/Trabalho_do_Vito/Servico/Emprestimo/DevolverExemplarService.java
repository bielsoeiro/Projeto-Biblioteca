package Servico.Emprestimo;

import java.time.LocalDate;
import java.util.List;
import table.Emprestimo;
import table.Exemplar;

public class DevolverExemplarService {

    private List<Emprestimo> emprestimos;
    private List<Exemplar> exemplares;

    public DevolverExemplarService(List<Emprestimo> emprestimos, List<Exemplar> exemplares) {
        this.emprestimos = emprestimos;
        this.exemplares = exemplares;
    }

    public void executar(int exemplarId) {

        for (Emprestimo emp : emprestimos) {
            if (emp.getExemplarId() == exemplarId &&
                emp.getDataDevolucao() == null) {

                emp.setDataDevolucao(LocalDate.now());
                emp.setStatus("FINALIZADO");

                for (Exemplar ex : exemplares) {
                    if (ex.getId() == exemplarId) {
                        ex.setStatus("DISPONIVEL");
                        break;
                    }
                }

                System.out.println("Devolução realizada com sucesso!");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado!");
    }
}