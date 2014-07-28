package br.com.cts.model;

public class Cartao {
	private int id;
	private String nomeCartao;
	private String bandeira;
	private int pocentagemDesconto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCartao() {
		return nomeCartao;
	}
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public int getPocentagemDesconto() {
		return pocentagemDesconto;
	}
	public void setPocentagemDesconto(int pocentagemDesconto) {
		this.pocentagemDesconto = pocentagemDesconto;
	}
}