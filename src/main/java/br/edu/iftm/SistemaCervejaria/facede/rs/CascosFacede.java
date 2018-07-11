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

import br.edu.iftm.SistemaCervejaria.dao.CascosDao;
import br.edu.iftm.SistemaCervejaria.domain.Cascos;

@Path(value="/cascos")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

public class CascosFacede {
	@Inject
	private CascosDao cascosDao;
	
	@GET
	public List<Cascos> getCascoss() {
		List<Cascos> cascoss = cascosDao.getCascos();
		for (Cascos casc: cascoss) {
			casc.setCliente(null);
			casc.setQtdgrande(null);
			casc.setQtdpequena(null);

		}
		return cascoss;
	}
	
	@GET
	@Path("/{codigo}")
	public Cascos getCascosId(@PathParam(value="codigo") Integer id) {
		return cascosDao.getCascoId(id);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluirCascos(@PathParam(value="codigo") Integer id) {
		cascosDao.excluirCasco(id);
	}
	
	@POST
	public void salvarCascos(Cascos cascos) {
		cascosDao.inserirCasco(cascos);
	}
	
	@PUT
	public void atualizarCascos(Cascos cascos) {
		cascosDao.atualizarCasco(cascos);
	}

}
