package br.com.impacta.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoRepository {

    public static Connection getconexao() throws SQLException {

        String desabilitaSSl = "useSSL=false";
        String defineTimeZone = "serverTimezone=UTC";
        String url = "jdbc:mysql://localhost:3306/cadastro?" + desabilitaSSl + "&" + defineTimeZone;
        String usuario = "root";
        String senha = "Imp@ct@";


        Connection connection = DriverManager.getConnection(url, usuario, senha);
        return connection;
    }


}
