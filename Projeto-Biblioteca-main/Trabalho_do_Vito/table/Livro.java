package table;
import java.util.List;
import table.Exemplar;
import table.Autor;
import table.Categoria;
public class Livro  {
    private String titulo;
    private String autores;
    private String categorias;
    private String ano;
    private String palavraChave;
    private List<Exemplar> exemplares;
    private List<Autor> autoresList;
    private List<Categoria> categoriasList;

    private List<Autor> getAutoresList() {
        return autoresList;
    }
    private void setAutoresList(List<Autor> autoresList) {
        this.autoresList = autoresList;
    }

    private List<Categoria> getCategoriasList() {
        return categoriasList;
    }
    private void setCategoriasList(List<Categoria> categoriasList) {
        this.categoriasList = categoriasList;
    }

    public List<Exemplar> getexemplares() {
        return exemplares;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutores() {
        return autores;
    }
    public void setAutores(String autores) {
        this.autores = autores;
    }
    public String getCategorias() {
        return categorias;
    }
    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getPalavraChave() {
        return palavraChave;
    }
    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public Livro( String titulo, String autores, String categorias, String ano, String palavraChave) {
        this.titulo = titulo;
        this.autores = autores;
        this.categorias = categorias;
        this.ano = ano;
        this.palavraChave = palavraChave;
    }  

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void mostrarExemplares(Exemplar exemplar){
        for(Exemplar ex : exemplares){
            System.out.println("ID: " + ex.getId() + " | ISBN: " + ex.getIsbn() + " | Status: " + ex.getStatus());
        }
    }

}
