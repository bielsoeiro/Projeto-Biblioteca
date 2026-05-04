package table;

public class Exemplar {
    private int id;
    private String isbn;
    private String status;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }  

    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Exemplar(int id, String isbn, String status){
        this.id = id;
        this.isbn = isbn;
        this.status = status;
       
    }
}
