package br.ufpb.sistemaeleitoral;

public class CandidatoInexistenteException extends Exception{
    public CandidatoInexistenteException(String msg) {
        super(msg);
    }
}
