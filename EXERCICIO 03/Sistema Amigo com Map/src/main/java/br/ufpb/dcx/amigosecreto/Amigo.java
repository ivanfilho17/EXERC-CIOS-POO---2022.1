package br.ufpb.dcx.amigosecreto;

public class Amigo {

    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nomeAmigo, String emailAmigo) {
        this.nome = nomeAmigo;
        this.email = emailAmigo;
        this.emailAmigoSorteado = null;
    }

    @Override
    public String toString() {
        return "Amigo [ Nome: " + nome + ", Email: " + email + " ]";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public String getEmailAmigoSorteado() {
        return this.emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String novoEmailAmigoSorteado) {
        this.emailAmigoSorteado = novoEmailAmigoSorteado;
    }
}
