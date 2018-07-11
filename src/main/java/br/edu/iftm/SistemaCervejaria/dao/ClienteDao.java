//PACOTES
package br.edu.iftm.SistemaCervejaria.dao;

//IMPORTAÇÕES
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;

import br.edu.iftm.SistemaCervejaria.domain.Cliente;


public class ClienteDao {
	
	@PersistenceContext(name="SistemaExtensaoPU")
	private static EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	
	
	public List<Cliente> getClientes() {
		Query query = entityManager.createQuery("from Cliente cli");
		return query.getResultList();
	}
	
	
	public static Cliente getClienteId(Integer id) {
		return entityManager.find(Cliente.class,id);
	}
	
	@Transactional
	public void excluirCliente(Integer id) {
		Cliente cli = getClienteId(id);
		entityManager.remove(cli);
	}
	
	@Transactional
	public void inserirCliente(Cliente cliente) {
		entityManager.persist(cliente);

	}
	
	@Transactional
	public void atualizarCliente(Client cliente) {
		cliente = entityManager.merge(cliente);
		entityManager.persist(cliente);
	}

	
}
