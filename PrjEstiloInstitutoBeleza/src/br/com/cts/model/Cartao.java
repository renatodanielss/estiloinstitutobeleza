package br.com.cts.model;

public class Cartao {
	private Integer idCartao;
	private String nomeCartao;
	private String bandeiraCartao;
	private Float pocentagemDescontoCartao;
	
	public Cartao(){
	}
	
	public Cartao(Integer idCartao, String nomeCartao, String bandeiraCartao, Float pocentagemDescontoCartao) {
		super();
		this.idCartao = idCartao;
		this.nomeCartao = nomeCartao;
		this.bandeiraCartao = bandeiraCartao;
		this.pocentagemDescontoCartao = pocentagemDescontoCartao;
	}
	
	public Integer getIdCartao() {
		return idCartao;
	}
	public void setIdCartao(Integer idCartao) {
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
	public Float getPocentagemDescontoCartao() {
		return pocentagemDescontoCartao;
	}
	public void setPocentagemDescontoCartao(Float pocentagemDescontoCartao) {
		this.pocentagemDescontoCartao = pocentagemDescontoCartao;
	}
}