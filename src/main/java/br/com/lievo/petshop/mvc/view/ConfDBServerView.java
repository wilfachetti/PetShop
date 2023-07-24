package br.com.lievo.petshop.mvc.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.com.lievo.petshop.util.OwnFocusTraversalPolicy;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;

public class ConfDBServerView extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txfPorta, txfIp;
	//private JFormattedTextField txfIp;
	private JButton btnSalvar, btnCancelar;
	
	public ConfDBServerView() {
		setTitle("Setup Database Manager");
		setBounds(0, 0, 574, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);		
		setResizable(false);        
        setModal(true);
        setLocationRelativeTo(null);        
				
		Vector<Component> order = new Vector<Component>();

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.GRAY);
		panelTitulo.setBounds(0, 0, 574, 93);
		panelTitulo.setLayout(null);
		
		JLabel lblConfiguracoes = new JLabel("Configurações Banco de Dados");
		lblConfiguracoes.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConfiguracoes.setForeground(Color.WHITE);
		lblConfiguracoes.setBounds(15, 0, 574, 95);
		panelTitulo.add(lblConfiguracoes);

		ImageIcon icone = new ImageIcon(new ImageIcon(AplicacaoView.class.getResource("/img/database.png")).getImage().getScaledInstance(76, 76, java.awt.Image.SCALE_SMOOTH)); 
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(icone);
		lblImage.setBounds(470, 2, 83, 91);
		panelTitulo.add(lblImage);

		add(panelTitulo);
				
		JLabel lblIp = new JLabel("IP");
		lblIp.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIp.setBounds(26, 116, 44, 19);
		add(lblIp);		
		
		/*
		MaskFormatter maskIP = null;
		try {
			maskIP = new MaskFormatter("###.###.###.###");
			maskIP.setPlaceholder("000.000.000.000");
	        maskIP.setValidCharacters("0123456789");
	        maskIP.setAllowsInvalid(false);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txfIp = new JFormattedTextField(maskIP);
		*/
		txfIp = new JTextField();
		txfIp.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfIp.setBounds(78, 111, 180, 28);
		add(txfIp);
		order.add(txfIp);
		
		JLabel lblPorta = new JLabel("Porta");
		lblPorta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPorta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPorta.setBounds(12, 166, 60, 19);
		add(lblPorta);
		
		txfPorta = new JTextField();
		txfPorta.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfPorta.setBounds(79, 161, 114, 28);
		add(txfPorta);
		order.add(txfPorta);		
		
		JPanel panelBotton = new JPanel();
		panelBotton.setBackground(Color.GRAY);		
		panelBotton.setBounds(0, 208, 574, 60);
		panelBotton.setLayout(null);
		add(panelBotton);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(Color.GRAY);
		btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSalvar.setBounds(420, 14, 135, 32);
		panelBotton.add(btnSalvar);
		order.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnCancelar.setBounds(270, 14, 135, 32);
		panelBotton.add(btnCancelar);
		order.add(btnCancelar);
		
		
		setFocusTraversalPolicy(new OwnFocusTraversalPolicy(order));
	}

	public JTextField getTxfIp() {
		return txfIp;
	}

	public void setTxfIp(JTextField txfIp) {
		this.txfIp = txfIp;
	}

	public JTextField getTxfPorta() {
		return txfPorta;
	}

	public void setTxfPorta(JTextField txfPorta) {
		this.txfPorta = txfPorta;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}	
}
