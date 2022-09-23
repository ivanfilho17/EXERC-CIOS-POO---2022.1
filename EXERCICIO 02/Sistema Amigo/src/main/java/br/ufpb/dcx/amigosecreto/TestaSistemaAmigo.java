package br.ufpb.dcx.amigosecreto;

import java.util.List;

public class TestaSistemaAmigo {

	public static void main(String[] args) throws Exception {

		SistemaAmigo sistema = new SistemaAmigo();

		sistema.cadastraAmigo("José", "jose@gmail.com");
		sistema.cadastraAmigo("Maria", "maria@gmail.com");
		System.out.println("José e Maria foram cadastrados com sucesso!");

		try {
			sistema.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
			sistema.configuraAmigoSecretoDe("maria@gmail.com", "jose@gmail.com");
			System.out.println("Sucesso!");
		} catch (AmigoInexistenteException e) {
			System.out.println(e.getMessage());
		}

		sistema.enviarMensagemParaAlguem("Bom dia amigo", "jose@gmail.com", "maria@gmail.com", true);
		sistema.enviarMensagemParaTodos("Bom dia amigos", "maria@gmail.com", true);

		List<Mensagem> msgAnonima = sistema.pesquisaMensagensAnonimas();

		for (Mensagem m : msgAnonima) {
			System.out.println(m.getTextoCompletoAExibir());
		}

		try {
			sistema.pesquisaAmigoSecretoDe("jose@gmail.com");
			System.out.println("OK");
		} catch (AmigoInexistenteException e) {
			System.out.println(e.getMessage());
		}
	}
}
