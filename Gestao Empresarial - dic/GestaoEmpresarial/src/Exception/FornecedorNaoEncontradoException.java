package Exception;

public class FornecedorNaoEncontradoException extends RuntimeException {
    public FornecedorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
