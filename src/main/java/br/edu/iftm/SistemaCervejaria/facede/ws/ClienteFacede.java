package br.edu.iftm.SistemaCervejaria.facede.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.SistemaCervejaria.dao.ClienteDao;
import br.edu.iftm.SistemaCervejaria.domain.Cliente;

public class ClienteFacede {
	@WebService(serviceName="ws/cliente")
	public class ClienteFacade {
		
		@Inject
		private ClienteDao clienteDao;
		
		@WebMethod
		public List<Cliente> getClientes() {
			List<Cliente> clientes = clienteDao.getClientes();
			for (Cliente cli: clientes) {
				
				cli.getCascos();
				cli.getCervejas();
				cli.setNome(null);
				
			}

		
			return clientes;
			}
		
		
		@WebMethod
		public Cliente getClienteId(@WebParam(name="codigoCliente") Integer id) {
			Cliente p = ClienteDao.getClienteId(id);
			if (p != null) {
				p.setParticipacoes(null);
				p.setProjetosAutor(null);	
			}
			return p;
		}
		
		@WebMethod
		public void excluirCliente(@WebParam(name="codigoCliente") Integer id) {
			clienteDao.excluirCliente(id);
		}
		
		@WebMethod
		public void atualizarCliente(@WebParam(name="Cliente") Cliente Cliente) {
			clienteDao.atualizarCliente(Cliente);
		}
		
		@WebMethod
		public void salvarCliente(@WebParam(name="Cliente") Cliente Cliente) {
			clienteDao.inserirCliente(Cliente);
		}
	}

}
