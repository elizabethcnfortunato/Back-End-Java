package br.edu.iftm.SistemaCervejaria.facede.rs;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;


import br.edu.iftm.SistemaCervejaria.dao.ClienteDao;

import br.edu.iftm.SistemaCervejaria.domain.Cliente;


@Path(value="/cliente")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

public class ClienteFacede {
	@Inject
	private ClienteDao clienteDao;
	
	@GET
	public List<Cliente> getclientes() {
		List<Cliente> clientes = clienteDao.getClientes();
		for (Cliente cli: clientes) {
			cli.setCervejas(null);
			cli.setEndereco(null);
			cli.setNome(null);
			cli.getCascos();
		}
		return clientes;
	}

}
