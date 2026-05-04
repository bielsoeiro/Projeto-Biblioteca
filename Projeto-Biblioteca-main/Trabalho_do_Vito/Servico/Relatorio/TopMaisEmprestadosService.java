package Servico.Relatorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import table.Emprestimo;

public class TopMaisEmprestadosService {

    private List<Emprestimo> emprestimos;

    public TopMaisEmprestadosService(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void executar() {

        Map<Integer, Integer> contador = new HashMap<>();

        for (Emprestimo e : emprestimos) {
            int exemplarId = e.getExemplarId();
            contador.put(exemplarId, contador.getOrDefault(exemplarId, 0) + 1);
        }

        System.out.println("\n--- TOP MAIS EMPRESTADOS ---");

        for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
            System.out.println("Exemplar " + entry.getKey() +
                    " | Total empréstimos: " + entry.getValue());
        }
    }
}