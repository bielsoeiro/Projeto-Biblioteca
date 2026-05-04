
package Servico.Relatorio;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import table.Emprestimo;

public class UsuariosComMaisAtrasosService {

    private List<Emprestimo> emprestimos;

    public UsuariosComMaisAtrasosService(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void executar() {

        Map<Integer, Integer> atrasos = new HashMap<>();

        for (Emprestimo e : emprestimos) {

            LocalDate dataFinal = (e.getDataDevolucao() != null)
                    ? e.getDataDevolucao()
                    : LocalDate.now();

            if (dataFinal.isAfter(e.getDataPrevista())) {

                int userId = e.getUsuarioId();
                atrasos.put(userId, atrasos.getOrDefault(userId, 0) + 1);
            }
        }

        System.out.println("\n--- USUÁRIOS COM MAIS ATRASOS ---");

        for (Map.Entry<Integer, Integer> entry : atrasos.entrySet()) {
            System.out.println("Usuário " + entry.getKey() +
                    " | Atrasos: " + entry.getValue());
        }
    }
}