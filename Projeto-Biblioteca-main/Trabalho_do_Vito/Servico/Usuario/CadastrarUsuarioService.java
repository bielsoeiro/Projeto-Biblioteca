package Servico.Usuario;

import java.util.List;

import table.Usuario;

public class CadastrarUsuarioService {

    private List<Usuario> usuarios;

    public CadastrarUsuarioService(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void executar(Usuario usuario) {

        if (usuario == null) {
            System.out.println("Usuário inválido!");
            return;
        }

        // evitar duplicado por id
        for (Usuario u : usuarios) {
            if (u.getId() == usuario.getId()) {
                System.out.println("Usuário já cadastrado!");
                return;
            }
        }

        usuario.setBloqueado(false); // padrão

        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
}