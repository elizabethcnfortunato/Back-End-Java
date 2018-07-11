package br.edu.iftm.SistemaCervejaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;



import br.edu.iftm.SistemaCervejaria.domain.Cascos;

public class CascosDao {
	
	@PersistenceContext(name="SistemaExtensaoPU")
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	
	
	public List<Cascos> getCascos() {
		Query query = entityManager.createQuery("from Casco casc");
		return query.getResultList();
	}
	
	
	public Cascos getCascoId(Integer id) {
		return entityManager.find(Cascos.class,id);
	}
	
	@Transactional
	public void excluirCasco(Integer id) {
		Cascos casc = getCascoId(id);
		entityManager.remove(casc);
	}
	
	@Transactional
	public void inserirCasco(Cascos casc) {
		entityManager.persist(casc);

	}
	
	@Transactional
	public void atualizarCasco(Cascos casc) {
		casc = entityManager.merge(casc);
		entityManager.persist(casc);
	}

}
