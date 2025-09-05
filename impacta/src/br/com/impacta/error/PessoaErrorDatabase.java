package br.com.impacta.error;

public class PessoaErrorDatabase extends PessoaError {


    public PessoaErrorDatabase(String message) {
        super(message);
    }

    public PessoaErrorDatabase(String message, Throwable error) {
        super(message, error);
    }
}
