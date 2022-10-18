package br.ufpb.sistemaeleitoral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEleitoralObterDadosController implements ActionListener {

    private SistemaEleitoralInterface sistemaEleitoral;
    private JFrame janelaPrincipal;

    public SistemaEleitoralObterDadosController(SistemaEleitoralMap sistema, JFrame janela) {
        this.sistemaEleitoral = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = JOptionPane.showInputDialog(janelaPrincipal, "QUAL O NOME DO CANDIDATO QUE DESEJA OBTER OS DADOS?");
            JOptionPane.showMessageDialog(janelaPrincipal, sistemaEleitoral.obterDadosDoCandidato(nome));


        } catch (CandidatoInexistenteException e1) {
            JOptionPane.showMessageDialog(janelaPrincipal, e1);

        }

    }
}