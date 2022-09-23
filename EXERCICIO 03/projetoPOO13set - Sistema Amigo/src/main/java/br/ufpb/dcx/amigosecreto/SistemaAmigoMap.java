package br.ufpb.dcx.amigosecreto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    private int maxMensagem;

    public static final int MAX_MSG = 1000;

    public SistemaAmigoMap(int maxMensagem) {
        this.mensagens = new LinkedList<>();
        this.amigos = new HashMap<>();
        this.maxMensagem = maxMensagem;
    }

    public SistemaAmigoMap() {
        this(MAX_MSG);
    }

    public int getMaxMensagem() {
        return this.maxMensagem;
    }

    public List<Mensagem> getMensagem() {
        return this.mensagens;
    }

    public Map<String, Amigo> getAmigo() {
        return this.amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        boolean jaExiste = false;

        for(Amigo a : this.amigos.values()) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                jaExiste = true;
                break;
            }
        }
        if(jaExiste) {
            throw new AmigoJaExisteException("Não foi possível cadastrar, o amigo já existe");
        } else {
            Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
            this.amigos.put(emailAmigo, novoAmigo);
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        for (Amigo a : this.amigos.values()) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                return a;
            } 
        }
        throw new AmigoInexistenteException("O Amigo pesquisado não existe ou não está cadastrado no sistema.");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        this.mensagens.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,
            boolean ehAnonima) {
        this.mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        LinkedList<Mensagem> msgAnonima = new LinkedList<>();

        for (Mensagem msg : this.mensagens) {
            if (msg.ehAnonima()) {
                msgAnonima.add(msg);
            }
        }
        return msgAnonima;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        boolean amigoEncontrado = false;

        for (Amigo a : this.amigos.values()) {
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                amigoEncontrado = true;
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                break;
            }
        }
        if (!amigoEncontrado) {
            throw new AmigoInexistenteException("Não existe pessoa no sistema cadastrada com o email: " + emailDaPessoa);
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
       
        for (Amigo a : this.amigos.values()) {
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                String emailSorteado = a.getEmailAmigoSorteado();
                if (emailSorteado == null) {
                    throw new AmigoNaoSorteadoException("Ainda não foi sorteado o amigo secreto da pessoa de email " + emailDaPessoa);
                } else {
                    return emailSorteado;
                }
            }
        }
        throw new AmigoInexistenteException("O Amigo de email " + emailDaPessoa + " não está cadastrado(a) no sistema");
    }

    public Map<String, Amigo> todosParticipantes() throws AmigoInexistenteException {
        HashMap<String, Amigo> todosAmigos = new HashMap<>();

        for (Amigo a : this.amigos.values()) {
            if (a.equals(null)) {
                todosAmigos.put(null, a);
                System.out.println(a.getNome() + ", " + a.getEmail());
            }
            return todosAmigos;
        }
        throw new AmigoInexistenteException("Não existe amigos");
    }

    public Map<String, Amigo> pesquisaTodosParticipantes() {
        Map<String, Amigo> participantes = amigos;
        participantes.putAll(amigos);
        return participantes;
    }
}
