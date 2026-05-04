package Servico.Undo;

import java.util.Stack;

public class RegistrarAcaoService {

    private Stack<String> undo;
    private Stack<String> redo;

    public RegistrarAcaoService(Stack<String> undo, Stack<String> redo) {
        this.undo = undo;
        this.redo = redo;
    }

    public void executar(String acao) {

        if (acao == null || acao.isEmpty()) {
            System.out.println("Ação inválida!");
            return;
        }

        undo.push(acao);
        redo.clear();

        System.out.println("Ação registrada: " + acao);
    }
}