package br.com.lievo.petshop.app;

import java.awt.EventQueue;

import javax.swing.UIManager;

import br.com.lievo.petshop.mvc.controller.AplicacaoController;
import br.com.lievo.petshop.mvc.view.AplicacaoView;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class Principal {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					
					AplicacaoView appView = new AplicacaoView();
					AplicacaoController appController = new AplicacaoController(appView);
					
					appController.iniciarController();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
