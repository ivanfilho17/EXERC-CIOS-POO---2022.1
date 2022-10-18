package br.ufpb.sistemaeleitoral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEleitoralContarVotosController implements ActionListener {

    private SistemaEleitoralInterface sistemaEleitoral;
    private JFrame janelaPrincipal;

    public SistemaEleitoralContarVotosController(SistemaEleitoralMap sistema, JFrame janela) {
        this.sistemaEleitoral = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "QUAL O NÚMERO DO CANDIDATO QUE DESEJA CONTAR OS VOTOS?"));
        JOptionPane.showMessageDialog(janelaPrincipal, sistemaEleitoral.contarVotosParaCandidato(numero));
    }
}