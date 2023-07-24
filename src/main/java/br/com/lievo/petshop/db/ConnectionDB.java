package br.com.lievo.petshop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.lievo.petshop.mvc.model.ConfServerDBModel;

public class ConnectionDB {	
	
	private static ConnectionDB instancia;
	public static Connection conexao;
	public static ConnectionData dados;
	
	private ConnectionDB() {
		
		dados = new ConnectionData(ConfServerDBModel.MARIADB, "petshop", "root", "root");
		
		try {
			
			conexao = (Connection) DriverManager.getConnection(dados.getUrl(), dados.getUser(), dados.getPass());
		
		} catch (SQLException e) {
			System.err.print("Não foi possível abrir uma conexão com o banco de dados.\n" + e.getMessage());
		}		
	}
	
	public static ConnectionDB getInstancia() {
		if(instancia == null)
			instancia = new ConnectionDB();
			
		return instancia;   	  	
    }
}
