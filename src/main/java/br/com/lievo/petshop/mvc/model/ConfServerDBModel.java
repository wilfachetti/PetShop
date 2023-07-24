package br.com.lievo.petshop.mvc.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public enum ConfServerDBModel {
	
	MARIADB("mariadb", 3306l),
	MYSQL("mysql", 3306l),
	ORACLE("oracle", 1521l),
	SQLSERVER("sqlserver", 1433l),
	POSTGRES("postgresql", 5432l);
	
	private String managerName, host;
	private Long port;
	
	ConfServerDBModel(String managerName, Long port) {
		this.managerName = managerName;
		this.host = "localhost";
		this.port = port;
		
		getFileConfig();
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public String getManagerName() {
		return managerName;
	}
		
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setPort(Long port) {
		this.port = port;
	}
	
	public Long getPort() {
		return port;
	}
	
	public void getFileConfig() {		
		try {
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject conf = (JSONObject) jsonParser.parse(new FileReader("conf.json")); 
			JSONObject network = (JSONObject) conf.get("network");
			
			if(!network.get("host").equals("")) 
				host = (String) network.get("host");
			
			if(!(network.get("port") == null)) 
				port = (Long) network.get("port");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}		
 	}
	
	@SuppressWarnings("unchecked")
	public void setFileConfig() {		
		try {			
			
			JSONObject network = new JSONObject();
			network.put("host", String.format("%s", host));
			network.put("port", port);				
			
			JSONObject jsonObject = new JSONObject(); 
			jsonObject.put("network", network);
			
			FileWriter file = new FileWriter("conf.json");		
			file.write(jsonObject.toJSONString());
	        file.close();	        
	        
		} catch (IOException e) {
			e.printStackTrace();
		} 		
 	}
	
}
