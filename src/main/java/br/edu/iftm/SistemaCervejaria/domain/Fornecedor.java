package br.edu.iftm.SistemaCervejaria.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="TB_FORNECEDOR")
@XmlRootElement

public class Fornecedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//código do fornecedor.
	@Column(name="CD_FORNECEDOR")
	private Integer id;
	
	@Column(name="NM_FORNECEDOR",nullable=false,length=200)
	private String nome;
	
	@Column(name="NM_RESPONSAVEL",nullable=false,length=200)
	private String responsavel;
	
	@Column(name="TELEFONE",nullable=false,length=200)
	private String telefone;
	
	@Column(name="EMAIL",nullable=false,length=200)
	private String email;
	
	@ManyToMany(mappedBy="cervejas")
	private List<Cerveja> cervejas;

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

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cerveja> getCervejas() {
		return cervejas;
	}

	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}
	
	
	
	
	

}
