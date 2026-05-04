package Servico.Usuario;

import java.util.List;
import table.Usuario;

public class ListarUsuario {

    private List<Usuario> usuarios;

    public ListarUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void executar() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario u : usuarios) {
            System.out.println(
                "ID: " + u.getId() +
                " | Nome: " + u.getNome() +
                " | Tipo: " + u.getTipo() +
                " | Email: " + u.getEmail() +
                " | Bloqueado: " + (u.isBloqueado() ? "Sim" : "Não")
            );
        }
    }
}