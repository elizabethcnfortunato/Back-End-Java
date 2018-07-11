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
@Table(name="TB_CERVEJA")
@XmlRootElement

public class Cerveja implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//código do fornecedor.
		@Column(name="CD_CERVEJA")
		private Integer id;
		
		@Column(name="ESTILO",nullable=false,length=200)
		private String estilo;
		
		@Column(name="TEORALCOOLICO",nullable=false,length=200)
		private String teoralcoolico;
		
		@Column(name="IBU",nullable=false,length=200)
		private String ibu;
		
		@Column(name="HISTORIA",nullable=false,length=200)
		private String historia;
		
		@Column(name="HARMONIZACAO",nullable=false,length=200)
		private String harmonizacao;
		
		@ManyToOne
		@JoinColumn(name="FORNECEDOR",referencedColumnName="CD_FORNECEDOR")
		private Fornecedor fornecedor;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getEstilo() {
			return estilo;
		}

		public void setEstilo(String estilo) {
			this.estilo = estilo;
		}

		public String getTeoralcoolico() {
			return teoralcoolico;
		}

		public void setTeoralcoolico(String teoralcoolico) {
			this.teoralcoolico = teoralcoolico;
		}

		public String getIbu() {
			return ibu;
		}

		public void setIbu(String ibu) {
			this.ibu = ibu;
		}

		public String getHistoria() {
			return historia;
		}

		public void setHistoria(String historia) {
			this.historia = historia;
		}

		public String getHarmonizacao() {
			return harmonizacao;
		}

		public void setHarmonizacao(String harmonizacao) {
			this.harmonizacao = harmonizacao;
		}

		public Fornecedor getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(Fornecedor fornecedor) {
			this.fornecedor = fornecedor;
		}
		
	
		

}
