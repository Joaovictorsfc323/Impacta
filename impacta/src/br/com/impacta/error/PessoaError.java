package br.com.impacta.error;

public class PessoaError extends Exception {

    public PessoaError(String message) {
        super(message);
    }

    public PessoaError(String message, Throwable error) {
        super(message, error);
    }
}
