package br.com.cts.bll;

import java.util.List;

import br.com.cts.dao.CartaoDAO;
import br.com.cts.model.Cartao;

public class CartaoBLL {
	private CartaoDAO cartaoDao;
	
	public CartaoBLL(){
		cartaoDao = new CartaoDAO();
	}
	
	public void salvar(Cartao cartao) throws Exception{
		cartaoDao.salvar(cartao);
	}
	
	public void alterar(Cartao cartao) throws Exception{
		cartaoDao.Alterar(cartao);
	}
	
	public void excluir(Cartao cartao) throws Exception{
		cartaoDao.Excluir(cartao);
	}
	
	public List<Cartao> procuraCartao(int qtdPorPagina, int numeroDaPagina) throws Exception{
		return cartaoDao.procuraCartao(qtdPorPagina, numeroDaPagina);
	}
	
	public Cartao procuraCartaoPorId(int id) throws Exception{
		return cartaoDao.procuraCartaoPorId(id);
	}
	
	public List<Cartao> procuraCartaoPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		return cartaoDao.procuraCartaoPorNome(nome, qtdPorPagina, numeroDaPagina);
	}
	
	public int recordCount() throws Exception{
		return cartaoDao.recordCount();
	}
	
	public int recordCount(String nome) throws Exception{
		return cartaoDao.recordCount(nome);
	}
}