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
        String num = JOptionPane.showInputDialog(janelaPrincipal, "QUAL O NÚMERO DO CANDIDATO QUE DESEJA CONTAR OS VOTOS?");
        int numero = Integer.parseInt(num);
        if(num == null || numero <= 0 ) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Erro ao contar votos \nNão foi informado o numero do candidato válido");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Quantidade de Votos do Candidato de numero " + numero + ": " + sistemaEleitoral.contarVotosParaCandidato(numero));
        }
    }
}