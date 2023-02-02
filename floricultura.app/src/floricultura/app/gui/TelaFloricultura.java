package floricultura.app.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import floricultura.app.exception.NameNotFilledException;
import floricultura.app.model.Planta;
import floricultura.app.persistencia.FloriculturaDAO;

import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaFloricultura extends JFrame{
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenu menuSobre;
	private JMenuItem mItemHome;
	private JMenuItem mItemSair;
	
	private JPanel panelForm;
	private JLabel lbNomePopular;
	private JLabel lbNomeCientífico;
	private JLabel lbDescricao;
	
	private JTextField txfNomePopular;
	private JTextField txfNomeCientifico;
	private JTextField txfDescricao;
	
	private JPanel panelBotoes;
	private JButton btnSalvar;
	private JButton btnFechar;
	
	public TelaFloricultura() 
	{
		setTitle("Minhas Plantinhas");
		setSize(340, 240);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		criarMenu();
		criarFormulario();
		carregarBotoes();
		
	}

	private void carregarBotoes() {
		// TODO Auto-generated method stub
		panelBotoes = new JPanel();
		panelBotoes.setLayout(
				new FlowLayout(FlowLayout.CENTER, 10, 10));
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new SalvarAction());
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new FecharAction());
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnFechar);
		
		getContentPane().add(panelBotoes, 
				BorderLayout.SOUTH);
	}
	
	public void apagarCampos() {
		txfNomePopular.setText("");
		txfNomeCientifico.setText("");
		txfDescricao.setText("");
	}

	private void criarFormulario() {
		// TODO Auto-generated method stub
		panelForm = new JPanel();
		lbNomePopular = new JLabel("Nome Popular: ");
		lbNomeCientífico = new JLabel("Nome Científico: ");
		lbDescricao = new JLabel("Descrição: ");
		
		txfNomePopular = new JTextField(24);
		txfNomeCientifico = new JTextField(24);
		txfDescricao = new JTextField(15);
		
		panelForm.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panelForm.add(lbNomePopular);
		panelForm.add(txfNomePopular);
		
		panelForm.add(lbNomeCientífico);
		panelForm.add(txfNomeCientifico);
		
		panelForm.add(lbDescricao);
		panelForm.add(txfDescricao);
		
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}

	private void criarMenu() {
		// TODO Auto-generated method stub
		barraMenu = new JMenuBar();
		menu = new JMenu("Floricultura");
		menuSobre = new JMenu("Sobre");
		mItemHome = new JMenuItem("Home");
		mItemSair = new JMenuItem("Sair");
		
		barraMenu.add(menu);
		barraMenu.add(menuSobre);
		
		menu.add(mItemHome);
		menu.add(mItemSair);
		mItemHome.addActionListener(new AbrirHomeAction());
		mItemSair.addActionListener(new AbrirLogAction());

		getContentPane().add(barraMenu, BorderLayout.NORTH);
	}
	// --------------------------------------------------------------------------
		private class SalvarAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					FloriculturaDAO.getInstace().adicionar(new Planta(0, txfNomePopular.getText(), txfNomeCientifico.getText(), txfDescricao.getText()));
					JOptionPane.showMessageDialog(null, "Planta catalogada com sucesso");
					apagarCampos();
					
				} catch (NameNotFilledException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			
		}		
		private class FecharAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		}
		private class AbrirHomeAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				TelaHome tHome = new TelaHome();
				tHome.setVisible(true);
			}
		}
		private class AbrirLogAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				TelaLogin tLog = new TelaLogin();
				tLog.setVisible(true);
			}
		}
		// --------------------------------------------------------------------------
}

