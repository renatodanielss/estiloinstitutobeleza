package br.com.cts.bll;

import java.util.List;

import br.com.cts.dao.ClienteDAO;
import br.com.cts.model.Cliente;

public class ClienteBLL {
	private ClienteDAO clienteDao;
	
	public ClienteBLL() throws Exception{
		clienteDao = new ClienteDAO();
	}
	
	public void salvar(Cliente cliente) throws Exception{
		clienteDao.salvar(cliente);
	}
	
	public void Alterar(Cliente cliente) throws Exception{
		clienteDao.Alterar(cliente);
	}
	
	public void Excluir(Cliente cliente) throws Exception{
		clienteDao.Excluir(cliente);
	}
	
	public Cliente procuraClientePorId(int id) throws Exception{
		return clienteDao.procuraClientePorId(id);
	}
	
	public List<Cliente> procuraClientePorNome(String nome) throws Exception{
		return clienteDao.procuraClientePorNome(nome);
	}
}