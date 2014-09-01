package br.com.cts.bll;

import java.util.List;

import br.com.cts.dao.FuncaoDAO;
import br.com.cts.model.Funcao;

public class FuncaoBLL {
	private FuncaoDAO funcaoDao;
	
	public FuncaoBLL(){
		funcaoDao = new FuncaoDAO();
	}
	
	public void salvar(Funcao funcao) throws Exception{
		funcaoDao.salvar(funcao);
	}
	
	public void alterar(Funcao funcao) throws Exception{
		funcaoDao.Alterar(funcao);
	}
	
	public void excluir(Funcao funcao) throws Exception{
		funcaoDao.Excluir(funcao);
	}
	
	public List<Funcao> procuraFuncao(int qtdPorPagina, int numeroDaPagina) throws Exception{
		return funcaoDao.procuraFuncao(qtdPorPagina, numeroDaPagina);
	}
	
	public Funcao procuraFuncaoPorId(int id) throws Exception{
		return funcaoDao.procuraFuncaoPorId(id);
	}
	
	public List<Funcao> procuraFuncaoPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		return funcaoDao.procuraFuncaoPorNome(nome, qtdPorPagina, numeroDaPagina);
	}
	
	public int recordCount() throws Exception{
		return funcaoDao.recordCount();
	}
	
	public int recordCount(String nome) throws Exception{
		return funcaoDao.recordCount(nome);
	}
}