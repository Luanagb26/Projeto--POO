package floricultura.app.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import floricultura.app.exception.EmailNotFilledException;
import floricultura.app.exception.NameNotFilledException;
//import floricultura.app.exception.NotCompatibleException;
import floricultura.app.exception.PasswordNotFilledException;
import floricultura.app.model.Conta;
import floricultura.app.persistencia.UserDAO;
import floricultura.app.exception.ConfirmPasswordNotFilledException;

import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaCadastro extends JFrame{
	private JMenuBar barraMenu;
	private JMenu menu;


	
	
	private JPanel panelForm;
	private JLabel lbNome;
	private JLabel lbEmail;
	private JLabel lbSenha;
	//private JLabel lbConfirmarSenha;
	
	private JTextField txfNome;
	private JTextField txfEmail;
	private JTextField txfSenha;
	//private JTextField txfConfirmarSenha;
	
	private JPanel panelBotoes;
	private JButton btnSalvar;
	private JButton btnFechar;
	
	public TelaCadastro() 
	{
		setTitle("Cadastro");
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
		lbNome = new JLabel("Nome: ");
		lbEmail = new JLabel("Email: ");
		lbSenha = new JLabel("Senha: ");
		//lbConfirmarSenha = new JLabel("Confirmar Senha: ");
		
		txfNome = new JTextField(24);
		txfEmail = new JTextField(24);
		txfSenha = new JTextField(15);
		//txfConfirmarSenha = new JTextField(15);
		
		panelForm.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panelForm.add(lbNome);
		panelForm.add(txfNome);
		
		panelForm.add(lbEmail);
		panelForm.add(txfEmail);
		
		panelForm.add(lbSenha);
		panelForm.add(txfSenha);
		
//		panelForm.add(lbConfirmarSenha);
//		panelForm.add(txfConfirmarSenha);
		
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}

	private void criarMenu() {
		// TODO Auto-generated method stub
		barraMenu = new JMenuBar();
		menu = new JMenu("Cadastro");
		
		
		barraMenu.add(menu);
		
		
		getContentPane().add(barraMenu, BorderLayout.NORTH);
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
		txfNome.setText("");
		txfEmail.setText("");
		txfSenha.setText("");
		//txfConfirmarSenha.setText("");
	}
// --------------------------------------------------------------------------
		private class SalvarAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					UserDAO.getInstace().adicionarConta(new Conta(0, txfNome.getText(), txfEmail.getText(), txfSenha.getText()));
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
					apagarCampos();
					
				} 
				catch (NameNotFilledException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
				catch (EmailNotFilledException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
				catch (PasswordNotFilledException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
				catch (ConfirmPasswordNotFilledException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
//				catch (NotCompatibleException e1) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, e1.getMessage());
//					
//				}
			}
			
		}
		
		private class FecharAction implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		}
}
		// --------------------------------------------------------------------------