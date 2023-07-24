package br.com.lievo.petshop.mvc.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
//import javax.swing.table.TableColumn;

import br.com.lievo.petshop.util.OwnFocusTraversalPolicy;

public class AplicacaoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem mntmServidorDeBanco, mntmConteudoDeAjuda, mntmSobrePetshop, mntmSair, mntmCadastrarCliente, mntmClientesCadastrados, mntmAnimaisCadastrados, mntmAnimaisPorClientes;
	private JPanel panelMenuBotoes, panelClientes, panelPets;
	private JButton btnCadVenda, btnCadCliente, btnCadPet, btnOutro, btnRelatorio;
	private JTable tblClientes, tblPets;
	private JScrollPane scrollClientes, scrollPets;
	private JLabel lblPetshop;
	private Vector<Component> order = new Vector<>();
	
	public AplicacaoView() {
		setTitle("PETSHOP");
		setLocale(new Locale("pt", "BR"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AplicacaoView.class.getResource("/img/pets.png")));
		setBounds(100, 100, 800, 600);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		menuAplicacao();
		menuBotoes();
		painelClientes();
		painelPets();

		addComponentListener(componentAdapter());
	}

	public void menuAplicacao() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAplicao = new JMenu("Aplicação");
		menuBar.add(mnAplicao);

		mntmServidorDeBanco = new JMenuItem("Servidor de Banco de Dados...");
		mnAplicao.add(mntmServidorDeBanco);

		mnAplicao.addSeparator();

		mntmSair = new JMenuItem("Sair");
		mnAplicao.add(mntmSair);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mnCadastros.add(mntmCadastrarCliente);

		JMenu mnRelatrios = new JMenu("Relatórios");
		menuBar.add(mnRelatrios);
		
		mntmClientesCadastrados = new JMenuItem("Clientes cadastrados");
		mnRelatrios.add(mntmClientesCadastrados);
		
		mntmAnimaisCadastrados = new JMenuItem("Animais cadastrados");
		mntmAnimaisCadastrados.setEnabled(false);
		mnRelatrios.add(mntmAnimaisCadastrados);
		
		mntmAnimaisPorClientes = new JMenuItem("Animais por Clientes");
		mntmAnimaisPorClientes.setEnabled(false);
		mnRelatrios.add(mntmAnimaisPorClientes);

		JMenu mnSobre = new JMenu("Ajuda");
		menuBar.add(mnSobre);

		mntmConteudoDeAjuda = new JMenuItem("Conteúdo de Ajuda");
		mntmConteudoDeAjuda.setEnabled(false);
		mnSobre.add(mntmConteudoDeAjuda);

		mnSobre.addSeparator();

		mntmSobrePetshop = new JMenuItem("Sobre PetShop");
		mnSobre.add(mntmSobrePetshop);
	}

	public JMenuItem getMntmCadastrarCliente() {
		return mntmCadastrarCliente;
	}

	public void setMntmCadastrarCliente(JMenuItem mntmCadastrarCliente) {
		this.mntmCadastrarCliente = mntmCadastrarCliente;
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}

	public void setMntmSair(JMenuItem mntmSair) {
		this.mntmSair = mntmSair;
	}

	public JMenuItem getMntmServidorDeBanco() {
		return mntmServidorDeBanco;
	}

	public void setMntmServidorDeBanco(JMenuItem mntmServidorDeBanco) {
		this.mntmServidorDeBanco = mntmServidorDeBanco;
	}

	public JMenuItem getMntmSobrePetshop() {
		return mntmSobrePetshop;
	}

	public void setMntmSobrePetshop(JMenuItem mntmSobrePetshop) {
		this.mntmSobrePetshop = mntmSobrePetshop;
	}

	public JMenuItem getMntmClientesCadastrados() {
		return mntmClientesCadastrados;
	}

	public void setMntmClientesCadastrados(JMenuItem mntmClientesCadastrados) {
		this.mntmClientesCadastrados = mntmClientesCadastrados;
	}

	public JMenuItem getMntmAnimaisCadastrados() {
		return mntmAnimaisCadastrados;
	}

	public void setMntmAnimaisCadastrados(JMenuItem mntmAnimaisCadastrados) {
		this.mntmAnimaisCadastrados = mntmAnimaisCadastrados;
	}

	public JMenuItem getMntmAnimaisPorClientes() {
		return mntmAnimaisPorClientes;
	}

	public void setMntmAnimaisPorClientes(JMenuItem mntmAnimaisPorClientes) {
		this.mntmAnimaisPorClientes = mntmAnimaisPorClientes;
	}

	public void menuBotoes() {
		panelMenuBotoes = new JPanel();
		panelMenuBotoes.setBackground(Color.GRAY);
		panelMenuBotoes.setLayout(null);
		panelMenuBotoes.setBounds(0, 0, getSize().width, 79);
		panelMenuBotoes.setBorder(BorderFactory.createEtchedBorder());		

		ImageIcon icone = new ImageIcon(new ImageIcon(getClass().getResource("/img/dollar.png")).getImage()
				.getScaledInstance(56, 56, java.awt.Image.SCALE_SMOOTH));
		btnCadVenda = new JButton();
		btnCadVenda.setIcon(icone);
		btnCadVenda.setBackground(Color.GRAY);
		btnCadVenda.setBounds(12, 5, 68, 68);
		order.add(btnCadVenda);
		panelMenuBotoes.add(btnCadVenda);

		icone = new ImageIcon(new ImageIcon(getClass().getResource("/img/client.png")).getImage()
				.getScaledInstance(72, 72, java.awt.Image.SCALE_SMOOTH));
		btnCadCliente = new JButton();
		btnCadCliente.setIcon(icone);
		btnCadCliente.setBackground(Color.GRAY);
		btnCadCliente.setBounds(82, 5, 68, 68);
		order.add(btnCadCliente);
		panelMenuBotoes.add(btnCadCliente);

		icone = new ImageIcon(new ImageIcon(getClass().getResource("/img/icons8-pet-128.png")).getImage()
				.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		btnCadPet = new JButton();
		btnCadPet.setBackground(Color.GRAY);
		btnCadPet.setIcon(icone);
		btnCadPet.setBounds(152, 5, 68, 68);
		order.add(btnCadPet);
		panelMenuBotoes.add(btnCadPet);

		icone = new ImageIcon(new ImageIcon(getClass().getResource("/img/icons8-pet-food-64.png")).getImage()
				.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
		btnOutro = new JButton();
		btnOutro.setIcon(icone);
		btnOutro.setBackground(Color.GRAY);
		btnOutro.setBounds(222, 5, 68, 68);
		order.add(btnOutro);
		panelMenuBotoes.add(btnOutro);

		icone = new ImageIcon(new ImageIcon(getClass().getResource("/img/annual-report.png")).getImage()
				.getScaledInstance(56, 56, java.awt.Image.SCALE_SMOOTH));
		btnRelatorio = new JButton();
		btnRelatorio.setIcon(icone);
		btnRelatorio.setBackground(Color.GRAY);
		btnRelatorio.setBounds(342, 5, 68, 68);
		order.add(btnRelatorio);
		panelMenuBotoes.add(btnRelatorio);
		
		icone = new ImageIcon(new ImageIcon(getClass().getResource("/img/pets.png")).getImage()
				.getScaledInstance(72, 72, java.awt.Image.SCALE_SMOOTH));
		lblPetshop = new JLabel("PetShop ");
		lblPetshop.setIcon(icone);
		lblPetshop.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPetshop.setHorizontalAlignment(SwingConstants.LEFT);
		lblPetshop.setForeground(Color.WHITE);
		lblPetshop.setFont(new Font("Dialog", Font.BOLD, 32));
		lblPetshop.setBounds(getSize().width - 240, 0, 240, 79);

		panelMenuBotoes.add(lblPetshop);

		add(panelMenuBotoes);

		panelMenuBotoes.setFocusTraversalPolicy(new OwnFocusTraversalPolicy(order));
	}

	public JButton getBtnCadVenda() {
		return btnCadVenda;
	}

	public void setBtnCadVenda(JButton btnCadVenda) {
		this.btnCadVenda = btnCadVenda;
	}

	public JButton getBtnCadCliente() {
		return btnCadCliente;
	}

	public void setBtnCadCliente(JButton btnCadCliente) {
		this.btnCadCliente = btnCadCliente;
	}

	public JButton getBtnCadPet() {
		return btnCadPet;
	}

	public void setBtnCadPet(JButton btnCadPet) {
		this.btnCadPet = btnCadPet;
	}

	public JButton getBtnOutro() {
		return btnOutro;
	}

	public void setBtnOutro(JButton btnOutro) {
		this.btnOutro = btnOutro;
	}

	public JLabel getLblPetshop() {
		return lblPetshop;
	}
	
	public JButton getBtnRelatorio() {
		return btnRelatorio;
	}

	public void setBtnRelatorio(JButton btnRelatorio) {
		this.btnRelatorio = btnRelatorio;
	}

	public void painelClientes() {
		panelClientes = new JPanel();
		panelClientes.setBackground(Color.GRAY);
		panelClientes.setBorder(BorderFactory.createEtchedBorder());
		panelClientes.setLayout(null);
		panelClientes.setBounds(0, 80, getSize().width, 60);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setBounds(15, 30, 160, 33);
		panelClientes.add(lblClientes);
		add(panelClientes);
		    
		tblClientes = new JTable();
		tblClientes.setFont(new Font(null, Font.PLAIN, 16));
		tblClientes.setRowHeight(28);
		tblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblClientes.setSelectionBackground(new Color(151, 195, 243));
		tblClientes.setSelectionForeground(Color.BLACK);

		tblClientes.getTableHeader().setReorderingAllowed(false);
		
		scrollClientes = new JScrollPane(tblClientes);
		scrollClientes.setBounds(12, 155, getSize().width - 28, (getSize().height / 2) - 143);
		order.add(tblClientes);

		add(scrollClientes);
	}

	public JTable getTblClientes() {
		return tblClientes;
	}

	public void setTblClientes(JTable tblClientes) {
		this.tblClientes = tblClientes;
	}
	
	public void resizeColumnsTableClientes() {		
		tblClientes.getColumnModel().getColumn(0).setPreferredWidth((int)((scrollClientes.getWidth() * 8)/100));   //8
		tblClientes.getColumnModel().getColumn(1).setPreferredWidth((int)((scrollClientes.getWidth() * 44)/100)); //44
		tblClientes.getColumnModel().getColumn(2).setPreferredWidth((int)((scrollClientes.getWidth() * 17)/100));// 17
		tblClientes.getColumnModel().getColumn(3).setPreferredWidth((int)((scrollClientes.getWidth() * 31)/100)); //3
	}

	public void painelPets() {
		panelPets = new JPanel();
		panelPets.setBounds(0, (getSize().height / 2) + 28, getSize().width, 60);
		panelPets.setBackground(Color.GRAY);
		panelPets.setBorder(BorderFactory.createEtchedBorder());
		panelPets.setLayout(null);

		JLabel lblPets = new JLabel("Pets");
		lblPets.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPets.setForeground(Color.WHITE);
		lblPets.setBounds(15, 27, 123, 39);
		panelPets.add(lblPets);
		add(panelPets);

		tblPets = new JTable();
		tblPets.setFont(new Font(null, Font.PLAIN, 16));
		tblPets.setRowHeight(28);
		tblPets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPets.setSelectionBackground(new Color(151, 195, 243));
		tblPets.setSelectionForeground(Color.BLACK);
		
		scrollPets = new JScrollPane(tblPets);
		scrollPets.setBounds(12, (getSize().height / 2) + 103, getSize().width - 28, (getSize().height / 2) - 175);
		order.add(tblPets);

		add(scrollPets);
	}

	public JTable getTblPets() {
		return tblPets;
	}

	public void setTblPets(JTable tblPets) {
		this.tblPets = tblPets;
	}

	public ComponentAdapter componentAdapter() {
		return new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panelMenuBotoes.setVisible(false);
				panelClientes.setVisible(false);
				scrollClientes.setVisible(false);
				panelPets.setVisible(false);
				scrollPets.setVisible(false);

				panelMenuBotoes.setBounds(0, 0, getSize().width, 79);
				lblPetshop.setBounds(getSize().width - 240, 0, 240, 79);
				panelClientes.setBounds(0, 80, getSize().width, 60);
				scrollClientes.setBounds(12, 155, getSize().width - 28, (getSize().height / 2) - 143);
				panelPets.setBounds(0, (getSize().height / 2) + 28, getSize().width, 60);
				scrollPets.setBounds(12, (getSize().height / 2) + 103, getSize().width - 28, (getSize().height / 2) - 175);
				
				panelMenuBotoes.setVisible(true);
				panelClientes.setVisible(true);
				scrollClientes.setVisible(true);
				panelPets.setVisible(true);
				scrollPets.setVisible(true);
			}
		};
	}
}
