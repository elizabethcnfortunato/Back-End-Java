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
import javax.ws.rs.core.MediaType;

import br.edu.iftm.SistemaCervejaria.dao.FornecedorDao;
import br.edu.iftm.SistemaCervejaria.domain.Fornecedor;

@Path(value="/fornecedor")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

public class FornecedorFacede {
	@Inject
	private FornecedorDao fornecedorDao;
	
	@GET
	public List<Fornecedor> getFornecedors() {
		List<Fornecedor> fornecedores = fornecedorDao.getFornecedores();
		for (Fornecedor f: fornecedores) {
			
			f.setNome(null);
			f.setEmail(null);
			f.setNome(null);
			f.setResponsavel(null);
			f.setTelefone(null);
			f.setCervejas(null);
		}
		return fornecedores;
	}
	
	@GET
	@Path("/{codigo}")
	public Fornecedor getFornecedorId(@PathParam(value="codigo") Integer id) {
		return fornecedorDao.getFornecedorId(id);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluirFornecedor(@PathParam(value="codigo") Integer id) {
		fornecedorDao.excluirFornecedor(id);
	}
	
	@POST
	public void salvarFornecedor(Fornecedor fornecedor) {
		fornecedorDao.inserirFornecedor(fornecedor);
	}
	
	@PUT
	public void atualizarFornecedor(Fornecedor fornecedor) {
		fornecedorDao.atualizarFornecedor(fornecedor);
	}

}
