package br.com.cts.bll;

import java.util.List;

import br.com.cts.dao.ProdutoDAO;
import br.com.cts.model.Produto;

public class ProdutoBLL {
	private ProdutoDAO produtoDao;
	
	public ProdutoBLL(){
		produtoDao = new ProdutoDAO();
	}
	
	public void salvar(Produto produto) throws Exception{
		produtoDao.salvar(produto);
	}
	
	public void alterar(Produto produto) throws Exception{
		produtoDao.Alterar(produto);
	}
	
	public void excluir(Produto produto) throws Exception{
		produtoDao.Excluir(produto);
	}
	
	public List<Produto> procuraProduto(int qtdPorPagina, int numeroDaPagina) throws Exception{
		return produtoDao.procuraProdutos(qtdPorPagina, numeroDaPagina);
	}
	
	public Produto procuraProdutoPorId(int id) throws Exception{
		return produtoDao.procuraProdutoPorId(id);
	}
	
	public List<Produto> procuraProdutoPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		return produtoDao.procuraProdutoPorNome(nome, qtdPorPagina, numeroDaPagina);
	}
	
	public int recordCount() throws Exception{
		return produtoDao.recordCount();
	}
	
	public int recordCount(String nome) throws Exception{
		return produtoDao.recordCount(nome);
	}
}