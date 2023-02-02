package floricultura.app.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import floricultura.app.exception.ConfirmPasswordNotFilledException;
import floricultura.app.exception.EmailNotFilledException;
import floricultura.app.exception.NameNotFilledException;
import floricultura.app.exception.NotCompatibleException;
import floricultura.app.exception.PasswordNotFilledException;
import floricultura.app.model.Conta;
import floricultura.app.model.Planta;

public interface IPersistencia {
	public interface IPlanta{
	public void adicionar(Planta p) throws NameNotFilledException;
	public Planta localizar(String nomePopular);
	public void remover(Planta p);
	public void atualizar(Planta p);
	public List<Planta> listarPlantas() throws SQLException;
	}
	
	public interface IUser extends IPersistencia{
	public void adicionarConta(Conta c) throws NameNotFilledException,EmailNotFilledException,PasswordNotFilledException, ConfirmPasswordNotFilledException, NotCompatibleException;
	public ResultSet logarConta(Conta c) throws EmailNotFilledException, PasswordNotFilledException, NotCompatibleException;
	public Conta localizarConta(String nome);
	public void removerConta(Conta c);
	public void atualizarConta(Conta c);
	}
}
