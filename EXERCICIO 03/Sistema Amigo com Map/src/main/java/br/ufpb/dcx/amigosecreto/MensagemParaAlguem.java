package br.ufpb.dcx.amigosecreto;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return this.emailDestinatario;
    }

    public void setEmailDestinatario(String novoEmailDestinatario) {
        this.emailDestinatario = novoEmailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()) {
            return "Mensagem para Alguém \n " + "Texto: " + super.getTexto();
        } else {
            return "Mensagem de: " + super.getEmailRemetente() + "\nPara: " + this.getEmailDestinatario() + "\nTexto: "
                    + super.getTexto();
        }
    }
}
