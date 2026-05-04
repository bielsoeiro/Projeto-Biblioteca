package Servico.Catalogo;

import java.util.List;
import table.Livro;

public class CadastrarLivroService {

    private List<Livro> livros; // lista onde os livros ficam armazenados

    public CadastrarLivroService(List<Livro> livros) {
        this.livros = livros;
    }

    public void executar(Livro livro) {

        // validação simples
        if (livro == null) {
            System.out.println("Livro inválido!");
            return;
        }

        livros.add(livro); // adiciona na lista
        System.out.println("Livro cadastrado com sucesso!");
    }
}