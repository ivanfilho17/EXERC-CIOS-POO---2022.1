package br.ufpb.sistemaeleitoral;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SistemaEleitoralGUI extends JFrame {

    JLabel linha1, linha2, linha3;
    ImageIcon urnaEletronicaImg = new ImageIcon("./src/main/java/br/ufpb/sistemaeleitoral/imgs/urna5.jpg ");
    ImageIcon cadastroCandidatoImg = new ImageIcon("./src/main/java/br/ufpb/sistemaeleitoral/imgs/adicionarImg.png");
    ImageIcon cadastroEleitorImg = new ImageIcon("./src/main/java/br/ufpb/sistemaeleitoral/imgs/adicionarImg.png");
    ImageIcon votarImg = new ImageIcon("./src/main/java/br/ufpb/sistemaeleitoral/imgs/votarImg.png");
    ImageIcon obterDadosDoCandidatoImg = new ImageIcon("./src/main/java/br/ufpb/sistemaeleitoral/imgs/obterDadosImg.png");
    ImageIcon contarVotosParaCandidatoImg = new ImageIcon("./src/main/java/br/ufpb/sistemaeleitoral/imgs/contarVotosImg.png");
    JButton botaoCadastrarCandidato, botaoCadastrarEleitor, botaoVotar, botaoObterDadosDoCandidato, botaoContarVotosParaCandidato;
    SistemaEleitoralMap sistema = new SistemaEleitoralMap();

    public SistemaEleitoralGUI() {
        setTitle("Sistema ELeitoral");
        setSize(700, 550);
        setLocation(150, 150);
        setResizable(false);
        getContentPane().setBackground(Color.orange);
        linha1 = new JLabel("SISTEMA ELEITORAL", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Arial", Font.BOLD, 20));
        linha2 = new JLabel(urnaEletronicaImg, JLabel.CENTER);
        linha3 = new JLabel();

        botaoCadastrarCandidato = new JButton("CADASTRAR CANDIDATO", cadastroCandidatoImg);
        botaoCadastrarCandidato.addActionListener(new SistemaEleitoralAddCadidatoController(sistema, this));
        botaoCadastrarEleitor = new JButton("CADASTRAR ELEITOR", cadastroEleitorImg);
        botaoCadastrarEleitor.addActionListener(new SistemaEleitoralAddEleitorController(sistema, this));
        botaoVotar = new JButton("VOTAR", votarImg);
        botaoVotar.addActionListener(new SistemaEleitoralVotarController(sistema, this));
        botaoObterDadosDoCandidato = new JButton("OBTER DADOS DO CANDIDATO", obterDadosDoCandidatoImg);
        botaoObterDadosDoCandidato.addActionListener(new SistemaEleitoralObterDadosController(sistema, this));
        botaoContarVotosParaCandidato = new JButton("CONTAR VOTOS PARA CANDIDATO", contarVotosParaCandidatoImg);
        botaoContarVotosParaCandidato.addActionListener(new SistemaEleitoralContarVotosController(sistema, this));

        setLayout(new GridLayout(4, 2));
        add(linha1);
        add(botaoCadastrarCandidato);
        add(linha2);
        add(botaoCadastrarEleitor);
        add(linha3);
        add(linha3);
        add(linha3);
        add(botaoVotar);
        add(botaoObterDadosDoCandidato);
        add(botaoContarVotosParaCandidato);

    }

    public static void main(String[] args) {
        JFrame janela = new SistemaEleitoralGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
