package Servico.Emprestimo;

import java.time.LocalDate;
import java.util.List;
import table.Emprestimo;

public class RenovarEmprestimoService {

    private List<Emprestimo> emprestimos;

    public RenovarEmprestimoService(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void executar(int exemplarId) {

        for (Emprestimo emp : emprestimos) {
            if (emp.getExemplarId() == exemplarId &&
                emp.getDataDevolucao() == null) {

                emp.setDataPrevista(emp.getDataPrevista().plusDays(7));

                System.out.println("Empréstimo renovado por mais 7 dias!");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado ou já finalizado!");
    }
}