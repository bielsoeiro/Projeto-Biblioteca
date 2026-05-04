package Servico.Relatorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import table.Emprestimo;

public class EstatisticasMensaisService {

    private List<Emprestimo> emprestimos;

    public EstatisticasMensaisService(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void executar() {

        Map<Integer, Integer> porMes = new HashMap<>();

        for (Emprestimo e : emprestimos) {

            if (e.getDataEmprestimo() != null) {
                int mes = e.getDataEmprestimo().getMonthValue();

                porMes.put(mes, porMes.getOrDefault(mes, 0) + 1);
            }
        }

        System.out.println("\n--- ESTATÍSTICAS MENSAIS ---");

        for (Map.Entry<Integer, Integer> entry : porMes.entrySet()) {
            System.out.println("Mês " + entry.getKey() +
                    " | Empréstimos: " + entry.getValue());
        }
    }
}