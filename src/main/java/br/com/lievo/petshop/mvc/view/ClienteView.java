package br.com.lievo.petshop.mvc.view;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import br.com.lievo.petshop.util.OwnFocusTraversalPolicy;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ClienteView extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private JLabel lblTitulo;
	private JTextField txfNome, txfCpf, txfRg, txfDataNascimento, txfCelular, txfTelefone, txfEmail, txfLogradouro, txfNumero, txfComplemento, txfBairro, txfMunicipio, txfUf, txfCep;
	private JRadioButton rbMasculino, rbFeminino;
	private JButton btnSalvar, btnCancelar;

	public ClienteView() {
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 752);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setModal(true);
		setTitle("Novo Cadastro Cliente");		
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.GRAY);
		panelTitulo.setBounds(0, 0, 773, 93);
		panelTitulo.setLayout(null); 
		getContentPane().add(panelTitulo);
		
		lblTitulo = new JLabel("Cadastrar Cliente");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 24));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(15, 0, 254, 95);
		panelTitulo.add(lblTitulo);

		ImageIcon icone = new ImageIcon(new ImageIcon(AplicacaoView.class.getResource("/img/client.png")).getImage().getScaledInstance(96, 96, java.awt.Image.SCALE_SMOOTH)); 
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(icone);
		lblImage.setBounds(655, 0, 83, 91);
		panelTitulo.add(lblImage);
		
		Vector<Component> order = new Vector<>();

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNome.setBounds(168, 109, 70, 21);
		getContentPane().add(lblNome);
		
		txfNome = new JTextField();
		txfNome.setBounds(252, 105, 485, 28);
		txfNome.setFont(new Font("Dialog", Font.PLAIN, 18));
		getContentPane().add(txfNome);
		order.add(txfNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(168, 152, 70, 15);
		getContentPane().add(lblCpf);
		
		txfCpf = new JTextField();
		txfCpf.setBounds(252, 145, 223, 28);
		txfCpf.setFont(new Font("Dialog", Font.PLAIN, 18));
		getContentPane().add(txfCpf);
		order.add(txfCpf);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRg.setBounds(483, 150, 29, 19);
		getContentPane().add(lblRg);
		
		txfRg = new JTextField();
		txfRg.setBounds(526, 145, 211, 28);
		txfRg.setFont(new Font("Dialog", Font.PLAIN, 18));
		getContentPane().add(txfRg);
		order.add(txfRg);
		
		JLabel lblGenero = new JLabel("Gênero");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGenero.setBounds(156, 195, 80, 15);
		getContentPane().add(lblGenero);
		
		rbFeminino = new JRadioButton("Feminino", true);
		rbFeminino.setBounds(250, 191, 124, 23);
		rbFeminino.setFont(new Font("Dialog", Font.BOLD, 18));
		order.add(rbFeminino);	
		getContentPane().add(rbFeminino);		

		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(378, 191, 146, 23);
		rbMasculino.setFont(new Font("Dialog", Font.BOLD, 18));
		getContentPane().add(rbMasculino);
				
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rbFeminino);
		buttonGroup.add(rbMasculino);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDeNascimento.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDataDeNascimento.setBounds(12, 239, 226, 15);
		getContentPane().add(lblDataDeNascimento);		
		
		txfDataNascimento = new JTextField();
		txfDataNascimento.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfDataNascimento.setBounds(252, 232, 223, 28);
		getContentPane().add(txfDataNascimento);
		order.add(txfDataNascimento);
		
		Border lineBorder = BorderFactory.createLineBorder(Color.lightGray);

		JPanel panelContato = new JPanel();
		panelContato.setBorder(javax.swing.BorderFactory.createTitledBorder(lineBorder, " Contato ", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 18), null)); 
		panelContato.setLayout(null);
		panelContato.setBounds(22, 289, 727, 127);
		getContentPane().add(panelContato);
		
		txfCelular = new JTextField();
		txfCelular.setBounds(193, 41, 184, 28);
		txfCelular.setFont(new Font("Dialog", Font.PLAIN, 18));
		panelContato.add(txfCelular);
		order.add(txfCelular);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTelefone.setBounds(380, 48, 91, 15);
		panelContato.add(lblTelefone);
		
		txfTelefone = new JTextField();
		txfTelefone.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfTelefone.setBounds(479, 41, 223, 28);
		panelContato.add(txfTelefone);
		order.add(txfTelefone);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEmail.setBounds(94, 81, 81, 31);
		panelContato.add(lblEmail);
		
		txfEmail = new JTextField();
		txfEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfEmail.setBounds(193, 82, 509, 28);		
		panelContato.add(txfEmail);
		order.add(txfEmail);	
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(94, 40, 81, 31);
		panelContato.add(lblCelular);
		lblCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCelular.setFont(new Font("Dialog", Font.BOLD, 18));
		
		JPanel panelEndereco = new JPanel();
		panelEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(lineBorder, " Endereço ", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 18), null)); 
		panelEndereco.setLayout(null);
		panelEndereco.setBounds(22, 433, 727, 213);
		getContentPane().add(panelEndereco);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(47, 41, 127, 31);
		lblLogradouro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogradouro.setFont(new Font("Dialog", Font.BOLD, 18));
		panelEndereco.add(lblLogradouro);
		
		txfLogradouro = new JTextField();
		txfLogradouro.setBounds(192, 42, 333, 28);
		txfLogradouro.setFont(new Font("Dialog", Font.PLAIN, 18));
		panelEndereco.add(txfLogradouro);
		order.add(txfLogradouro);
		
		JLabel lblNumero = new JLabel("Número");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNumero.setBounds(535, 49, 91, 15);
		panelEndereco.add(lblNumero);
		
		txfNumero = new JTextField();
		txfNumero.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfNumero.setBounds(634, 42, 69, 28);
		panelEndereco.add(txfNumero);
		order.add(txfNumero);
		
		JLabel tblComplemento = new JLabel("Complemento");
		tblComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		tblComplemento.setFont(new Font("Dialog", Font.BOLD, 18));
		tblComplemento.setBounds(36, 84, 138, 31);
		panelEndereco.add(tblComplemento);
		
		txfComplemento = new JTextField();
		txfComplemento.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfComplemento.setBounds(192, 84, 511, 28);
		panelEndereco.add(txfComplemento);
		order.add(txfComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBairro.setBounds(47, 127, 127, 31);
		panelEndereco.add(lblBairro);
		
		txfBairro = new JTextField();
		txfBairro.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfBairro.setBounds(192, 128, 156, 28);
		panelEndereco.add(txfBairro);
		order.add(txfBairro);
		
		JLabel lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMunicipio.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMunicipio.setBounds(352, 135, 116, 15);
		panelEndereco.add(lblMunicipio);
		
		txfMunicipio = new JTextField();
		txfMunicipio.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfMunicipio.setBounds(483, 128, 220, 28);
		panelEndereco.add(txfMunicipio);
		order.add(txfMunicipio);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUf.setBounds(121, 170, 53, 31);
		panelEndereco.add(lblUf);
		
		txfUf = new JTextField();
		txfUf.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfUf.setBounds(192, 171, 273, 28);
		panelEndereco.add(txfUf);
		order.add(txfUf);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCep.setBounds(461, 178, 53, 15);
		panelEndereco.add(lblCep);
		
		txfCep = new JTextField();
		txfCep.setFont(new Font("Dialog", Font.PLAIN, 18));
		txfCep.setBounds(524, 171, 179, 28);
		panelEndereco.add(txfCep);
		order.add(txfCep);
		
		JPanel panelBotton = new JPanel();
		panelBotton.setBackground(Color.GRAY);		
		panelBotton.setBounds(0, 660, 773, 60);
		panelBotton.setLayout(null);
		getContentPane().add(panelBotton);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(Color.GRAY);
		btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSalvar.setBounds(611, 16, 135, 32);
		panelBotton.add(btnSalvar);
		order.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnCancelar.setBounds(464, 16, 135, 32);
		panelBotton.add(btnCancelar);
		order.add(btnCancelar);
		
		setFocusTraversalPolicy(new OwnFocusTraversalPolicy(order));
		
	}
	
	public void setLblTitulo(String titulo) {
		lblTitulo.setText(titulo);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public JTextField getTxfNome() {
		return txfNome;
	}

	public void setTxfNome(JTextField txfNome) {
		this.txfNome = txfNome;
	}

	public JTextField getTxfCpf() {
		return txfCpf;
	}

	public void setTxfCpf(JTextField txfCpf) {
		this.txfCpf = txfCpf;
	}

	public JTextField getTxfRg() {
		return txfRg;
	}

	public void setTxfRg(JTextField txfRg) {
		this.txfRg = txfRg;
	}
	
	public boolean getGenero() {
		return rbFeminino.isSelected();
	}

	public void setGenero(boolean genero) {
		if(genero)
			rbFeminino.setSelected(true);
		else
			rbMasculino.setSelected(true);				
	}

	public JTextField getTxfDataNascimento() {
		return txfDataNascimento;
	}

	public void setTxfDataNascimento(JTextField txfDataNascimento) {
		this.txfDataNascimento = txfDataNascimento;
	}

	public JTextField getTxfCelular() {
		return txfCelular;
	}

	public void setTxfCelular(JTextField txfCelular) {
		this.txfCelular = txfCelular;
	}

	public JTextField getTxfTelefone() {
		return txfTelefone;
	}

	public void setTxfTelefone(JTextField txfTelefone) {
		this.txfTelefone = txfTelefone;
	}

	public JTextField getTxfEmail() {
		return txfEmail;
	}

	public void setTxfEmail(JTextField txfEmail) {
		this.txfEmail = txfEmail;
	}

	public JTextField getTxfLogradouro() {
		return txfLogradouro;
	}

	public void setTxfLogradouro(JTextField txfLogradouro) {
		this.txfLogradouro = txfLogradouro;
	}

	public JTextField getTxfNumero() {
		return txfNumero;
	}

	public void setTxfNumero(JTextField txfNumero) {
		this.txfNumero = txfNumero;
	}

	public JTextField getTxfComplemento() {
		return txfComplemento;
	}

	public void setTxfComplemento(JTextField txfComplemento) {
		this.txfComplemento = txfComplemento;
	}

	public JTextField getTxfBairro() {
		return txfBairro;
	}

	public void setTxfBairro(JTextField txfBairro) {
		this.txfBairro = txfBairro;
	}

	public JTextField getTxfMunicipio() {
		return txfMunicipio;
	}

	public void setTxfMunicipio(JTextField txfMunicipio) {
		this.txfMunicipio = txfMunicipio;
	}

	public JTextField getTxfUf() {
		return txfUf;
	}

	public void setTxfUf(JTextField txfUf) {
		this.txfUf = txfUf;
	}

	public JTextField getTxfCep() {
		return txfCep;
	}

	public void setTxfCep(JTextField txfCep) {
		this.txfCep = txfCep;
	}

	public JRadioButton getRbMasculino() {
		return rbMasculino;
	}

	public void setRbMasculino(JRadioButton rbMasculino) {
		this.rbMasculino = rbMasculino;
	}

	public JRadioButton getRbFeminino() {
		return rbFeminino;
	}

	public void setRbFeminino(JRadioButton rbFeminino) {
		this.rbFeminino = rbFeminino;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
}
