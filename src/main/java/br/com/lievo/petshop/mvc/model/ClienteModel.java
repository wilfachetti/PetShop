package br.com.lievo.petshop.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.lievo.petshop.db.ConnectionDB;

public class ClienteModel {

	private Long id = null;
	private String nome = "";
	private String cpf = "";
	private String rg = "";
	private boolean genero;    
	private String dataNascimento = "";
	private String telefone1 = "";
	private String telefone2 = ""; 
	private String email = "";
	private String logradouro = "";
	private String numero = "";
	private String bairro = "";
	private String complemento = ""; 
	private String municipio = "";
	private String uf = "";
	private String cep = "";

	private Connection conexao;
	
	public ClienteModel() {
		ConnectionDB.getInstancia();
		this.conexao = ConnectionDB.conexao;		
	}
	
	public Boolean isNull() {
		if(id == null) 
			return true; 
		else 
			return false;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public boolean getGenero() {
		return genero;
	}
	
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
		
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return telefone1;
	}

	public void setCelular(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone() {
		return telefone2;
	}

	public void setTelefone(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Boolean salvar() {
		Boolean resultado = false;
		String sql = "INSERT INTO clientes"
				+ "(nome, cpf, rg, genero, data_nascimento, telefone1, telefone2, email, logradouro, numero, bairro, complemento, municipio, uf, cep)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement(sql);
			
			pstm.setString(1, getNome());
			pstm.setString(2, getCpf());
			pstm.setString(3, getRg());
			pstm.setBoolean(4, getGenero());			
			pstm.setString(5, converteDataDB(getDataNascimento()));
			pstm.setString(6, getCelular());
			pstm.setString(7, getTelefone());
			pstm.setString(8, getEmail());
			pstm.setString(9, getLogradouro());
			pstm.setString(10, getNumero());
			pstm.setString(11, getBairro());
			pstm.setString(12, getComplemento());
			pstm.setString(13, getMunicipio());
			pstm.setString(14, getUf());
			pstm.setString(15, getCep());
			
			/*
			pstm.executeUpdate(); // Use para executar statemens DML como INSERT, UPDATE e DELETE.
			pstm.executeQuery(); // Use na execução pequisas ao recuperar dados do BD por meio do SELECT.
			pstm.execute(); // Dê preferência ao seu uso na Criação (CREATE) e Alteração (ALTER) de Tabelas. Este também funciona para DML, mas não o utilize assim.
			*/

			if(pstm.executeUpdate() > 0) {
				pstm.close();
				resultado = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public Boolean atualizar() {
		Boolean resultado = false;
		String sql = "UPDATE clientes "
				+ "SET nome = ?, cpf = ?, rg = ?, genero = ?, data_nascimento = ?, telefone1 = ?, telefone2 = ?, email = ?, logradouro = ?, numero = ?, bairro = ?, complemento = ?, municipio = ?, uf = ?, cep = ?"
				+ "WHERE id_cliente = ?;";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement(sql);
			
			pstm.setString(1, getNome());
			pstm.setString(2, getCpf());
			pstm.setString(3, getRg());
			pstm.setBoolean(4, getGenero());			
			pstm.setString(5, converteDataDB(getDataNascimento()));
			pstm.setString(6, getCelular());
			pstm.setString(7, getTelefone());
			pstm.setString(8, getEmail());
			pstm.setString(9, getLogradouro());
			pstm.setString(10, getNumero());
			pstm.setString(11, getBairro());
			pstm.setString(12, getComplemento());
			pstm.setString(13, getMunicipio());
			pstm.setString(14, getUf());
			pstm.setString(15, getCep());
			pstm.setLong(16, getId());

			if(pstm.executeUpdate() > 0) {
				resultado = true;
				pstm.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public Boolean removerCliente(Long id) {
		Boolean resultado = false;
		String sql = "DELETE FROM clientes WHERE id_cliente = ?;";
		
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setLong(1, id);

			if(pstm.executeUpdate() > 0) {
				resultado = true;
				pstm.close();
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resultado)
			JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
		
		return resultado;	
	}
	
	public ClienteModel buscarCliente(Long id) {		
		ClienteModel resultado = new ClienteModel();
		String sql = "SELECT * FROM clientes WHERE id_cliente = ?;";
				
		PreparedStatement pstm = null;
		
		try {
			pstm = conexao.prepareStatement(sql);
			
			pstm.setLong(1, id);
			
			ResultSet rs = pstm.executeQuery();
			rs.next();
			
			resultado.setId(rs.getLong("id_cliente"));
			resultado.setNome(rs.getString("nome"));
			resultado.setCpf(rs.getString("cpf"));
			resultado.setRg(rs.getString("rg"));
			resultado.setGenero(rs.getBoolean("genero"));
			resultado.setDataNascimento(converteDataBR(rs.getString("data_nascimento")));
			resultado.setCelular(rs.getString("telefone1"));
			resultado.setTelefone(rs.getString("telefone2"));
			resultado.setEmail(rs.getString("email"));
			resultado.setLogradouro(rs.getString("logradouro"));
			resultado.setNumero(rs.getString("numero"));
			resultado.setBairro(rs.getString("bairro"));
			resultado.setComplemento(rs.getString("complemento"));
			resultado.setMunicipio(rs.getString("municipio"));
			resultado.setUf(rs.getString("uf"));
			resultado.setCep(rs.getString("cep"));
			
			pstm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public List<ClienteModel> getClientes() {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM clientes";
		
		ArrayList<ClienteModel> clientes = new ArrayList<>();
		
		try {
			pstm = conexao.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ClienteModel cliente = new ClienteModel();

				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCelular(rs.getString("telefone1"));
				cliente.setEmail(rs.getString("email"));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
		}
		return clientes;
	}
	
	public String converteDataDB(String data) {
		Date date = null;
		String dataConvertida = null;
		
		try {
			SimpleDateFormat formatoDataBR = new SimpleDateFormat("dd/MM/yyyy");
			date = formatoDataBR.parse(data);
			SimpleDateFormat formatoDataDB = new SimpleDateFormat("yyyy-MM-dd");
			dataConvertida = formatoDataDB.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataConvertida;
	}
	
	public String converteDataBR(String data) {
		Date date = null;
		String dataConvertida = null;
		
		try {
			SimpleDateFormat formatoDataDB = new SimpleDateFormat("yyyy-MM-dd");
			date = formatoDataDB.parse(data);
			SimpleDateFormat formatoDataBR = new SimpleDateFormat("dd/MM/yyyy");
			dataConvertida = formatoDataBR.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataConvertida;
	}

	@Override
	public String toString() {
		return "ClienteModel [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", genero=" + genero
				+ ", dataNascimento=" + dataNascimento + ", telefone1=" + telefone1 + ", telefone2=" + telefone2
				+ ", email=" + email + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", complemento=" + complemento + ", municipio=" + municipio + ", uf=" + uf + ", cep=" + cep
				+ ", conexao=" + "]";
	}	
}
