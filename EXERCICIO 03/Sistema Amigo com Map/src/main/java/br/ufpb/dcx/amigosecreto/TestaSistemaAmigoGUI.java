package br.ufpb.dcx.amigosecreto;

import java.util.List;

import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {

	public static void main(String[] args) throws AmigoInexistenteException {
		int maxMsg = Integer.parseInt(JOptionPane.showInputDialog("QUAL O MÁXIMO DE MENSAGENS?"));
		SistemaAmigo sistema = new SistemaAmigo(maxMsg);

		int quantDeParticipantes = Integer.parseInt(JOptionPane.showInputDialog("QUAL A QUANTIDADE DE PARTICIPANTES?"));

		for (int i = 0; i < quantDeParticipantes; i++) {
			String nomeAmigo = JOptionPane.showInputDialog("DIGITE O SEU NOME");
			String emailAmigo = JOptionPane.showInputDialog("QUAL O SEU EMAIL, " + nomeAmigo + " ?");

			try {
				sistema.cadastraAmigo(nomeAmigo, emailAmigo);
				JOptionPane.showMessageDialog(null, nomeAmigo + " foi cadastrado(a) com sucesso!");
			} catch (AmigoJaExisteException e) {
				JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar, amigo já existe...");
				e.printStackTrace();
			}
		}

		for (int i = 0; i <= quantDeParticipantes; i++) {
			String emailDaPessoa = JOptionPane.showInputDialog("Digite o email da pessoa");
			String emailDoAmigoSecreto = JOptionPane.showInputDialog("Quem é o amigo secreto de: " + emailDaPessoa + " ?");

			try {
				sistema.configuraAmigoSecretoDe(emailDaPessoa, emailDoAmigoSecreto);
				JOptionPane.showMessageDialog(null, "Configurado com sucesso! \n " + "Amigo secreto de " + emailDaPessoa + " é: " + emailDoAmigoSecreto);
			} catch (AmigoInexistenteException e) {
				JOptionPane.showMessageDialog(null, "PROBLEMA AO CONFIGURAR");
				e.printStackTrace();
			}
		}
			
		String texto = JOptionPane.showInputDialog("Digite o texto da mensagem a enviar ");
		String emailRemetente = JOptionPane.showInputDialog("Digite seu email cadastrado no sistema ");
		String msgEhAnonima = JOptionPane.showInputDialog("A mensagem é anônima? Digite (S) para SIM ou (N) para NÃO");
		boolean ehAnonima;

		if (msgEhAnonima.equalsIgnoreCase("S")) {
			ehAnonima = true;
		} else {
			ehAnonima = false;
		}

		sistema.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);
		List<Mensagem> todasAsMensagens = sistema.pesquisaTodasAsMensagens();
		for (Mensagem msg : todasAsMensagens) {
			JOptionPane.showMessageDialog(null, msg.getTextoCompletoAExibir());
		}
	}
}
