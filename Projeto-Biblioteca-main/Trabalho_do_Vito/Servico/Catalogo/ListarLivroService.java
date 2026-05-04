package Servico.Catalogo;

import java.util.List;
import table.Livro;

public class ListarLivroService {

    private List<Livro> livros;

    public ListarLivroService(List<Livro> livros) {
        this.livros = livros;
    }

    public void executar() {

        // verifica se tem livros
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        // percorre a lista e mostra os dados
        for (Livro l : livros) {
            System.out.println(
                "Título: " + l.getTitulo() +
                " | Autor: " + l.getAutores() +
                " | Categoria: " + l.getCategorias() +
                " | Ano: " + l.getAno()
            );
        }
    }
}