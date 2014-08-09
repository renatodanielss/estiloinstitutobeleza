package br.com.cts.bll;

import java.util.List;

import br.com.cts.dao.ClienteDAO;
import br.com.cts.model.Cliente;

public class ClienteBLL {
	private ClienteDAO clienteDao;
	
	public ClienteBLL(){
		clienteDao = new ClienteDAO();
	}
	
	public void salvar(Cliente cliente) throws Exception{
		clienteDao.salvar(cliente);
	}
	
	public void alterar(Cliente cliente) throws Exception{
		clienteDao.Alterar(cliente);
	}
	
	public void excluir(Cliente cliente) throws Exception{
		clienteDao.Excluir(cliente);
	}
	
	public List<Cliente> procuraCliente(int qtdPorPagina, int numeroDaPagina) throws Exception{
		return clienteDao.procuraCliente(qtdPorPagina, numeroDaPagina);
	}
	
	public Cliente procuraClientePorId(int id) throws Exception{
		return clienteDao.procuraClientePorId(id);
	}
	
	public List<Cliente> procuraClientePorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		return clienteDao.procuraClientePorNome(nome, qtdPorPagina, numeroDaPagina);
	}
	
	public int recordCount() throws Exception{
		return clienteDao.recordCount();
	}
	
	public int recordCount(String nome) throws Exception{
		return clienteDao.recordCount(nome);
	}
}