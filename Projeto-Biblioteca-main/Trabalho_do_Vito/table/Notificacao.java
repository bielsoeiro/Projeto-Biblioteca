package table;

public class Notificacao {
    private int id;
    private int usuarioId;
    private String mensagem;
    private String dataNotificacao;
    private boolean lida;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuariold) {
        this.usuarioId = usuariold;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getDataNotificacao() {
        return dataNotificacao;
    }
    public void setDataNotificacao(String dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }
    public boolean isLida() {
        return lida;
    }
    public void setLida(boolean lida) {
        this.lida = lida;
    }

    
}
