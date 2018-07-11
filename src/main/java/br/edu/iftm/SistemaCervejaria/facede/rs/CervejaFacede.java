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

import br.edu.iftm.SistemaCervejaria.dao.CervejaDao;
import br.edu.iftm.SistemaCervejaria.domain.Cerveja;

@Path(value="/cerveja")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

public class CervejaFacede {
	@Inject
	private CervejaDao cervejaDao;
	
	@GET
	public List<Cerveja> getCervejas() {
		List<Cerveja> cervejas = cervejaDao.getCervejas();
		for (Cerveja cer: cervejas) {
			cer.setEstilo(null);
			cer.setFornecedor(null);
			cer.setHarmonizacao(null);
			cer.setHistoria(null);
			cer.setIbu(null);
			cer.setTeoralcoolico(null);
		}
		return cervejas;
	}
	
	@GET
	@Path("/{codigo}")
	public Cerveja getCervejaId(@PathParam(value="codigo") Integer id) {
		return cervejaDao.getCervejaId(id);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluirCerveja(@PathParam(value="codigo") Integer id) {
		cervejaDao.excluirCerveja(id);
	}
	
	@POST
	public void salvarCerveja(Cerveja pessoa) {
		cervejaDao.inserirCerveja(pessoa);
	}
	
	@PUT
	public void atualizarCerveja(Cerveja pessoa) {
		cervejaDao.atualizarCerveja(pessoa);
	}

}
