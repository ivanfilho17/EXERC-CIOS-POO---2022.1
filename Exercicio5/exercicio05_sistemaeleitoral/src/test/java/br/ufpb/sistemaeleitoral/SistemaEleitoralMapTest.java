package br.ufpb.sistemaeleitoral;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SistemaEleitoralMapTest {

    SistemaEleitoralMap sistema = new SistemaEleitoralMap();

    @Test
    public void testaCadastraEleitor() {
        Eleitor eleitor1 = new Eleitor("Ana", "1111-1");
        boolean cadastro1 = sistema.cadastraEleitor(eleitor1.getNome(), eleitor1.getTitulo());
        assertTrue(cadastro1);

        boolean cadastro2 = sistema.cadastraEleitor("Ana", "1111-1");
        assertFalse(cadastro2);
    }

    @Test
    public void testaCadastraCandidato() {
        Candidato candidato1 = new Candidato("José", 10, Partido.PARTIDO1);
        boolean cadastroCandidato1 = sistema.cadastraCandidato(candidato1.getNome(), candidato1.getNumero(),
                candidato1.getPartido());
        assertTrue(cadastroCandidato1);
    }

    @Test
    public void testaVoto() {
        try {
            boolean cadastroEleitor = sistema.cadastraEleitor("João", "2222-2");
            boolean cadastroCandidato2 = sistema.cadastraCandidato("Lukas", 70, Partido.PARTIDO2);
            Voto voto1 = new Voto(70);
            assertEquals(0, sistema.contarVotosParaCandidato(70));
            sistema.votar("2222-2", voto1.getNumeroVotado());
            assertEquals(1, sistema.contarVotosParaCandidato(70));

        } catch (TituloInexistenteException e) {
            fail("Não deveria lançar exceção pois existe esse titulo");
        }
    }

    @Test
    public void testaObterDadosDoCandidato() {
        Candidato candidato2 = new Candidato("Maria", 44, Partido.PARTIDO2);
        boolean cadastroCandidato2 = sistema.cadastraCandidato(candidato2.getNome(), candidato2.getNumero(), candidato2.getPartido());
        assertEquals(44, candidato2.getNumero());
        assertTrue(candidato2.getPartido() == Partido.PARTIDO2);
        assertTrue(candidato2.getNome().equals("Maria"));
    }

}
