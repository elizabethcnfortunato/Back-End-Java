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
@Table(name="TB_CASCO")
@XmlRootElement

public class Cascos implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//código do fornecedor.
		@Column(name="CD_CASCO") // AQUI POSSO PUCHAR O CODIGO DO CLIENTE
		private Integer id;
	
		@ManyToOne
		@JoinColumn(name="NM_CLIENTE",referencedColumnName="CD_CLIENTE")
		private Cliente cliente;
		
		//@Column(name="NM_CLIENTE",nullable=false,length=200) // AQUI POSSO PUXAR O NOME DO CLIENTE
		//private String nome;
		
		@Column(name="QTDGRANDE",nullable=false,length=200)
		private String qtdgrande;
		
		@Column(name="QTDPEQUENA",nullable=false,length=200)
		private String qtdpequena;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public String getQtdgrande() {
			return qtdgrande;
		}

		public void setQtdgrande(String qtdgrande) {
			this.qtdgrande = qtdgrande;
		}

		public String getQtdpequena() {
			return qtdpequena;
		}

		public void setQtdpequena(String qtdpequena) {
			this.qtdpequena = qtdpequena;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		
}
