package br.ufpb.sistemaeleitoral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEleitoralVotarController implements ActionListener {

    private SistemaEleitoralInterface sistemaEleitoral;
    private JFrame janelaPrincipal;

    public SistemaEleitoralVotarController(SistemaEleitoralMap sistema, JFrame janela) {
        this.sistemaEleitoral = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String numeroTitulo = JOptionPane.showInputDialog(janelaPrincipal, "QUAL O SEU TÍTULO?");
            int numeroAVotar = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "QUAL O NÚMERO DO CANDIDATO QUE DESEJA VOTAR?"));
            sistemaEleitoral.votar(numeroTitulo, numeroAVotar);
            JOptionPane.showMessageDialog(janelaPrincipal, "Votação com Sucesso!");

        } catch (TituloInexistenteException e1) {
            JOptionPane.showMessageDialog(janelaPrincipal, e1);

        }

    }
}
