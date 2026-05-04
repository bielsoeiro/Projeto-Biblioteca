package Servico.Emprestimo;

import java.time.LocalDate;
import java.util.List;
import table.Emprestimo;
import table.Exemplar;

public class EmprestarExemplarService {

    private List<Emprestimo> emprestimos;
    private List<Exemplar> exemplares;

    public EmprestarExemplarService(List<Emprestimo> emprestimos, List<Exemplar> exemplares) {
        this.emprestimos = emprestimos;
        this.exemplares = exemplares;
    }

    public void executar(Emprestimo emp) {

        if (emp == null) {
            System.out.println("Empréstimo inválido!");
            return;
        }

        for (Exemplar ex : exemplares) {
            if (ex.getId() == emp.getExemplarId() &&
                ex.getStatus().equalsIgnoreCase("DISPONIVEL")) {

                ex.setStatus("EMPRESTADO");

                emp.setDataEmprestimo(LocalDate.now());
                emp.setDataPrevista(LocalDate.now().plusDays(7));
                emp.setStatus("ATIVO");

                emprestimos.add(emp);

                System.out.println("Empréstimo realizado com sucesso!");
                return;
            }
        }

        System.out.println("Exemplar não disponível!");
    }
}