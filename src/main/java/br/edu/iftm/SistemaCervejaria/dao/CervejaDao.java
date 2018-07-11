package br.edu.iftm.SistemaCervejaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.SistemaCervejaria.domain.Cerveja;


public class CervejaDao {
	@PersistenceContext(name="SistemaExtensaoPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Cerveja> getCervejas() {
		Query query = entityManager.createQuery("from Cerveja c");
		return query.getResultList();
	}
	
	public Cerveja getCervejaId(Integer id) {
		return entityManager.find(Cerveja.class,id);
	}
	
	@Transactional
	public void excluirCerveja(Integer id) {
		Cerveja c = getCervejaId(id);
		entityManager.remove(c);
	}
	
	@Transactional
	public void inserirCerveja(Cerveja cerveja) {
		entityManager.persist(cerveja);

	}
	
	@Transactional
	public void atualizarCerveja(Cerveja cerveja) {
		cerveja = entityManager.merge(cerveja);
		entityManager.persist(cerveja);
	}


}
