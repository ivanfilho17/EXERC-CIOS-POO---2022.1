package br.ufpb.sistemaeleitoral;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEleitoralAddCadidatoController implements ActionListener {
    
    private SistemaEleitoralInterface sistemaEleitoral;
    private JFrame janelaPrincipal;

    public SistemaEleitoralAddCadidatoController(SistemaEleitoralMap sistema, JFrame janela) {
        this.sistemaEleitoral = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeCandidato = JOptionPane.showInputDialog(janelaPrincipal, "QUAL O NOME DO CANDIDATO?");
        int numero = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "QUAL O NUMERO DO CANDIDATO " + nomeCandidato + "?"));
        Partido partido = Partido.valueOf(JOptionPane.showInputDialog(janelaPrincipal, "QUAL O PARTIDO DO CANDIDATO DE NOME " +nomeCandidato + " E DE NÚMERO " + numero + "?"));
        boolean cadastrou = sistemaEleitoral.cadastraCandidato(nomeCandidato, numero, partido);
        if(cadastrou) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Candidato Cadastrado com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Candidato não foi cadastrado! \nVerifique se já existe.");
        }
    }

}
