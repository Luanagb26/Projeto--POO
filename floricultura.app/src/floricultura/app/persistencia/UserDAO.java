package floricultura.app.persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import floricultura.app.exception.ConfirmPasswordNotFilledException;
import floricultura.app.exception.EmailNotFilledException;
import floricultura.app.exception.NameNotFilledException;
import floricultura.app.exception.NotCompatibleException;
import floricultura.app.exception.PasswordNotFilledException;
import floricultura.app.model.Conta;
import floricultura.app.model.Planta;
import floricultura.app.persistencia.IPersistencia.IUser;

public class UserDAO implements IUser {
	private IConnectionDB databaseMySQL;
	private static UserDAO instance;
	
	private UserDAO() {
		databaseMySQL = new DatabaseMySQL();
	}
	
	public static UserDAO getInstace() {
		if(instance == null)
			return new UserDAO();
		else
			return instance;
	}
	
	public void adicionarConta(Conta c) throws NameNotFilledException,EmailNotFilledException,PasswordNotFilledException,ConfirmPasswordNotFilledException  {
		System.out.println(c.getNome());
		
		if(c.getNome()== null || c.getNome().equalsIgnoreCase("")|| c.getNome().equalsIgnoreCase("\n")) {
			throw new NameNotFilledException("Por favor, informe o seu nome.");
		}
			
		System.out.println(c.getEmail());
		
		if(c.getEmail()== null || c.getEmail().equalsIgnoreCase("")|| c.getEmail().equalsIgnoreCase("\n")) {
				throw new EmailNotFilledException("Por favor, informe o seu email.");
			}
		System.out.println(c.getSenha());
		
		if(c.getSenha()== null || c.getSenha().equalsIgnoreCase("")|| c.getSenha().equalsIgnoreCase("\n")) {
				throw new PasswordNotFilledException("Por favor, informe o sua senha.");
//		}
//		System.out.println(c.getConfirmarSenha());
//		
//		if(c.getConfirmarSenha()== null || c.getConfirmarSenha().equalsIgnoreCase("")|| c.getConfirmarSenha().equalsIgnoreCase("\n")) {
//				throw new ConfirmPasswordNotFilledException("Por favor, confirme o sua senha.");
//		}
//		System.out.println(c.getConfirmarSenha());
//		if(c.getSenha()!=c.getConfirmarSenha()) {
//			throw new NotCompatibleException("As senhas não são iguais!");
//		
		
		}else{
			try {
				PreparedStatement pst = databaseMySQL.getConnection().prepareStatement("INSERT INTO USERS VALUES (?,?,?,?);");
				
				
				pst.setInt(1, c.getId());
				pst.setString(2, c.getNome());
				pst.setString(3, c.getEmail());
				pst.setString(4, c.getSenha());
				pst.execute();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public Conta localizarConta(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerConta(Conta c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarConta(Conta c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet logarConta(Conta c) throws EmailNotFilledException, PasswordNotFilledException{
		// TODO Auto-generated method stub
		System.out.println(c.getEmail());
		
		if(c.getEmail()== null || c.getEmail().equalsIgnoreCase("")|| c.getEmail().equalsIgnoreCase("\n")) {
				throw new EmailNotFilledException("Por favor, informe o seu email.");
			}
		System.out.println(c.getSenha());
		
		if(c.getSenha()== null || c.getSenha().equalsIgnoreCase("")|| c.getSenha().equalsIgnoreCase("\n")) {
				throw new PasswordNotFilledException("Por favor, informe o sua senha.");
		
		}else{
			try {
				String sql = "SELECT * FROM users WHERE email = ? AND senha = ?";
				PreparedStatement pst = databaseMySQL.getConnection().prepareStatement(sql);
				pst.setString(1, c.getEmail());
				pst.setString(2, c.getSenha());
				
				ResultSet rs = pst.executeQuery();
				return rs;
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
			
		
	}
	}
}
