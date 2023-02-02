package floricultura.app.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import floricultura.app.exception.EmailNotFilledException;
import floricultura.app.exception.NameNotFilledException;
import floricultura.app.exception.NotCompatibleException;
import floricultura.app.exception.PasswordNotFilledException;
import floricultura.app.model.Conta;
import floricultura.app.model.Planta;
import floricultura.app.persistencia.FloriculturaDAO;
import floricultura.app.persistencia.UserDAO;
import floricultura.app.exception.ConfirmPasswordNotFilledException;

import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaLogin extends JFrame{
	private JMenuBar barraMenu;
	private JMenu menu;


	
	
	private JPanel panelForm;
	private JLabel lbEmail;
	private JLabel lbSenha;
	
	
	private JTextField txfEmail;
	private JTextField txfSenha;
	
	
	private JPanel panelBotoes;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	
	public TelaLogin() 
	{
		setTitle("Log in");
		setSize(340, 240);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		criarMenu();
		criarFormulario();
		carregarBotoes();
		
	}

	private void criarFormulario() {
		// TODO Auto-generated method stub
		panelForm = new JPanel();
		
		lbEmail = new JLabel("Email: ");
		lbSenha = new JLabel("Senha: ");

		txfEmail = new JTextField(24);
		txfSenha = new JTextField(15);
		
		panelForm.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panelForm.add(lbEmail);
		panelForm.add(txfEmail);
		
		panelForm.add(lbSenha);
		panelForm.add(txfSenha);
		
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}

	private void criarMenu() {
		// TODO Auto-generated method stub
		barraMenu = new JMenuBar();
		menu = new JMenu("Cadastro");
		
		
		barraMenu.add(menu);
		
		
	
	}

	private void carregarBotoes() {
		// TODO Auto-generated method stub
		panelBotoes = new JPanel();
		panelBotoes.setLayout(
				new FlowLayout(FlowLayout.CENTER, 10, 10));
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ConfirmarAction());
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CancelarAction());
		panelBotoes.add(btnConfirmar);
		panelBotoes.add(btnCancelar);
		
		getContentPane().add(panelBotoes, 
				BorderLayout.SOUTH);
	}
	
	public void apagarCampos() {
		txfEmail.setText("");
		txfSenha.setText("");
	}
// --------------------------------------------------------------------------
		private class ConfirmarAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					ResultSet rsUserDao = UserDAO.getInstace().logarConta(new Conta(0, txfEmail.getText(), txfSenha.getText()));
					try {
						if(rsUserDao.next()) {
							TelaFloricultura tFlor = new TelaFloricultura();
							tFlor.setVisible(true);
							JOptionPane.showMessageDialog(null, "Log in feito com sucesso!");
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Email ou senha incorretos.");
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				} 
				catch (EmailNotFilledException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
				catch (PasswordNotFilledException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
			}
			
		}
		
		private class CancelarAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		}
	
}
		// --------------------------------------------------------------------------
	