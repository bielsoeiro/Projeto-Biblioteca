package Teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Servico.Catalogo.*;
import Servico.Usuario.*;
import Servico.Emprestimo.*;
import Servico.Reserva.*;
import Servico.Relatorio.*;
import Servico.Undo.*;

import table.*;

public class Teste {

    public static void main(String[] args) {

        // ===============================
        // LISTAS
        // ===============================
        List<Livro> livros = new ArrayList<>();
        List<Exemplar> exemplares = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Emprestimo> emprestimos = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();

        // ===============================
        // PILHAS (UNDO/REDO)
        // ===============================
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();


        // ===============================
        // SERVICES
        // ===============================

        // LIVRO
        CadastrarLivroService cadastrarLivro = new CadastrarLivroService(livros);
        CadastrarExemplarService cadastrarExemplar = new CadastrarExemplarService(exemplares);
        ListarLivroService listarLivros = new ListarLivroService(livros);
        BuscarLivroService buscar = new BuscarLivroService(livros);
        RemoverLivroService remover = new RemoverLivroService(livros);

        // USUARIO
        CadastrarUsuarioService cadastrarUsuario = new CadastrarUsuarioService(usuarios);
        ControleUsuario controle = new ControleUsuario(usuarios);
        ListarUsuario listarUsuarios = new ListarUsuario(usuarios);

        // EMPRESTIMO
        EmprestarExemplarService emprestarService = new EmprestarExemplarService(emprestimos, exemplares);
        DevolverExemplarService devolverService = new DevolverExemplarService(emprestimos, exemplares);
        RenovarEmprestimoService renovarService = new RenovarEmprestimoService(emprestimos);
        CalcularMultaService multaService = new CalcularMultaService();

        // RESERVA
        ReservarLivroService reservarService = new ReservarLivroService(reservas);
        CancelarReservaService cancelarService = new CancelarReservaService(reservas);
        AtenderProximaReservaService atenderService = new AtenderProximaReservaService(reservas);

        // RELATORIO
        TopMaisEmprestadosService top = new TopMaisEmprestadosService(emprestimos);
        EmAtrasoService atraso = new EmAtrasoService(emprestimos);
        UsuariosComMaisAtrasosService usuariosAtraso = new UsuariosComMaisAtrasosService(emprestimos);
        EstatisticasMensaisService estatisticas = new EstatisticasMensaisService(emprestimos);

        // UNDO/REDO
        RegistrarAcaoService registrar = new RegistrarAcaoService(undo, redo);
        DesfazerAcaoService desfazer = new DesfazerAcaoService(undo, redo);
        RefazerAcaoService refazer = new RefazerAcaoService(undo, redo);


        // ===============================
        // LIVROS
        // ===============================
        cadastrarLivro.executar(new Livro("Harry Potter", "JK Rowling", "Fantasia", "1997", "Magia"));
        registrar.executar("Cadastrar livro Harry Potter");

        cadastrarLivro.executar(new Livro("Dom Casmurro", "Machado", "Romance", "1899", "Drama"));
        registrar.executar("Cadastrar livro Dom Casmurro");

        Exemplar ex1 = new Exemplar(1, "123456", "DISPONIVEL");
        cadastrarExemplar.executar(ex1);

        System.out.println("\n--- LIVROS ---");
        listarLivros.executar();


        // ===============================
        // BUSCAR / REMOVER
        // ===============================
        Livro encontrado = buscar.executar("Dom Casmurro");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getTitulo());
        }

        remover.executar("Harry Potter");
        registrar.executar("Remover livro Harry Potter");


        // ===============================
        // USUÁRIOS
        // ===============================
        Usuario u1 = new Usuario();
        u1.setId(1);
        u1.setNome("João");
        u1.setTipo("ALUNO");
        u1.setEmail("joao@email.com");

        Usuario u2 = new Usuario();
        u2.setId(2);
        u2.setNome("Maria");
        u2.setTipo("PROFESSOR");
        u2.setEmail("maria@email.com");

        cadastrarUsuario.executar(u1);
        cadastrarUsuario.executar(u2);

        System.out.println("\n--- USUÁRIOS ---");
        listarUsuarios.executar();


        controle.bloquear(1);
        registrar.executar("Bloquear usuário João");

        controle.desbloquear(1);
        registrar.executar("Desbloquear usuário João");


        // ===============================
        // EMPRÉSTIMO
        // ===============================
        Emprestimo emp1 = new Emprestimo();
        emp1.setId(1);
        emp1.setUsuarioId(1);
        emp1.setExemplarId(1);

        System.out.println("\n--- EMPRÉSTIMO ---");
        emprestarService.executar(emp1);
        registrar.executar("Empréstimo realizado");


        // FORÇAR ATRASO
        emp1.setDataPrevista(emp1.getDataPrevista().minusDays(5));

        renovarService.executar(1);
        registrar.executar("Renovar empréstimo");

        devolverService.executar(1);
        registrar.executar("Devolver livro");


        // ===============================
        // MULTA
        // ===============================
        System.out.println("\n--- MULTA ---");
        double multa = multaService.executar(emp1);
        System.out.println("Multa: R$ " + multa);


        // ===============================
        // RESERVA
        // ===============================
        Reserva r1 = new Reserva();
        r1.setId(1);
        r1.setUsuarioId(2);
        r1.setIsbnLivro("123456");

        reservarService.executar(r1);
        registrar.executar("Reserva realizada");

        atenderService.executar("123456");
        registrar.executar("Reserva atendida");

        cancelarService.executar(1);
        registrar.executar("Reserva cancelada");


        // ===============================
        // RELATÓRIOS
        // ===============================
        top.executar();
        atraso.executar();
        usuariosAtraso.executar();
        estatisticas.executar();


        // ===============================
        // UNDO / REDO
        // ===============================
        System.out.println("\n--- UNDO/REDO ---");

        desfazer.executar();
        desfazer.executar();

        refazer.executar();


        // ===============================
        // FINAL
        // ===============================
        System.out.println("\nSistema COMPLETO funcionando!");
    }
}