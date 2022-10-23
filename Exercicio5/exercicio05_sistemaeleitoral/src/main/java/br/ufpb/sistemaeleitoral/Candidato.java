package br.ufpb.sistemaeleitoral;

public class Candidato {
    private String nome;
    private int numero;
    private Partido partido;

    public Candidato(String nome, int numero, Partido partido) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int novoNumero) {
        this.numero = novoNumero;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido novoPartido) {
        this.partido = novoPartido;
    }

    @Override
    public String toString() {
        return "Candidato [nome=" + nome + ", numero=" + numero + ", partido=" + partido + "]";
    }

    
}
