package br.edu.iftm.SistemaCervejaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.SistemaCervejaria.domain.Fornecedor;


public class FornecedorDao {
	@PersistenceContext(name="SistemaExtensaoPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> getFornecedores() {
		Query query = entityManager.createQuery("from Fornecedor f");
		return query.getResultList();
	}
	
	public Fornecedor getFornecedorId(Integer id) {
		return entityManager.find(Fornecedor.class,id);
	}
	
	@Transactional
	public void excluirFornecedor(Integer id) {
		Fornecedor f = getFornecedorId(id);
		entityManager.remove(f);
	}
	
	@Transactional
	public void inserirFornecedor(Fornecedor fornecedor) {
		entityManager.persist(fornecedor);

	}
	
	@Transactional
	public void atualizarFornecedor(Fornecedor fornecedor) {
		fornecedor = entityManager.merge(fornecedor);
		entityManager.persist(fornecedor);
	}

}
