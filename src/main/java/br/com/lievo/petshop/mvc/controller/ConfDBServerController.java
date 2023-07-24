package br.com.lievo.petshop.mvc.controller;

import br.com.lievo.petshop.mvc.model.ConfServerDBModel;
import br.com.lievo.petshop.mvc.view.ConfDBServerView;

public class ConfDBServerController {
	private ConfDBServerView confServerView;
	private ConfServerDBModel confServerDBModel;

	public ConfDBServerController(ConfDBServerView confServerView, ConfServerDBModel confServerDBModel) {		
		this.confServerView = confServerView;	
		this.confServerDBModel = confServerDBModel;
		
		this.confServerView.getBtnSalvar().addActionListener(e -> cliqueBtnSalvar());
		this.confServerView.getBtnCancelar().addActionListener(e -> cliqueBtnCancelar());
	}
	
	public void iniciarController() {
		carregarDadosServer();
		
		confServerView.setModal(true);
		confServerView.setVisible(true);
	}	

	public void carregarDadosServer() {
		confServerView.getTxfIp().setText(confServerDBModel.getHost());
		if(confServerDBModel.getPort() == null)
			confServerView.getTxfPorta().setText("");
		else
			confServerView.getTxfPorta().setText(confServerDBModel.getPort().toString());
	}
	
	public void cliqueBtnSalvar() {
		confServerDBModel.setHost(confServerView.getTxfIp().getText());
		
		Long port;
		if((confServerView.getTxfPorta().getText().equals("")))
			port = (Long) null;	
		else 
			port = Long.parseLong(confServerView.getTxfPorta().getText());
				
		confServerDBModel.setPort(port);		
		confServerDBModel.setFileConfig();
		
		cliqueBtnCancelar();
	}
	
	public void cliqueBtnCancelar() {
		confServerView.dispose();
	}
}
