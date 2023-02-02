 package floricultura.app.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import floricultura.app.exception.NameNotFilledException;

import floricultura.app.model.Planta;
import floricultura.app.persistencia.IPersistencia.IPlanta;

public class FloriculturaDAO implements IPlanta{
	private IConnectionDB databaseMySQL;
	private static FloriculturaDAO instance;
	
	private FloriculturaDAO() {
		databaseMySQL = new DatabaseMySQL();
	}
	
	public static FloriculturaDAO getInstace() {
		if(instance == null)
			return new FloriculturaDAO();
		else
			return instance;
	}
	//----------------------------------------------------------------------------------------------------------------------------------
	public void adicionar(Planta p) throws NameNotFilledException {
		System.out.println(p.getNomePopular());
		if(p.getNomePopular()== null || p.getNomePopular().equalsIgnoreCase("")|| p.getNomePopular().equalsIgnoreCase("\n")) {
			throw new NameNotFilledException("Por favor, informe o nome da planta.");
		
		}else {
			try {
				PreparedStatement ps = databaseMySQL.getConnection().prepareStatement("INSERT INTO CATALOGO VALUES (?,?,?,?);");
				
				ps.setInt(1, p.getId());
				ps.setString(2, p.getNomePopular());
				ps.setString(3, p.getNomeCientifico());
				ps.setString(4, p.getDescricao());
				ps.execute();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	public void insert(){};
    public void update(){};
    public void delete(){};
    
    public List<Planta> listarPlantas() throws SQLException{
         List<Planta> lista = new ArrayList <Planta>();
         PreparedStatement pst = this.databaseMySQL.getConnection().prepareStatement("SELECT * FROM catalogo");
         ResultSet rs = pst.executeQuery();
         while(rs.next()){
            Planta p = new Planta();
            p.setId(rs.getInt("id"));
            p.setNomePopular(rs.getString("nomePopular"));
            p.setNomeCientifico(rs.getString("nomeCientifico"));
            p.setDescricao(rs.getString("decricao"));
            
            lista.add(p);
         }
         rs.close();
         pst.close();
		return lista;
    }
    

	
	@Override
	public Planta localizar(String nomePopular) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Planta p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Planta p) {
		// TODO Auto-generated method stub
		
	}

	
	
}
