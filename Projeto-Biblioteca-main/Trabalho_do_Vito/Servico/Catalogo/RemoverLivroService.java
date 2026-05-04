package Servico.Catalogo;

import java.util.List;
import table.Livro;

public class RemoverLivroService {

    private List<Livro> livros;

    public RemoverLivroService(List<Livro> livros) {
        this.livros = livros;
    }

    public void executar(String titulo) {

        if (titulo == null || titulo.isEmpty()) {
            System.out.println("Título inválido!");
            return;
        }

        Livro livroRemover = null;

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                livroRemover = l;
                break;
            }
        }

        if (livroRemover != null) {
            livros.remove(livroRemover);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }
}
