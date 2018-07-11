package br.edu.iftm.SistemaCervejaria.facede.ws;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.SistemaCervejaria.dao.FornecedorDao;
import br.edu.iftm.SistemaCervejaria.domain.Fornecedor;


public class FornecedorFacede {
	@WebService(serviceName="ws/fornecedor")
	public class FornecedorFacade {
		
		@Inject
		private FornecedorDao fornecedorDao;
		
		@WebMethod
		public List<Fornecedor> getFornecedores() {
			List<Fornecedor> fornecedores = fornecedorDao.getFornecedores();
			for (Fornecedor p: fornecedores) {
				
			}
			return fornecedores;
		}
		
		@WebMethod
		public Fornecedor getFornecedorId(@WebParam(name="codigoFornecedor") Integer id) {
			Fornecedor f = fornecedorDao.getFornecedorId(id);
			if (f != null) {
				f.getCervejas();
				f.setNome(null);
				f.setResponsavel(null);
				f.setTelefone(null);
			}

			
			return f;
		}
		
		@WebMethod
		public void excluirFornecedor(@WebParam(name="codigoFornecedor") Integer id) {
			fornecedorDao.excluirFornecedor(id);
		}
		
		@WebMethod
		public void atualizarFornecedor(@WebParam(name="Fornecedor") Fornecedor pessoa) {
			fornecedorDao.atualizarFornecedor(pessoa);
		}
		
		@WebMethod
		public void salvarFornecedor(@WebParam(name="pessoa") Fornecedor pessoa) {
			fornecedorDao.inserirFornecedor(pessoa);
		}

}
}
