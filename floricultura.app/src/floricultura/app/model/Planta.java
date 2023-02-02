package floricultura.app.model;

import java.util.Objects;

public class Planta {

	private Integer id;
	private String nomePopular;
	private String nomeCientifico;
	private String descricao;
	
	public Planta(Integer id, String nomePopular, String nomeCientifico, String descricao) {
		super();
		this.id = id;
		this.nomePopular = nomePopular;
		this.nomeCientifico = nomeCientifico;
		this.descricao = descricao;
	}
	
	public Planta() {
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
		Planta other = (Planta) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePopular() {
		return nomePopular;
	}

	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}

	public String getNomeCientifico() {
		return nomeCientifico;
	}

	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Planta [id=" + id + ", nomePopular=" + nomePopular + ", nomeCientifico=" + nomeCientifico
				+ ", descricao=" + descricao + "]";
	}
	
	
	
}
