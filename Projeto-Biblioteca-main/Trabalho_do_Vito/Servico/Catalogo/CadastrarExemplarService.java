package Servico.Catalogo; 

import java.util.List;
import table.Exemplar;

public class CadastrarExemplarService {

    private List<Exemplar> exemplares;

    public CadastrarExemplarService(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

   //metodo de cadastro

    public void executar(Exemplar exemplar) {

  
        if (exemplar == null) {
            System.out.println("Exemplar inválido!");
            return; 
        }

        // Se o status não for definido ele vai ficar como disponivel
        if (exemplar.getStatus() == null) {
            exemplar.setStatus("DISPONIVEL");
        }

        // Adiciona o exemplar na lista
        exemplares.add(exemplar);

        System.out.println("Exemplar cadastrado com sucesso!");
    }
}