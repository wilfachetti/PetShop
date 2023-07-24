package br.com.lievo.petshop.mvc.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import br.com.lievo.petshop.mvc.view.SobreView;

public class SobreController {
	
	private SobreView sobreView;	

	public SobreController(SobreView sobreView) {		
		this.sobreView = sobreView;		
		
		this.sobreView.getBtnFechar().addActionListener(e -> cliqueBtnFechar());		
		this.sobreView.addWindowFocusListener(getPerdaFocoJanela());
	}
	
	public void iniciarController() {
    	sobreView.setVisible(true);	
	}
	
	public WindowFocusListener getPerdaFocoJanela() {
		return new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
			}
			public void windowLostFocus(WindowEvent e) {
				cliqueBtnFechar();
			}
		};
	}
	
	public void cliqueBtnFechar() {
		sobreView.dispose();
	}
}
