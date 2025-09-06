package br.com.impacta.repository;

import br.com.impacta.error.PessoaError;
import br.com.impacta.model.Pessoa;

import java.util.List;

public interface PessoaRepository {

    void salvar(Pessoa pessoa) throws PessoaError;

    List<Pessoa> listar() throws PessoaError;

    void excluirId(int id) throws PessoaError;


}
