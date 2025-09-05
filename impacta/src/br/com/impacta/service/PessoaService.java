package br.com.impacta.service;

import br.com.impacta.error.PessoaError;
import br.com.impacta.model.Pessoa;
import br.com.impacta.repository.PessoaRepository;
import br.com.impacta.repository.PessoaRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class PessoaService {

    public void salvar(Pessoa pessoa) throws PessoaError {
        if (pessoa == null ||
                pessoa.getNome().isEmpty() ||
                pessoa.getDataNascimento().isEmpty() ||
                pessoa.getCpf().isEmpty()) {
            throw new PessoaError("Os valores não podem ser nulos");
        }

        PessoaRepository repository = new PessoaRepositoryImpl();
        repository.salvar(pessoa);
    }

    public List<Pessoa> listar() throws PessoaError {


        PessoaRepository repository = new PessoaRepositoryImpl();
        return repository.listar();

    }
}
