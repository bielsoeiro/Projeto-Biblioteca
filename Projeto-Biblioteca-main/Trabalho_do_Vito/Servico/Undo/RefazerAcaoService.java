package Servico.Undo;

import java.util.Stack;

public class RefazerAcaoService {

    private Stack<String> undo;
    private Stack<String> redo;

    public RefazerAcaoService(Stack<String> undo, Stack<String> redo) {
        this.undo = undo;
        this.redo = redo;
    }

    public void executar() {

        if (redo.isEmpty()) {
            System.out.println("Nada para refazer!");
            return;
        }

        String acao = redo.pop();
        undo.push(acao);

        System.out.println("Refeito: " + acao);
    }
}