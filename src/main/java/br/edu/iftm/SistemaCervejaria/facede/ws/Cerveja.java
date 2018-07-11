package br.edu.iftm.SistemaCervejaria.facede.ws;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.SistemaCervejaria.dao.CervejaDao;
import br.edu.iftm.SistemaCervejaria.domain.Cerveja;



public class Cerveja {
	@WebService(serviceName="ws/cerveja")
	public class CervejaFacade {
		
		@Inject
		private CervejaDao cervejaDao;
		
		@WebMethod
		public List<Cerveja> getCervejaes() {
			List<Cerveja> cervejas = cervejaDao.getCervejas();
			for (Cerveja p: cervejas) {
				
			}
			return cervejas;
		}
		
		@WebMethod
		public Cerveja getCervejaId(@WebParam(name="codigoCerveja") Integer id) {
			Cerveja f = cervejaDao.getCervejaId(id);
			if (f != null) {
				
			}

			
			return f;
		}
		
		@WebMethod
		public void excluirCerveja(@WebParam(name="codigoCerveja") Integer id) {
			fornecedorDao.excluirCerveja(id);
		}
		
		@WebMethod
		public void atualizarCerveja(@WebParam(name="Cerveja") Cerveja cerveja) {
			fornecedorDao.atualizarCerveja(cerveja);
		}
		
		@WebMethod
		public void salvarCerveja(@WebParam(name="cerveja") Cerveja cerveja) {
			fornecedorDao.inserirCerveja(cerveja);
		}

}
	

}
