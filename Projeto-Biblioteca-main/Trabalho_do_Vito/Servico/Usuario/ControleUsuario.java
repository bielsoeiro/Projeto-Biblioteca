// bloquear e desbloquear usuario.

package Servico.Usuario;

import java.util.List;
import table.Usuario;

public class ControleUsuario {

    private List<Usuario> usuarios;

    public ControleUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // 🔒 Bloquear
    public void bloquear(int id) {

        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.setBloqueado(true);
                System.out.println("Usuário bloqueado!");
                return;
            }
        }

        System.out.println("Usuário não encontrado!");
    }

    // 🔓 Desbloquear
    public void desbloquear(int id) {

        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.setBloqueado(false);
                System.out.println("Usuário desbloqueado!");
                return;
            }
        }

        System.out.println("Usuário não encontrado!");
    }
}