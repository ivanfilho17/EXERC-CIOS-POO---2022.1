package br.ufpb.dcx.amigosecreto;

import java.util.LinkedList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    private int maxMensagem;

    public static final int MAX_MSG = 1000;

    public SistemaAmigo(int maxMensagem) {
        this.mensagens = new LinkedList<>();
        this.amigos = new LinkedList<>();
        this.maxMensagem = maxMensagem;
    }

    public SistemaAmigo() {
        this(MAX_MSG);
    }

    public int getMaxMensagem() {
        return this.maxMensagem;
    }

    public List<Mensagem> getMensagem() {
        return this.mensagens;
    }

    public List<Amigo> getAmigo() {
        return this.amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        boolean jaExiste = false;

        for(Amigo a : this.amigos) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                jaExiste = true;
                break;
            }
        }
        if(jaExiste) {
            throw new AmigoJaExisteException("Não foi possível cadastrar, o amigo já existe");
        } else {
            Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
            this.amigos.add(novoAmigo);
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        for (Amigo a : this.amigos) {
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

        for (Amigo a : this.amigos) {
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
       
        for (Amigo a : amigos) {
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

    public List<Amigo> todosParticipantes() throws AmigoInexistenteException {
        LinkedList<Amigo> todosAmigos = new LinkedList<>();

        for (Amigo a : amigos) {
            if (a.equals(null)) {
                todosAmigos.add(a);
                System.out.println(a.getNome() + ", " + a.getEmail());
            }
            return todosAmigos;
        }
        throw new AmigoInexistenteException("Não existe amigos");
    }

    public List<Amigo> pesquisaTodosParticipantes() {
        List<Amigo> participantes = amigos;
        participantes.addAll(amigos);
        return participantes;
    }
}
