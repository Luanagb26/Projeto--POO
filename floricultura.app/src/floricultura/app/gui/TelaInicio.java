package floricultura.app.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import javax.swing.JPanel;

import javax.swing.JButton;

public class TelaInicio extends JFrame{
	private JMenuBar barraMenu;
	private JMenu menu;
	
	private JMenuItem mItemCadastro;
	private JMenuItem mItemLogin;
	private JMenuItem mItemSair;
	
	private JPanel panelBotoes;
	private JButton btnFechar;
	
	public TelaInicio() 
	{
		setTitle("Inicio");
		setSize(340, 240);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		criarMenu();
		
	}
	private void carregarBotoes() {
		// TODO Auto-generated method stub
		panelBotoes = new JPanel();
		panelBotoes.setLayout(
				new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new FecharAction());
		
		panelBotoes.add(btnFechar);
	
		getContentPane().add(panelBotoes, 
				BorderLayout.SOUTH);
	}

	private void criarMenu() {
		// TODO Auto-generated method stub
		barraMenu = new JMenuBar();
		menu = new JMenu("Inicio");
		mItemLogin = new JMenuItem("Login");
		mItemCadastro = new JMenuItem("Cadastro");
		mItemSair = new JMenuItem("Sair");
		
		barraMenu.add(menu);
		menu.add(mItemLogin);
		menu.add(mItemCadastro);
		menu.add(mItemSair);
		mItemLogin.addActionListener(new AbrirLogAction());
		mItemCadastro.addActionListener(new AbrirCadAction());
		mItemSair.addActionListener(new FecharAction());
		getContentPane().add(barraMenu, BorderLayout.NORTH);
	}

	
// --------------------------------------------------------------------------
		private class AbrirCadAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				TelaCadastro tCad = new TelaCadastro();
				tCad.setVisible(true);
			}
		}
		private class AbrirLogAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				TelaLogin tLog = new TelaLogin();
				tLog.setVisible(true);
			}
		}
		
		private class FecharAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		}
		
}