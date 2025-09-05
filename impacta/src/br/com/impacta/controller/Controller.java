package br.com.impacta.controller;

import br.com.impacta.error.PessoaError;
import br.com.impacta.model.Pessoa;
import br.com.impacta.service.PessoaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
    private TextField textFieldDataNascimento;

    @FXML
    private Button buttonExcluir;

    @FXML
    private Button buttonLimpar;

    @FXML
    private Button buttonAdicionar;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldCpf;

    @FXML
    private TableColumn<Pessoa,String> tableNome;

    @FXML
    private TableColumn<Pessoa,String> tableCpf;

    @FXML
    private TableColumn<Pessoa,String> tableId;

    @FXML
    private TableColumn<Pessoa,String> tableData;

    @FXML
    void adicionar(ActionEvent event) {
        String nome = textFieldNome.getText();
        String dataNascimento = textFieldDataNascimento.getText();
        String cpf = textFieldCpf.getText();
        Pessoa pessoa = new Pessoa(nome, dataNascimento, cpf);
        System.out.println(pessoa);

        try {
            PessoaService service = new PessoaService();
            service.salvar(pessoa);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText("Cadastro salvo");
            alert.showAndWait();
        } catch (PessoaError e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falha");
            alert.setHeaderText("Erro ao Cadastrar");
            alert.showAndWait();

        }

    }

    @FXML
    void excluir(ActionEvent event) {
        System.out.println("limpou");

    }

    @FXML
    void limpar(ActionEvent event) {
        System.out.println("excluiu");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarTabela();
    }

    void carregarTabela (){
        System.out.println("Inicializando os dados da tabela");

    }


}

