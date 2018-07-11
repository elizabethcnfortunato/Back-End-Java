package br.edu.iftm.SistemaCervejaria.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TB_CLIENTE")
@XmlRootElement
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//código do fornecedor.
		@Column(name="CD_CLIENTE")
		private Integer id;
		
		@Column(name="NM_CLIENTE",nullable=false,length=200)
		private String nome;
		
		@Column(name="ENDERECO",nullable=false,length=200)
		private String endereco;
		
		@Column(name="TELEFONE",nullable=false,length=200)
		private String telefone;
		
	
		@ManyToMany
		@JoinTable(name="PREFERENCIAS",
	    		   joinColumns= @JoinColumn(name="CD_CERVEJA"),
	    		   inverseJoinColumns = @JoinColumn(name="ESTILO"))
		private List<Cerveja> cervejas;
		
		@ManyToMany
		@JoinTable(name="CASCOS",
	    		   joinColumns= @JoinColumn(name="QTDGRANDE"),
	    		   inverseJoinColumns = @JoinColumn(name="QTDPEQUENA"))
		private List<Cascos> cascos;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public List<Cerveja> getCervejas() {
			return cervejas;
		}

		public void setCervejas(List<Cerveja> cervejas) {
			this.cervejas = cervejas;
		}

		public List<Cascos> getCascos() {
			return cascos;
		}

		public void setCascos(List<Cascos> cascos) {
			this.cascos = cascos;
		}
		
		
		

}
