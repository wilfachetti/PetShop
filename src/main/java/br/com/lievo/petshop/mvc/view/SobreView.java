package br.com.lievo.petshop.mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SobreView extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnFechar;
	
	public SobreView() {	
		setTitle("Sobre PetShop");
		setBounds(0, 0, 574, 582);
		getContentPane().setLayout(null);		
		setLocationRelativeTo(null); 		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.GRAY);
		panelTitulo.setBounds(0, 0, 574, 75);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblConfiguraesBancoDe = new JLabel(" Sobre a aplicação PetShop");
		lblConfiguraesBancoDe.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConfiguraesBancoDe.setForeground(Color.WHITE);
		
		panelTitulo.add(lblConfiguraesBancoDe);
		getContentPane().add(panelTitulo);
		
		btnFechar = new JButton("Fechar");		
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setBackground(Color.GRAY);
		btnFechar.setFont(new Font("Dialog", Font.PLAIN, 18));
		//btnFechar.setBounds(427, 505, 135, 32);
		btnFechar.setBounds(220, 504, 135, 32);

		btnFechar.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(btnFechar);
		
		ImageIcon icone = new ImageIcon(new ImageIcon(AplicacaoView.class.getResource("/img/pets.png")).getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)); 
		JLabel label = new JLabel();
		label.setIcon(icone);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);		
		label.setBounds(115, 76, 356, 314);
		getContentPane().add(label);
		
		JLabel lblDizeres = new JLabel("<html><center>\nAplicação desenvolvida com fins educacionais <br>para estudos em Padrões de Projetos<br/><br>\nby Willian Fachetti<br/></center>\n</html>\n\n");
		lblDizeres.setForeground(Color.WHITE);
		lblDizeres.setBackground(Color.GRAY);
		lblDizeres.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDizeres.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDizeres.setHorizontalAlignment(SwingConstants.CENTER);
		//lblDizeres.setBounds(0, 389, 574, 160);
		lblDizeres.setBounds(0, 367, 574, 160);
		getContentPane().add(lblDizeres);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 389, 574, 160);		
		getContentPane().add(panel);
	}

	public JButton getBtnFechar() {
		return btnFechar;
	}

}
