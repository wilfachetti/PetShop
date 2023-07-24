package br.com.lievo.petshop.mvc.controller;

import javax.swing.JOptionPane;

import br.com.lievo.petshop.mvc.model.ClienteModel;
import br.com.lievo.petshop.mvc.view.ClienteView;

public class ClienteController {
	
	private ClienteView clienteView;
	private ClienteModel clienteModel;
	
	public ClienteController(ClienteView clienteView, ClienteModel clienteModel) {		
		this.clienteView = clienteView;
		this.clienteModel = clienteModel;		
		
		this.clienteView.getBtnSalvar().addActionListener(e -> cliqueBtnSalvar());
		this.clienteView.getBtnCancelar().addActionListener(e -> cliqueBtnCancelar());
		
		verificaEdicao();
	}
	
	public void iniciarController() {	
		clienteView.setVisible(true);
	}
	
	private void verificaEdicao() {
		if(!(clienteModel.isNull())) 
			setDadosView();
	}
	
	private void setDadosView() {
		clienteView.setTitle("Editar Cliente");
		clienteView.setLblTitulo("Editar Cliente");
		
		clienteView.setId(clienteModel.getId());
		clienteView.getTxfNome().setText(clienteModel.getNome());
		clienteView.getTxfCpf().setText(clienteModel.getCpf());
		clienteView.getTxfRg().setText(clienteModel.getRg());
		clienteView.setGenero(clienteModel.getGenero());
		clienteView.getTxfDataNascimento().setText(clienteModel.getDataNascimento());
		clienteView.getTxfCelular().setText(clienteModel.getCelular());
		clienteView.getTxfTelefone().setText(clienteModel.getTelefone());
		clienteView.getTxfEmail().setText(clienteModel.getEmail());
		clienteView.getTxfLogradouro().setText(clienteModel.getLogradouro());
		clienteView.getTxfNumero().setText(clienteModel.getNumero());
		clienteView.getTxfComplemento().setText(clienteModel.getComplemento());
		clienteView.getTxfBairro().setText(clienteModel.getBairro());
		clienteView.getTxfMunicipio().setText(clienteModel.getMunicipio());
		clienteView.getTxfUf().setText(clienteModel.getUf());
		clienteView.getTxfCep().setText(clienteModel.getCep());
	}
	
	public void setDadosModel() {
		clienteModel.setId(clienteView.getId());
		clienteModel.setNome(clienteView.getTxfNome().getText());
		clienteModel.setCpf(clienteView.getTxfCpf().getText());
		clienteModel.setRg(clienteView.getTxfRg().getText());
		clienteModel.setGenero(clienteView.getGenero());
		clienteModel.setDataNascimento(clienteView.getTxfDataNascimento().getText());
		clienteModel.setCelular(clienteView.getTxfCelular().getText());
		clienteModel.setTelefone(clienteView.getTxfTelefone().getText());
		clienteModel.setEmail(clienteView.getTxfEmail().getText());
		clienteModel.setLogradouro(clienteView.getTxfLogradouro().getText());
		clienteModel.setNumero(clienteView.getTxfNumero().getText());
		clienteModel.setComplemento(clienteView.getTxfComplemento().getText());
		clienteModel.setBairro(clienteView.getTxfBairro().getText());
		clienteModel.setMunicipio(clienteView.getTxfMunicipio().getText());
		clienteModel.setUf(clienteView.getTxfUf().getText());
		clienteModel.setCep(clienteView.getTxfCep().getText());
	}
	
	public void gravar() {
		String SUCESSO = "Cliente " +  clienteModel.getNome() + " salvo com sucesso!";
		String ERRO = "Ocorreu um erro ao tentar salvar o cliente.";
		
		if(clienteModel.isNull()) {
			if(clienteModel.salvar()) {
				JOptionPane.showMessageDialog(null, SUCESSO);
				cliqueBtnCancelar();
			} else
				JOptionPane.showMessageDialog(null, ERRO, "Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			if(clienteModel.atualizar()) {
				JOptionPane.showMessageDialog(null, SUCESSO);
				cliqueBtnCancelar();
			} else
				JOptionPane.showMessageDialog(null, ERRO, "Erro", JOptionPane.ERROR_MESSAGE);	
		}
	}
	 
	public void cliqueBtnSalvar() {		
		setDadosModel();
		gravar();	
	}	
	
	void cliqueBtnCancelar() {
		clienteView.dispose();
	}

 }
