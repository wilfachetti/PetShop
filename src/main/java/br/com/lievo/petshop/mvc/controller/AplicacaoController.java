package br.com.lievo.petshop.mvc.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.lievo.petshop.db.ConnectionDB;
import br.com.lievo.petshop.mvc.model.ClienteModel;
import br.com.lievo.petshop.mvc.model.ClientesTableModel;
import br.com.lievo.petshop.mvc.view.AplicacaoView;
import br.com.lievo.petshop.mvc.view.ClienteView;
import br.com.lievo.petshop.mvc.view.ConfDBServerView;
import br.com.lievo.petshop.mvc.view.SobreView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class AplicacaoController {
	
	private AplicacaoView appView;	
	private ClientesTableModel modeloClientes;
	private List<ClienteModel> listaClientes;
	
	public AplicacaoController(AplicacaoView appView) {			
		setPropriedades(appView);
		setActionListeners();		
	}
	
	public void setPropriedades(AplicacaoView appView) {
		this.appView = appView;
		atualizarTblClientes();
	}
	
	public void setActionListeners() {		
		this.appView.getMntmSair().addActionListener(e -> cliqueBtnSair());
		this.appView.getMntmServidorDeBanco().addActionListener(e -> cliqueBtnConfServerDB());
		this.appView.getMntmSobrePetshop().addActionListener(e -> cliqueBtnSobre());
		this.appView.getMntmCadastrarCliente().addActionListener(e -> cliqueBtnCadCliente());
		this.appView.getMntmClientesCadastrados().addActionListener(e -> cliqueRelatorioClientes());
		
		this.appView.getBtnCadVenda().addActionListener(e -> cliqueBtnCadVenda());
		this.appView.getBtnCadCliente().addActionListener(e -> cliqueBtnCadCliente());
		this.appView.getBtnCadPet().addActionListener(e -> cliqueBtnCadPet());
		this.appView.getBtnOutro().addActionListener(e -> cliqueBtnOutro());
		this.appView.getBtnRelatorio().addActionListener(e -> cliqueRelatorioClientes());

		this.appView.getLblPetshop().addMouseListener(mouseListenerLblSobre());		
		this.appView.getTblClientes().addMouseListener(mouseListenerLinhaTblCliente(this.appView.getTblClientes()));
	}
	
	public void iniciarController() {		
		appView.setVisible(true);
	}
	
	public void cliqueBtnConfServerDB() {
		ConnectionDB.getInstancia();

		ConfDBServerView confServidorDBView = new ConfDBServerView();		
		ConfDBServerController confServidorDBController = new ConfDBServerController(confServidorDBView, ConnectionDB.dados.getType() );
		
		confServidorDBController.iniciarController();
	}
	
	public MouseAdapter mouseListenerLblSobre() {
		return new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				cliqueBtnSobre();
			}
		};
	}	

	public void cliqueBtnSobre() {
		SobreView sobreView = new SobreView();
		SobreController sobreController = new SobreController(sobreView);
		
		sobreController.iniciarController();
	}
	
	public void cliqueBtnCadVenda() {		
	
	}	
	
	public void cliqueBtnCadCliente() {		
		ClienteView clienteView = new ClienteView();
		ClienteModel clienteModel = new ClienteModel();
		ClienteController clienteController = new ClienteController(clienteView, clienteModel);	
		
		clienteController.iniciarController();
		atualizarTblClientes();
	}
	
	public void cliqueBtnCadPet() {
		
	}
	
	public void cliqueBtnOutro() {		
		ClienteView clienteView = new ClienteView();
		ClienteModel clienteAtualizar = new ClienteModel();		
		
		ClienteController clienteController = new ClienteController(clienteView, clienteAtualizar.buscarCliente(10l));
		clienteController.iniciarController();
	}
	
	public void cliqueRelatorioClientes() {
		String relatorio = "Clientes.jasper";
		InputStream inputStream = getClass().getResourceAsStream( "/reports/" + relatorio);
		
		HashMap<String, Object> params = new HashMap<>();
		InputStream logo = getClass().getResourceAsStream("/img/pets.png");
		params.put("logo", logo);
		
		ConnectionDB.getInstancia();
		
		JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(inputStream, params, ConnectionDB.conexao);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "Relatorio.pdf");
			java.awt.Desktop.getDesktop().open(new File("Relatorio.pdf"));
		} catch (JRException | IOException e1) {
			e1.printStackTrace();
		}				
		
//		JasperViewer jrviewer = new JasperViewer(jasperPrint, true);
//		jrviewer.setTitle("Relatório");
//		//jrviewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		jrviewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		jrviewer.setVisible(true);
		   
	}	
	
	public void atualizarTblClientes() {
		ClienteModel cliente = new ClienteModel();
		listaClientes = cliente.getClientes();		

		modeloClientes = new ClientesTableModel(listaClientes);
		
		appView.getTblClientes().setModel(modeloClientes);
		appView.resizeColumnsTableClientes();
	}

	public MouseAdapter mouseListenerLinhaTblCliente(JTable tblClientes) {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					long id = (long) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);
					apresentaMensagemDuploCliqueLinhaTabela(id);							    		
				}
			}
		};
	}
	
	public void apresentaMensagemDuploCliqueLinhaTabela(Long id) {
		Object[] opcoes = {"Remover", "Editar", "Cancelar"};
		Object[] opcoesExclusao = {"Sim", "Não"};
		
		int opcao = JOptionPane.showOptionDialog(null, "Qual ação deseja realizar?", "Opções", 1,  JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[2]);
		 
		switch (opcao) {
		case 0:			
			if(JOptionPane.showOptionDialog(null, "Deseja realmente excluir o Cliente?", "Remover Cliente", 1, JOptionPane.ERROR_MESSAGE, null, opcoesExclusao, opcoesExclusao[1]) == 0)
				removerCliente(id);
			break;
		case 1:
			editarCliente(id);
			break;
		}
	}
	
	public void editarCliente(Long id) {
		ClienteView clienteView = new ClienteView();
		ClienteModel clienteAtualizar = new ClienteModel();		
		
		ClienteController clienteController = new ClienteController(clienteView, clienteAtualizar.buscarCliente(id));
		clienteController.iniciarController();
		
		atualizarTblClientes();
	}
	
	public void removerCliente(Long id) {
		ClienteModel cliente = new ClienteModel();
		cliente.removerCliente(id);
		
		atualizarTblClientes();
	}

	public void cliqueBtnSair() {
		appView.dispose();
	}	
}