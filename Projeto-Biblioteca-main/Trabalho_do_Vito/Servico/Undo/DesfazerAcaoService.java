package Servico.Undo;

import java.util.Stack;

public class DesfazerAcaoService {

    private Stack<String> undo;
    private Stack<String> redo;

    public DesfazerAcaoService(Stack<String> undo, Stack<String> redo) {
        this.undo = undo;
        this.redo = redo;
    }

    public void executar() {

        if (undo.isEmpty()) {
            System.out.println("Nada para desfazer!");
            return;
        }

        String acao = undo.pop();
        redo.push(acao);

        System.out.println("Desfeito: " + acao);
    }
}