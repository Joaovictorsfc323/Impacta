package br.com.impacta.repository;

import br.com.impacta.error.PessoaError;
import br.com.impacta.error.PessoaErrorDatabase;
import br.com.impacta.model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryImpl implements PessoaRepository {

    @Override
    public void salvar(Pessoa pessoa) throws PessoaError {
        try {

            Connection myql = ConexaoRepository.getconexao();

            String query = "INSERT INTO pessoa (nome,datanascimento, cpf) VALUES (?,?,?)";


            PreparedStatement ps = myql.prepareStatement(query);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getDataNascimento());
            ps.setString(3, pessoa.getCpf());

            int update = ps.executeUpdate();
            if (update <= 0) {

                throw new PessoaErrorDatabase("erro ao salvar o cadastro");
            }


        } catch (SQLException e) {
            //TODO: ajustar mensagem de error
            throw new PessoaError("Erro generico ao salvar  cadastro", e);
        }

    }

    @Override
    public List<Pessoa> listar() throws PessoaError {
        List<Pessoa> pessoas = new ArrayList<>();
        try {

            Connection myql = ConexaoRepository.getconexao();

            String query = "SELECT * FROM pessoa";

            PreparedStatement ps = myql.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String dataNascimento = resultSet.getString("datanascimento");
                String Cpf = resultSet.getString("cpf");


                Pessoa pessoa = new Pessoa(id, nome, dataNascimento, Cpf);
                pessoas.add(pessoa);

            }

        } catch (SQLException e) {
            throw new PessoaError("não foi possivel listar cadastros");

        }


        return pessoas;

    }

    @Override
    public void excluirID(int id) throws PessoaError {

    }
}
