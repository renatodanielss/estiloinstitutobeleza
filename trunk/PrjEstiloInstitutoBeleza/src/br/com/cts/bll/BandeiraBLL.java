package br.com.cts.bll;

import java.util.List;

import br.com.cts.dao.BandeiraDAO;
import br.com.cts.model.Bandeira;

public class BandeiraBLL {
	private BandeiraDAO bandeiraDao;
	
	public BandeiraBLL(){
		bandeiraDao = new BandeiraDAO();
	}
	
	public void salvar(Bandeira bandeira) throws Exception{
		bandeiraDao.salvar(bandeira);
	}
	
	public void alterar(Bandeira bandeira, String novoNome) throws Exception{
		bandeiraDao.Alterar(bandeira, novoNome);
	}
	
	public void excluir(Bandeira bandeira) throws Exception{
		bandeiraDao.Excluir(bandeira);
	}
	
	public List<Bandeira> procuraBandeira(int qtdPorPagina, int numeroDaPagina) throws Exception{
		return bandeiraDao.procuraBandeira(qtdPorPagina, numeroDaPagina);
	}
	
	public Bandeira procuraBandeiraPorId(String id) throws Exception{
		return bandeiraDao.procuraBandeiraPorId(id);
	}
	
	public List<Bandeira> procuraBandeiraPorNome(String nome, int qtdPorPagina, int numeroDaPagina) throws Exception{
		return bandeiraDao.procuraBandeiraPorNome(nome, qtdPorPagina, numeroDaPagina);
	}
	
	public int recordCount() throws Exception{
		return bandeiraDao.recordCount();
	}
	
	public int recordCount(String nome) throws Exception{
		return bandeiraDao.recordCount(nome);
	}
}