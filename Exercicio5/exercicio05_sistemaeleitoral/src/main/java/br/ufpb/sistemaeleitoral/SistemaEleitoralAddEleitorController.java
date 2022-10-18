package br.ufpb.sistemaeleitoral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEleitoralAddEleitorController implements ActionListener {
    
    private SistemaEleitoralInterface sistemaEleitoral;
    private JFrame janelaPrincipal;

    public SistemaEleitoralAddEleitorController(SistemaEleitoralMap sistema, JFrame janela) {
        this.sistemaEleitoral = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeEleitor = JOptionPane.showInputDialog(janelaPrincipal, "QUAL O NOME DO ELEITOR?");
        String titulo = JOptionPane.showInputDialog(janelaPrincipal, "QUAL O TÍTULO DO ELEITOR DE NOME " + nomeEleitor + " ?");
        boolean cadastrou = sistemaEleitoral.cadastraEleitor(nomeEleitor, titulo);
        if(cadastrou) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Eleitor Cadastrado com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "ELeitor não foi cadastrado! \nVerifique se já existe.");
        }
    }
}
