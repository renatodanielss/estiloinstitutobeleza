package br.com.cts.model;

public class Produto {
	private int idProduto;
	private String nomeProduto;
	private Float valorProduto;
	private Float valorPraVendaProduto;
	private String tipoUnidadeProduto;
	private int qtdEstoqueProduto;

	public Produto(){
	}
	
	public Produto(int idProduto, String nomeProduto, Float valorProduto, Float valorPraVendaProduto, String tipoUnidadeProduto, int qtdEstoqueProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.valorPraVendaProduto = valorPraVendaProduto;
		this.tipoUnidadeProduto = tipoUnidadeProduto;
		this.qtdEstoqueProduto = qtdEstoqueProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Float getValorPraVendaProduto() {
		return valorPraVendaProduto;
	}

	public void setValorPraVendaProduto(Float valorPraVendaProduto) {
		this.valorPraVendaProduto = valorPraVendaProduto;
	}

	public String getTipoUnidadeProduto() {
		return tipoUnidadeProduto;
	}

	public void setTipoUnidadeProduto(String tipoUnidadeProduto) {
		this.tipoUnidadeProduto = tipoUnidadeProduto;
	}

	public int getQtdEstoqueProduto() {
		return qtdEstoqueProduto;
	}

	public void setQtdEstoqueProduto(int qtdEstoqueProduto) {
		this.qtdEstoqueProduto = qtdEstoqueProduto;
	}
}