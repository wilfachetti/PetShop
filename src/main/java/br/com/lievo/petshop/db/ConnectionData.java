package br.com.lievo.petshop.db;

import br.com.lievo.petshop.mvc.model.ConfServerDBModel;

public class ConnectionData {
	
	private ConfServerDBModel type;
	private String database, user, pass;
	
	public ConnectionData(ConfServerDBModel type, String database, String user, String pass) {
		this.type = type;
		this.database = database;
		this.user = user;
		this.pass = pass;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String getUrl() {
		String url = String.format("jdbc:%s://%s:%s/%s", type.getManagerName(), type.getHost(), type.getPort(), this.database);
		
		return url;
	}
	
	public ConfServerDBModel getType() {
		return type;
	}
	
}
