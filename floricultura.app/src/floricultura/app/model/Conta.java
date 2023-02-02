package floricultura.app.model;

import java.util.Objects;

import javax.swing.JLabel;

public class Conta {
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String confirmarSenha;
	public Conta(Integer id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		
	}
	public Conta () {
		 
	 }
	public Conta(Integer id, String email, String senha) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.email = email;
		this.senha = senha;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	//------------ CONFIRMAAR SENHA ---------------
	public  String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	@Override
	public String toString() {
		return "Planta [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
}
