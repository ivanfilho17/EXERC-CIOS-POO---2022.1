package br.ufpb.sistemaeleitoral;

public class TituloInexistenteException extends Exception {
    public TituloInexistenteException(String msg) {
        super(msg);
    }
}
