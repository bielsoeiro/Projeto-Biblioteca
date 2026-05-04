package Servico.Catalogo;

import java.util.List;
import table.Livro;

public class BuscarLivroService {

    private List<Livro> livros;

    public BuscarLivroService(List<Livro> livros) {
        this.livros = livros;
    }

    public Livro executar(String titulo) {

        // procura o livro pelo título
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l; // retorna se encontrar
            }
        }

        System.out.println("Livro não encontrado!");
        return null;
    }
}