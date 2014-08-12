package br.com.cts.model;

public class Cartao {
	private int idCartao;
	private String nomeCartao;
	private String bandeiraCartao;
	private int pocentagemDescontoCartao;
	
	public Cartao(){
		
	}
	
	public Cartao(int idCartao, String nomeCartao, String bandeiraCartao, int pocentagemDescontoCartao) {
		super();
		this.idCartao = idCartao;
		this.nomeCartao = nomeCartao;
		this.bandeiraCartao = bandeiraCartao;
		this.pocentagemDescontoCartao = pocentagemDescontoCartao;
	}
	
	public int getIdCartao() {
		return idCartao;
	}
	public void setIdCartao(int idCartao) {
		this.idCartao = idCartao;
	}
	public String getNomeCartao() {
		return nomeCartao;
	}
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	public String getBandeiraCartao() {
		return bandeiraCartao;
	}
	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}
	public int getPocentagemDescontoCartao() {
		return pocentagemDescontoCartao;
	}
	public void setPocentagemDescontoCartao(int pocentagemDescontoCartao) {
		this.pocentagemDescontoCartao = pocentagemDescontoCartao;
	}
}